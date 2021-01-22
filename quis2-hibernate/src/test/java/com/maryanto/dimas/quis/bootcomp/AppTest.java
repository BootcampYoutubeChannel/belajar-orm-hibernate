package com.maryanto.dimas.quis.bootcomp;

import com.maryanto.dimas.quis.bootcomp.config.HibernateConfiguration;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Slf4j
public class AppTest extends TestCase {

    private Session session;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
    }

    public void testConnection() {
        Transaction trx = this.session.beginTransaction();
        log.info("connected!");
    }

    @Override
    protected void tearDown() throws Exception {
        this.session.close();
    }
}
