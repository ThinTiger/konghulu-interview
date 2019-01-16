package com.konghulu.interview.test;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.konghulu.interview.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                new Person(1, "阿胜", (byte) 18, "Tony"),
                new Person(2, "阿进", (byte) 19, "Pony"),
                new Person(2, "阿嘉", (byte) 20, "Cony")
        );
    }

    @Test
    public void OptionalTest() {
        List<Person> newList = Optional.ofNullable(nullList)
                .orElse(Collections.emptyList());

        log.info("newList---" + newList);

        List<Integer> idList = Optional.ofNullable(normalList)
                .map(l -> l.stream().map(Person::getId).collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        log.info("idList---" + idList);

        Optional.of(normalList)
                .ifPresent(x -> x.stream()
                        .filter(item -> item.getAge() > 18)
                        .forEach(item -> log.info("filterItem---" + item.getName())));

        Integer findId = normalList.stream()
                .filter(x -> x.getName().equals("阿进"))
                .findFirst().map(Person::getId).orElse(-1);

        log.info("findId---" + findId);

        findId = normalList.stream()
                .filter(x -> x.getName().equals("阿海"))
                .findFirst().map(Person::getId).orElseGet(() -> normalList.get(0).getId());

        log.info("findId---" + findId);
    }

    @Test
    public void CollectorsTest() {
        Map<Integer, Person> personMap = normalList.stream()
                .collect(Collectors.toMap(Person::getId, x -> x, (o, n) -> n));

        log.info("newMap---" + personMap);
    }

    @Test
    public void mapTest() {
        List<String> lowerNameList = normalList.stream().map(Person::getEName).map(String::toLowerCase).collect(Collectors.toList());

        log.info("lowerNameList---" + lowerNameList);
    }

    @Test
    public void multiFunctionTest() {
        System.out.println(multiGetResult(
            Arrays.asList(
                    list -> list.stream().collect(Collectors.summarizingInt(x -> x)),
                    list -> list.stream().filter(x -> x < 50).sorted().collect(Collectors.toList()),
                    list -> list.stream().collect(Collectors.groupingBy(x -> (x % 2 == 0 ? "even" : "odd"))),
                    list -> list.stream().sorted().collect(Collectors.toList()),
                    list -> list.stream().sorted().map(Math::sqrt).collect(Collectors.toMap(x -> x, y -> Math.pow(2, y)))),
            Arrays.asList(64, 49, 25, 16, 9, 4, 1, 81, 36)));

    }

    public <T, R> List<R> multiGetResult(List<Function<List<T>, R>> functions, List<T> list) {
        return functions.stream().map(f -> f.apply(list)).collect(Collectors.toList());
    }
}
