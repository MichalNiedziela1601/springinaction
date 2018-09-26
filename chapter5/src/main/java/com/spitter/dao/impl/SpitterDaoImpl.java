package com.spitter.dao.impl;

import com.spitter.dao.SpitterDao;
import com.spitter.model.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class SpitterDaoImpl implements SpitterDao {

    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, update_by_email) values (?,?,?,?,?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, fullname, password, email, update_by_email from spitter where id = ?";

    private JdbcTemplate jdbcTemplate;

    public SpitterDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail()
                );
    }

    @Override
    public void updateSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getId()
        );
    }

    @Override
    public Spitter getSPitterByID(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER,
                new RowMapper<Spitter>() {
                    @Override
                    public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(resultSet.getLong(1));
                        spitter.setUsername(resultSet.getString(2));
                        spitter.setFullName(resultSet.getString(3));
                        spitter.setPassword(resultSet.getString(4));
                        spitter.setEmail(resultSet.getString(5));
                        spitter.setUpdateByEmail(resultSet.getBoolean(6));
                        return spitter;
                    }
                }, id
        );
    }
}
