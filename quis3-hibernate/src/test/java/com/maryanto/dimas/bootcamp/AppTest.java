package com.maryanto.dimas.bootcamp;

import com.maryanto.dimas.bootcamp.config.HibernateConfiguration;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

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
