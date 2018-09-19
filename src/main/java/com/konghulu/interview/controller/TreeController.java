package com.konghulu.interview.controller;

import com.konghulu.interview.domain.TreeNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lining
 * @date 2018-09-18
 */
@RestController
@RequestMapping("tree")
public class TreeController {

    public TreeController(){
        TreeNode binaryTree = new TreeNode();
    }

    @RequestMapping("/findnode")
    public String findDeepestAndRightmostNode(){

        return "find node!~";
    }
}
