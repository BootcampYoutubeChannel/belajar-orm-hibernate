package com.maryanto.dimas.bootcamp.hibernate.wilayah;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.dao.transaksi.ProdukTabunganDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.transaksi.ProdukTabunganDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.ProdukTabungan;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class TestProdukTabungan extends TestCase {

    private Session session;
    private ProdukTabunganDao produkDao;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
        this.produkDao = new ProdukTabunganDaoImpl(session);
    }

    @Test
    public void testFindById() {
        Optional<ProdukTabungan> optional = this.produkDao.findById("tabunganku");
        assertTrue("optional is present", optional.isPresent());
        ProdukTabungan produk = optional.orElse(null);
        assertEquals("nama produk", "TabunganKu", produk.getNama());
        log.info("data: {}", produk);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
