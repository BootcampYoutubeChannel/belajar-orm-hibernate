package com.maryanto.dimas.bootcamp.hibernate;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest extends TestCase {

    private Session session;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
    }

    @Test
    public void testConnection() {
        this.session.beginTransaction();
        log.info("connected");
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
