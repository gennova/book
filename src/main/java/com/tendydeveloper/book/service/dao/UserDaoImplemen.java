package com.tendydeveloper.book.service.dao;

import com.tendydeveloper.book.service.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Slf4j
@Repository
public class UserDaoImplemen extends AbstractDao implements UserDao
{
    private static final String SQL_GET_ALL_USER = "select * from user";
    private static final String SQL_GET_USER_BY_ID = "select * from user where id = :id";

    public UserDaoImplemen(NamedParameterJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<User> getAllUser() {
        log.info("Fetching user from database");
        return getJdbcTemplate().query(SQL_GET_ALL_USER, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getUserById(int id) {
        log.info("Fetching user from database");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",id);
        return getJdbcTemplate().queryForObject(SQL_GET_USER_BY_ID, params, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User createUser(User user) {
        log.info("Saving user to database");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",user.getId());
        params.addValue("email",user.getEmail());
        params.addValue("firstname",user.getFirstname());
        params.addValue("lastname",user.getLastname());
        params.addValue("username",user.getUsername());
        params.addValue("password",user.getPassword());
        getJdbcTemplate().update("insert into user(email,firstname,lastname,username,password) values (:email,:firstname,:lastname,:username,:password)", params);
        return user;
    }

    @Override
    public void updateUser(User user) {
        log.info("Updating user to database");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",user.getId());
        params.addValue("email",user.getEmail());
        params.addValue("firstname",user.getFirstname());
        params.addValue("lastname",user.getLastname());
        params.addValue("username",user.getUsername());
        params.addValue("password",user.getPassword());
        getJdbcTemplate().update("update", params);
    }

    @Override
    public void deleteUser(int id) {
        log.info("Deleting user from database");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",id);
        getJdbcTemplate().update("delete from user where id = :id", params);
    }


}
