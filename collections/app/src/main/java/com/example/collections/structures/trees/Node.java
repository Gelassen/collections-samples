package com.example.collections.structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by John on 8/4/2016.
 */
public class Node<T> {
    private List<Node<T>> children;
    private Node<T> parent;
    private T value;

    public Node(T node) {
        value = node;
        children = new ArrayList<>();
    }

    public Node<T> findByValue(Node<T> node, T value) {
        if (node.value == value) return this;

        Node<T> result = null;
        for (Node<T> child : children) {
            result = findByValue(child, value);
            if (result != null) return this;
        }

        return result;
    }

    public boolean findPath(T value, LinkedList<Node<T>> path) {
        path.push(this);
        if (this.value == value) return true;

        for (Node<T> node : children) {
            if (node.findPath(value, path)) return true;
            path.pop();
        }
        return false;
    }

    public void addChild(T child) {
        Node<T> childNode = new Node<>(child);
        childNode.parent = this;
        children.add(childNode);
    }

    public void addParent(Node<T> parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getParent() {
        return parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }
}
