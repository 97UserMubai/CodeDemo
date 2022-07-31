package com.code.entity.es;

import lombok.Data;

/**
 * @name: Hero
 * @author: mubai.
 * @date: 2022/7/26
 * @version: 1.0
 * @description:
 */
@Data
public class Hero {
    private Integer id;
    private String name;
    private String country;
    private String birthday;
    private Integer longevity;
}
