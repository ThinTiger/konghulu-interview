package com.konghulu.interview.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;

    private String name;

    private Byte age;

    private String eName;
}
