package com.maryanto.dimas.bootcamp.hibernate.mapping.collections;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.dao.CollectionAsEmbeddedMahasiswaDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.dao.CollectionAsValueMahasiswaDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsValueMahasiswaEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.AlamatEmbeddable;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class TestCollectionAsEmbeddedMahasiswa extends TestCase {

    private Session session;
    private CollectionAsEmbeddedMahasiswaDao mahasiswaDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mahasiswaDao = new CollectionAsEmbeddedMahasiswaDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
        Transaction trx = this.session.beginTransaction();
        CollectionAsEmbeddedMahasiswa dimasMaryanto = CollectionAsEmbeddedMahasiswa.builder()
                .name("Dimas Maryanto")
                .nim("10511148")
                .addresses(Arrays.asList(
                        AlamatEmbeddable.builder()
                                .provinsi("Jawa Barat")
                                .kota("Kab. Bandung")
                                .kecamatan("Cinunuk")
                                .kelurahan("Cileunyi")
                                .namaJalan("Jl. Bukit Indah NO B8")
                                .rw(16)
                                .rt(7)
                                .kodePos("40526")
                                .build(),
                        AlamatEmbeddable.builder()
                                .provinsi("DKI Jakarta")
                                .kota("Jakarta Selatan")
                                .kecamatan("Cipete")
                                .kelurahan("Melawai")
                                .rw(10)
                                .rt(1)
                                .namaJalan("Jl. Damai Buntu")
                                .kodePos("42105")
                                .build(),
                        AlamatEmbeddable.builder()
                                .provinsi("DKI Jakarta")
                                .kota("Jakarta Pusat")
                                .kecamatan("Kemayoran")
                                .kelurahan("Gambir")
                                .rw(10)
                                .rt(1)
                                .namaJalan("Jl. Damai Buntu")
                                .kodePos("42105")
                                .build()
                ))
                .build();
        dimasMaryanto = this.mahasiswaDao.save(dimasMaryanto);
        trx.commit();
        log.info("mahasiswa: {}", dimasMaryanto);
    }

    @Test
    public void testFindById() {
        Transaction trx = this.session.beginTransaction();
        Optional<CollectionAsEmbeddedMahasiswa> optional = this.mahasiswaDao.findById(11L);
        assertTrue("mahasiswa is present ", optional.isPresent());
        CollectionAsEmbeddedMahasiswa dimasMaryanto = optional.get();
        log.info("mahasiswa: {}", dimasMaryanto);
        log.info("alamat: {}", dimasMaryanto.getAddresses());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
