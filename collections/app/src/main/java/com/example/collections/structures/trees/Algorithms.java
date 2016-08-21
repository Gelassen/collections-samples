package com.example.collections.structures.trees;

/**
 * Created by John on 8/21/2016.
 */
public class Algorithms<T> {

    public Node<T> findLowestCommonAncestorInBinaryTree(Node<T> root, Node<T> leftSearch, Node<T> rightSearch) {
        if (root == null) return null;
        if (leftSearch == root || rightSearch == root) return root;

        Node<T> leftNode = findLowestCommonAncestorInBinaryTree(root.getChildren().get(0), leftSearch, rightSearch);
        Node<T> rightNode = findLowestCommonAncestorInBinaryTree(root.getChildren().get(1), leftSearch, rightSearch);

        if (leftNode == null && rightNode == null) {
            return null;
        } else if (leftNode != null && rightNode != null) {
            return root;
        } else {
            return leftNode != null ? leftNode : rightNode;
        }
    }
}
