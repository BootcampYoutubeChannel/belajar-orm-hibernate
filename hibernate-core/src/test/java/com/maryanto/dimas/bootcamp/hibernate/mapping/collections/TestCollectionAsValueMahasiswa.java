package com.maryanto.dimas.bootcamp.hibernate.mapping.collections;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.dao.CollectionAsValueMahasiswaDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsValueMahasiswaEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class TestCollectionAsValueMahasiswa extends TestCase {

    private Session session;
    private CollectionAsValueMahasiswaDao mahasiswaDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mahasiswaDao = new CollectionAsValueMahasiswaDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
        Transaction trx = this.session.beginTransaction();
        CollectionAsValueMahasiswaEntity dimasMaryanto = CollectionAsValueMahasiswaEntity.builder()
                .name("Dimas Maryanto")
                .nim("10511148")
                .address("Bandung")
                .contacts(Arrays.asList("082111234", "082111235")).build();
        dimasMaryanto = this.mahasiswaDao.save(dimasMaryanto);
        trx.commit();
        log.info("mahasiswa: {}", dimasMaryanto);
    }

    @Test
    public void testFindById() {
        Transaction trx = this.session.beginTransaction();

        Optional<CollectionAsValueMahasiswaEntity> optional = this.mahasiswaDao.findById(9L);
        assertTrue("mahasiswa is present ", optional.isPresent());
        CollectionAsValueMahasiswaEntity dimasMaryanto = optional.get();
        log.info("mahasiswa: {}", dimasMaryanto);
        log.info("contacts: {}", dimasMaryanto.getContacts());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
