package com.maryanto.dimas.bootcamp.hibernate.transaksi;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.dao.nasabah.NasabahDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.nasabah.NasabahDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.dao.transaksi.ProdukTabunganDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.transaksi.ProdukTabunganDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.dao.transaksi.RekeningTabunganDao;
import com.maryanto.dimas.bootcamp.hibernate.dao.transaksi.RekeningTabunganDaoImpl;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.Nasabah;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahPerorangan;
import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.ProdukTabungan;
import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.RekeningTabungan;
import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.TransaksiTabungan;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
public class TestRekeningTabunganDao extends TestCase {

    private Session session;
    private NasabahDao nasabahDao;
    private ProdukTabunganDao produkDao;
    private RekeningTabunganDao rekeningDao;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
        this.nasabahDao = new NasabahDaoImpl(session);
        this.produkDao = new ProdukTabunganDaoImpl(session);
        this.rekeningDao = new RekeningTabunganDaoImpl(session);
    }

    @Test
    public void testSaveRekeningTabunganPerseorangan() {
        Optional<NasabahPerorangan> optionalNasabah = this.nasabahDao.findNasabahPeroranganById("36da6552-74bb-454a-87f9-600a03b8bc1a");
        assertTrue("nasabah is present ", optionalNasabah.isPresent());
        NasabahPerorangan nasabah = optionalNasabah.orElse(null);

        Optional<ProdukTabungan> optionalProduk = produkDao.findById("tabunganku");
        ProdukTabungan produk = optionalProduk.orElse(null);

        Transaction trx = this.session.beginTransaction();
        RekeningTabungan rekeningTabungan = RekeningTabungan.builder()
                .nasabah(nasabah)
                .produk(produk)
                .biayaAdmin(produk.getBiayaAdmin())
                .sukuBunga(produk.getSukuBunga())
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .saldoCurrent(BigDecimal.ZERO)
                .build();
        rekeningTabungan = this.rekeningDao.save(rekeningTabungan);
        log.info("rekening: {}", rekeningTabungan);
        this.rekeningDao.setoran(rekeningTabungan, new BigDecimal(100_000));
        trx.commit();
    }

    @Test
    public void testSetoranRekeningPerorangan() {
        Transaction trx = this.session.beginTransaction();

        Optional<RekeningTabungan> optionalRekening = this.rekeningDao.findById("4de65484-6211-467a-a95c-1a3ae7fad169");
        RekeningTabungan rekeningTabungan = optionalRekening.orElse(null);
        this.rekeningDao.setoran(rekeningTabungan, new BigDecimal(1_000_000));
        trx.commit();
    }

    @Test
    public void testCetakRekeningTabungan() {
        Optional<RekeningTabungan> optionalRekening = this.rekeningDao.findById("4de65484-6211-467a-a95c-1a3ae7fad169");
        RekeningTabungan rekeningTabungan = optionalRekening.orElse(null);
        log.info("nama: {}\n" +
                        "no_rekening: {}", rekeningTabungan.getNasabah().getNamaKepemilikan(),
                rekeningTabungan.getId());

        StringBuilder table = new StringBuilder();
        for (TransaksiTabungan trx : rekeningTabungan.getListTransaksi()) {
            table.append("|").append(trx.getDebit()).append("|").append(trx.getKredit()).append("|").append(trx.getSaldo()).append("\n");
        }
        log.info("{}", table.toString());
    }


    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
