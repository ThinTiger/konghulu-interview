package konghulu.interview.konghuluinterview;

import com.konghulu.interview.annotation.AliasForTest;
import com.konghulu.interview.server.KonghuluInterviewApplication;
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

    @Test
    public void testAliasforBySpring() {
        AliasForTest annotation = AnnotationUtils.findAnnotation(getClass(), AliasForTest.class);
        System.out.println(annotation.value());
        System.out.println(annotation.alias());
    }
}
