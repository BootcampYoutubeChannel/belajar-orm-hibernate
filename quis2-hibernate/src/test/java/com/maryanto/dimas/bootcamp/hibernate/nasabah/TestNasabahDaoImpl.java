package com.maryanto.dimas.bootcamp.hibernate.nasabah;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.dao.nasabah.NasabahDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.nasabah.NasabahDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.dao.wilayah.KelurahanDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.wilayah.KelurahanDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.Nasabah;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahBadanUsaha;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahPerorangan;
import com.maryanto.dimas.bootcamp.hibernate.entity.wilayah.Kelurahan;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class TestNasabahDaoImpl extends TestCase {

    private Session session;
    private KelurahanDao kelurahanDao;
    private NasabahDao nasabahDao;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
        this.kelurahanDao = new KelurahanDaoImpl(session);
        this.nasabahDao = new NasabahDaoImpl(session);
    }

    @Test
    public void testSaveNasabahPerorangan() {
        Optional<Kelurahan> optionalKelurahan = this.kelurahanDao.findById("cinunuk");
        assertTrue("kelurahan is present", optionalKelurahan.isPresent());

        Kelurahan kelurahan = optionalKelurahan.orElse(null);
        Nasabah dimasMaryanto = NasabahPerorangan.builder()
                .namaKepemilikan("Dimas Maryanto")
                .cif("044234")
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .kelurahan(kelurahan)
                .noIdentitas("3200072900007")
                .namaIbuKandung("test")
                .noTelp("082117444444")
                .tanggalLahir(LocalDate.of(1999, 1, 1))
                .build();

        Transaction trx = this.session.beginTransaction();
        dimasMaryanto = this.nasabahDao.save(dimasMaryanto);
        assertNotNull("id not null", dimasMaryanto.getId());
        log.info("data: {}", dimasMaryanto);
        trx.commit();
    }

    @Test
    public void testFindByIdNasabah() {
        Optional<NasabahPerorangan> optional = this.nasabahDao.findNasabahPeroranganById("c5f2ff19-fa4c-4a0c-a543-adb1ba538ca2");
        assertTrue("data is present", optional.isPresent());
        log.info("data: {}", optional.get());
    }

    @Test
    public void testSaveNasabahBadanUsaha() {
        Optional<Kelurahan> optionalKelurahan = this.kelurahanDao.findById("permata-biru");
        assertTrue("kelurahan is present", optionalKelurahan.isPresent());

        Kelurahan kelurahan = optionalKelurahan.orElse(null);
        Nasabah multipolar = NasabahBadanUsaha.builder()
                .cif("05551223")
                .namaKepemilikan("PT. Multipolar Teknology")
                .kelurahan(kelurahan)
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .noIdentitas("12343214134")
                .noTelp("021123434")
                .noAktaTerakhir("123456")
                .noSiup("12343241324")
                .build();

        Transaction trx = this.session.beginTransaction();
        multipolar = this.nasabahDao.save(multipolar);
        assertNotNull("id not null", multipolar.getId());
        log.info("data: {}", multipolar);
        trx.commit();
    }

    @Test
    public void testFindByIdNasabahBadanUsaha() {
        Optional<NasabahBadanUsaha> optional = this.nasabahDao.findNasabahBadanUsahaById("35a5e4ca-7438-429d-8698-20c9930255a7");
        assertTrue("data is present", optional.isPresent());
        log.info("data: {}", optional.get());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
