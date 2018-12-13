package konghulu.interview.konghuluinterview;

import com.google.common.collect.Lists;
import com.konghulu.interview.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: thinTiger
 * @date: 2018/12/13
 **/
@Slf4j
public class LambdaTests extends BaseApplicationTest {

    List<Person> nullList;

    List<Person> empltyList;

    List<Person> normalList;

    public LambdaTests() {
        nullList = null;
        empltyList = Lists.newArrayList();
        normalList = Lists.newArrayList(
                new Person(1, "阿胜", (byte) 18),
                new Person(2, "阿进", (byte) 19),
                new Person(2, "阿嘉", (byte) 20)
        );
    }

    @Test
    public void OptionalTest() {
        List<Person> newList = Optional.ofNullable(nullList)
                .orElse(Collections.emptyList());

        log.info("newList---" + newList);
    }

    @Test
    public void MapTest() {
        Map<Integer, Person> personMap = normalList.stream()
                .collect(Collectors.toMap(Person::getId, x -> x, (o, n) -> n));

        log.info("newMap---" + personMap);
    }
}
