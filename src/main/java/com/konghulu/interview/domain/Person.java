package com.konghulu.interview.domain;

import com.konghulu.interview.enums.LevelCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private Integer id;

    private String name;

    private Byte age;

    private String eName;

    private LevelCategoryEnum level;
}
