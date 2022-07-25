package com.code.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @name: CommonMapper
 * @author: mubai.
 * @date: 2022/7/25
 * @version: 1.0
 * @description:
 */
public interface CommonMapper {
    boolean findExist(@Param("dbSql") String dbSql);
}
