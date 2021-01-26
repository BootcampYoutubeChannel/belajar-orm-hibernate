package com.maryanto.dimas.bootcamp.hibernate.transaksi;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.dao.wilayah.KelurahanDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.wilayah.KelurahanDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.entity.wilayah.Kecamatan;
import com.maryanto.dimas.bootcamp.hibernate.entity.wilayah.Kelurahan;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class TestWilayahDaoImpl extends TestCase {

    private Session session;
    private KelurahanDao kelurahanDao;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
        this.kelurahanDao = new KelurahanDaoImpl(session);
    }

    @Test
    public void testDataWilayahFindById() {
        Optional<Kelurahan> optional = this.kelurahanDao.findById("cinunuk");
        assertTrue("kelurahan assertTrue", optional.isPresent());
        Kelurahan data = optional.get();
        assertEquals("data kelurahan", "Cinunuk", data.getNama());
        Kecamatan kecamatan = data.getKecamatan();
        assertEquals("data kecamatan", "Cileunyi", kecamatan.getNama());
        log.info("data: {}", data);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
