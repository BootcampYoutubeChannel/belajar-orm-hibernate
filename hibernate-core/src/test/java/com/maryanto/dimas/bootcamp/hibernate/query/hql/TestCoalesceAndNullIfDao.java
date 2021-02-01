package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.CoalesceAndNullIfDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

@Slf4j
public class TestCoalesceAndNullIfDao extends TestCase {

    private Session session;
    private CoalesceAndNullIfDao nullDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.nullDao = new CoalesceAndNullIfDao(session);
    }

    @Test
    public void testCoalesceFunction() {
        String data = this.nullDao.findAlamatMahasiswaCoalesce(8L);
        assertNotNull(data);
        log.info("data: {}", data);
    }


    @Test
    public void testNullIfFunction() {
        String data = this.nullDao.findAlamatMahasiswaNullIf(8L);
        assertNull(data);
        log.info("data beda: {}", data);

        data = this.nullDao.findAlamatMahasiswaNullIf(9L);
        assertNull(data);
        log.info("data sama: {}", data);

        data = this.nullDao.findAlamatMahasiswaNullIf(10L);
        assertNotNull(data);
        log.info("data sama: {}", data);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
