package com.konghulu.interview.enums;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: za-lining
 * @date: 2019/1/17
 **/
public enum LevelCategoryEnum {

    HIGH(1, "Product&Eligibility"),
    MID(2, "Cover and Benefits"),
    LOW(3, "Premium and Payment");

    private Integer code;

    private String desc;

    LevelCategoryEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static LevelCategoryEnum get(Integer code) {
        for (LevelCategoryEnum faqCategoryEnum : LevelCategoryEnum.values()) {
            if (faqCategoryEnum.getCode().equals(code)) {
                return faqCategoryEnum;
            }
        }
        return null;
    }

    public static List<Pair<Integer, String>> getAll() {
        List<Pair<Integer, String>> result = new ArrayList<>();
        for (LevelCategoryEnum faqCategoryEnum : LevelCategoryEnum.values()) {
            result.add(new Pair<>(faqCategoryEnum.getCode(), faqCategoryEnum.getDesc()));
        }
        return result;
    }
}
