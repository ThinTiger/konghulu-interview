package com.konghulu.interview.domain;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class TreeNode {

    private TreeNode leftTreeNode;

    private TreeNode rightTreeNode;

    private Integer value;

    /**
     * 根据传入参数初始化一棵完全二叉树
     *
     * @param nodeValues 二叉树节点
     */
    public TreeNode(List<Integer> nodeValues) {
        //初始化临时队列
        List<TreeNode> tempList = Lists.newArrayList();
        for (int i = 0; i < nodeValues.size(); i++) {
            TreeNode treeNode = null;
            if (i == 0) {
                //初始化当前对象为根节点
                this.value = nodeValues.get(i);
                treeNode = this;
            } else {
                treeNode = new TreeNode(nodeValues.get(i), null, null);
            }
            tempList.add(treeNode);
        }

        boolean lastChildNodeSingle = true;
        int endIndex = tempList.size() / 2 - 1;
        if (tempList.size() % 2 == 1) {
            lastChildNodeSingle = false;
        }
        //从队列构造二叉树
        for (int i = 0; i <= endIndex; i++) {
            TreeNode tempNode = tempList.get(i);
            tempNode.setLeftTreeNode(tempList.get(2 * i + 1));
            if (i == endIndex && lastChildNodeSingle) {
                break;
            }
            tempNode.setRightTreeNode(tempList.get(2 * i + 2));
        }
    }

    /**
     * 初始化一个树节点
     *
     * @param value
     */
    private TreeNode(Integer value, TreeNode leftTreeNode, TreeNode rightTreeNode) {
        this.value = value;
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
    }

    public static void DLR(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        DLR(node.leftTreeNode);
        DLR(node.rightTreeNode);
    }
}
