package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsValueMahasiswaEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.EmptyCollectionDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestEmptyCollectionDao extends TestCase {

    private Session session;
    private EmptyCollectionDao emptyCollectionDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.emptyCollectionDao = new EmptyCollectionDao(session);
    }

    @Test
    public void testMethodAsType() {
        List<CollectionAsEmbeddedMahasiswa> list = this.emptyCollectionDao.emptyCollectionAsType();
        assertEquals("list is empty", 0, list.size());
        log.info("list is empty: {}", list);

        list = this.emptyCollectionDao.notEmptyCollectionAsType();
        assertEquals("list is not empty", 2, list.size());
        log.info("list is not empty: {}", list);
    }

    @Test
    public void testMethodAsValue() {
        List<CollectionAsValueMahasiswaEntity> list = this.emptyCollectionDao.emptyCollectionAsValue();
        assertEquals("list is empty", 0, list.size());
        log.info("list is empty: {}", list);

        list = this.emptyCollectionDao.notEmptyCollectionAsValue();
        assertEquals("list is not empty", 1, list.size());
        log.info("list is not empty: {}", list);
    }

    @Test
    public void testMethodAsEntity() {
        List<MahasiswaOneToManyEntity> list = this.emptyCollectionDao.emptyCollectionAsEntity();
        assertEquals("list is empty", 0, list.size());
        log.info("list is empty: {}", list);

        list = this.emptyCollectionDao.notEmptyCollectionAsEntity();
        assertEquals("list is not empty", 3, list.size());
        log.info("list is not empty: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}

