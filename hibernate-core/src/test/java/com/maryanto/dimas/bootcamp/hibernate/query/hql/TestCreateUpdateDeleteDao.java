package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.CreateUpdateDeleteStatementDao;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class TestCreateUpdateDeleteDao extends TestCase {

    private Session session;
    private CreateUpdateDeleteStatementDao crudDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.crudDao = new CreateUpdateDeleteStatementDao(session);
    }

    @Test
    public void testDeleteById() {
        Transaction trx = this.session.beginTransaction();
        Mahasiswa mahasiswaBaru = Mahasiswa.builder()
                .nama("matakuliah baru")
                .nim("1051234")
                .kode(10L)
                .tglLahir(LocalDate.now())
                .thnMasuk(LocalDate.now().getYear())
                .biodata("test")
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .build();
        mahasiswaBaru = this.crudDao.save(mahasiswaBaru);

        Optional<Mahasiswa> optional = this.crudDao.findById(mahasiswaBaru.getKode());
        assertTrue("matakuliah is present", optional.isPresent());

        boolean result = this.crudDao.removeById(mahasiswaBaru.getKode());
        log.info("Data berhasil di hapus? {}", result);
        trx.commit();

        optional = this.crudDao.findById(mahasiswaBaru.getKode());
        assertFalse("matakuliah is not present", optional.isPresent());

    }

    @Test
    public void testUpdateData() {
        Transaction trx = this.session.beginTransaction();
        String namaMahasiswaLama = "Dimas maryanto";
        String namaMahasiswaUpdated = "Muhamad Yusuf";
        Mahasiswa mahasiswaBaru = Mahasiswa.builder()
                .nama(namaMahasiswaLama)
                .nim("1051234")
                .kode(10L)
                .tglLahir(LocalDate.now())
                .thnMasuk(LocalDate.now().getYear())
                .biodata("test")
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .build();
        mahasiswaBaru = this.crudDao.save(mahasiswaBaru);
        assertEquals("nama matakuliah sebelum di update", mahasiswaBaru.getNama(), namaMahasiswaLama);
        log.info("sebelum di updated: {}", mahasiswaBaru);

        Mahasiswa mahasiswaLama = mahasiswaBaru;
        mahasiswaLama.setNama(namaMahasiswaUpdated);

        this.crudDao.update(mahasiswaLama);
        trx.commit();

        Optional<Mahasiswa> optional = this.crudDao.findById(mahasiswaBaru.getKode());
        assertTrue("matakuliah is present", optional.isPresent());
        mahasiswaBaru = optional.get();
        assertEquals("nama matakuliah seteleh di update", mahasiswaBaru.getNama(), namaMahasiswaUpdated);
        log.info("setelah di updated: {}", mahasiswaBaru);

        Transaction trx2 = this.session.beginTransaction();
        this.crudDao.removeById(mahasiswaBaru.getKode());
        trx2.commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
