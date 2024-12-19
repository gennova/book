package com.tendydeveloper.book.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

public class AbstractDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AbstractDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = jdbcTemplate;
    }

    NamedParameterJdbcTemplate getJdbcTemplate(){
        return namedParameterJdbcTemplate;
    }
}
