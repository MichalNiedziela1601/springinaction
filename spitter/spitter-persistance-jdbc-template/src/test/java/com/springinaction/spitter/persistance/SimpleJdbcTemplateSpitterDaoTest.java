package com.springinaction.spitter.persistance;

import com.springinaction.spitter.domain.Spitter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceTestConfig.class)
public class SimpleJdbcTemplateSpitterDaoTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private SpitterDao spitterDao;

    @Before
    public void setUp() throws Exception {
        spitterDao = new SimpleJdbcTemplateSpitterDao(jdbcTemplate);
    }

    @Test
    public void givenSpitterWhenSaveShouldPersistEntity() throws Exception {
        Spitter spitter = new Spitter();
        spitter.setUsername("spitter1");
        spitter.setPassword("password");
        spitter.setFullName("spitter1 spitfire");
        spitter.setEmail("spitter1@example.com");
        spitter.setUpdateByEmail(false);

        spitterDao.addSpitter(spitter);
        System.out.println(spitter.getId());

        Spitter result = spitterDao.getSpitterById(1);

        assertNotNull(result);
        assertEquals(spitter.getUsername(), result.getUsername());
        assertEquals(spitter.getPassword(),result.getPassword());
        assertEquals(spitter.getFullName(),result.getFullName());
        assertEquals(spitter.getEmail(),result.getEmail());
        assertEquals(spitter.isUpdateByEmail(),result.isUpdateByEmail());
    }
}