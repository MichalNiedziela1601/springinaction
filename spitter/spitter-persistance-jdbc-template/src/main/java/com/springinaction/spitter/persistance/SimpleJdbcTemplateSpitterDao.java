package com.springinaction.spitter.persistance;

import com.springinaction.spitter.domain.Spitter;
import com.springinaction.spitter.domain.Spittle;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SimpleJdbcTemplateSpitterDao implements SpitterDao {

    private static final String SQL_INSERT_SPITTER =
            "INSERT INTO spitter(username, password, fullname, email, update_by_email) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, fullname, password, email, update_by_email from spitter where id = ?";

    private JdbcTemplate jdbcTemplate;

    public SimpleJdbcTemplateSpitterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        spitter.setId(queryForIdentity());
    }

    private Long queryForIdentity() {
        return jdbcTemplate.queryForObject("call identity()", Long.class);
    }

    @Override
    public void saveSpitter(Spitter spitter) {

    }

    @Override
    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER,
                (rs, rowNum) -> {
                    Spitter spitter = new Spitter();
                    spitter.setId(rs.getLong("id"));
                    spitter.setUsername(rs.getString("username"));
                    spitter.setPassword(rs.getString("password"));
                    spitter.setFullName(rs.getString("fullname"));
                    spitter.setEmail(rs.getString("email"));
                    spitter.setUpdateByEmail(rs.getBoolean("update_by_email"));
                    return spitter;
                }, id
        );
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {

    }

//    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return null;
    }

    @Override
    public void deleteSpittle(long id) {

    }

    @Override
    public Spittle getSpittleById(long id) {
        return null;
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return null;
    }
}
