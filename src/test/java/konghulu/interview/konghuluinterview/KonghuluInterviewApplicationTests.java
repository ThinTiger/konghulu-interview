package konghulu.interview.konghuluinterview;

import com.konghulu.interview.annotation.AliasForTest;
import com.konghulu.interview.domain.TreeNode;
import com.konghulu.interview.server.KonghuluInterviewApplication;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KonghuluInterviewApplication.class)
@AliasForTest(value = "a")
public class KonghuluInterviewApplicationTests {

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

    /**
     * null + "-" + null会发生什么
     */
    @Test
    public void testNullOperation() {
        System.out.println(null + "-" + null);
    }
}
