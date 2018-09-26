package com.spitter.dao.impl;

import com.spitter.config.DataSourceConfig;
import com.spitter.dao.SpitterDao;
import com.spitter.model.Spitter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
public class SpitterDaoImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SpitterDao spitterDao;

    @Before
    public void setUp() throws Exception {
        spitterDao = new SpitterDaoImpl(jdbcTemplate);
    }

    @Test
    public void selectSpitterByIdShouldReturnSpitter() throws Exception {
        long id = 0L;
        Spitter spitter = spitterDao.getSPitterByID(id);

//        assertNotNull(spitter);
        assertEquals(0, spitter.getId().longValue());
    }


    @Test
    public void addSpitterTest() throws Exception {
        Spitter spitter = new Spitter();
        spitter.setUsername("sp1");
        spitter.setPassword("password");
        spitter.setFullName("spitter craig");
        spitter.setEmail("sp1@example.com");
        spitter.setUpdateByEmail(false);

        spitterDao.addSpitter(spitter);

        Spitter spitter1 = spitterDao.getSPitterByID(2);
        assertEquals("sp1", spitter1.getUsername());
        assertEquals("password", spitter1.getPassword());
        assertEquals("spitter craig", spitter1.getFullName());
        assertEquals(spitter.getEmail(), spitter1.getEmail());
        assertEquals(spitter.isUpdateByEmail(), spitter1.isUpdateByEmail());

    }

}