package com.ron.springbootshiro.common.util;

import com.ron.springbootshiro.common.domain.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树生成工具
 */
public class TreeUtil {

    public static <T> Tree<T> build(List<Tree<T>> nodes){
        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach(children -> {
            String pid = children.getParentId();
            if (pid == null || "0".equals(pid)) {
                topNodes.add(children);
                return;
            }
            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setHasChildren(true);
                    return;
                }
            }
        });

        Tree<T> root = new Tree<>();
        root.setId("0");
        root.setParentId("");
        root.setHasParent(false);
        root.setChecked(true);
        root.setHasChildren(true);
        root.setChildren(topNodes);
        root.setText("根节点");
        Map<String, Object> state = new HashMap<>(16);
        state.put("opened", true);
        root.setState(state);
        return root;
    }

}
