package com.konghulu.interview.test;

import com.konghulu.interview.annotation.AliasForTest;
import com.konghulu.interview.domain.MyCondition;
import com.konghulu.interview.domain.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

@AliasForTest(value = "a")
@Slf4j
public class KonghuluInterviewApplicationTests extends BaseApplicationTest {

    @Test
    public void testAliasfor() {
        AliasForTest annotation = getClass().getAnnotation(AliasForTest.class);
        System.out.println(annotation.value());
        System.out.println(annotation.alias());
    }

    /**
     * AnnotationUtils.findAnnotation(line 702)->
     * AnnotationUtils.synthesizeAnnotation(line 1505)->
     * new SynthesizedAnnotationInvocationHandler(line 91) ->
     * AbstractAliasAwareAnnotationAttributeExtractor<S>.getAttributeValue(line 97)->
     * DefaultAnnotationAttributeExtractor.getRawAttributeValue(line 60)
     */
    @Test
    public void testAliasforBySpring() {
        AliasForTest annotation = AnnotationUtils.findAnnotation(getClass(), AliasForTest.class);
        System.out.println(annotation.value());
        System.out.println(annotation.alias());
    }

    /**
     * 完全二叉树
     */
    @Test
    public void fullBinaryTree() {
        TreeNode tree = new TreeNode(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        TreeNode.DLR(tree);
    }

    @Test
    public void testNullOperation() {
        System.out.println(null + "-" + null);
    }

    @Test
    public void testEnv(){
        System.out.println(System.getProperty("DEPLOY_ENV"));
        System.out.println(System.getenv("DEPLOY_ENV"));
        System.out.println(System.getProperty("JAVA_HOME"));
        System.out.println(System.getenv("JAVA_HOME"));
    }

    @Test
    public void testLog(){
        MyCondition condition = new MyCondition();
        condition.setClaimType(1);
        condition.setInsurerId(11l);
        log.info("test log:{}", condition);
    }
}
