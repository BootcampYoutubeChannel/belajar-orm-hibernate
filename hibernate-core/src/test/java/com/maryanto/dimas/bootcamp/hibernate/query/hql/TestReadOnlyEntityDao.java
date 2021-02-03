package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.ReadOnlyEntityDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

@Slf4j
public class TestReadOnlyEntityDao extends TestCase {

    private Session session;
    private ReadOnlyEntityDao readOnlyDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.readOnlyDao = new ReadOnlyEntityDao(session);
    }

    @Test
    public void testFindAndUpdatedAuto() {
        Transaction trx = this.session.beginTransaction();
        Optional<CollectionAsEmbeddedMahasiswa> optional = this.readOnlyDao.findById(11L);
        assertTrue("is pressent", optional.isPresent());
        CollectionAsEmbeddedMahasiswa empl = optional.get();
        empl.setName(UUID.randomUUID().toString());
        trx.commit();
    }

    @Test
    public void testFindAndReadOnly() {
        Transaction trx = this.session.beginTransaction();
        Optional<CollectionAsEmbeddedMahasiswa> optional = this.readOnlyDao.findByIdReadOnly(11L);
        assertTrue("is pressent", optional.isPresent());
        CollectionAsEmbeddedMahasiswa empl = optional.get();
        empl.setName(UUID.randomUUID().toString());

        trx.commit();
    }


    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
