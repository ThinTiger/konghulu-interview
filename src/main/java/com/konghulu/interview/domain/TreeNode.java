package com.konghulu.interview.domain;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode {

    private TreeNode leftTreeNode;

    private TreeNode rightTreeNode;

    private Integer value;

    /**
     * 根据传入参数初始化一棵二叉树
     * @param nodeValues 二叉树节点
     */
    public TreeNode(List<Integer> nodeValues){

    }

    public TreeNode(){

    }
}
