package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.MahasiswaManyToManyDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.MatakuliahManyToManyDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaManyToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MatakuliahManyToManyEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
public class TestMahasiswaManyToManyMapping extends TestCase {

    private Session session;
    private MahasiswaManyToManyDao mahasiswaDao;
    private MatakuliahManyToManyDao matakuliahDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mahasiswaDao = new MahasiswaManyToManyDao(session);
        this.matakuliahDao = new MatakuliahManyToManyDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
        Transaction trx = this.session.beginTransaction();

        MatakuliahManyToManyEntity pemogramanJava = new MatakuliahManyToManyEntity();
        pemogramanJava.setSks(3);
        pemogramanJava.setNama("Pemograman Java 1");
        pemogramanJava = this.matakuliahDao.save(pemogramanJava);

        MatakuliahManyToManyEntity skripsi = MatakuliahManyToManyEntity.builder()
                .sks(6)
                .nama("SKRIPSI")
                .build();
        skripsi = this.matakuliahDao.save(skripsi);

        Set<MatakuliahManyToManyEntity> ambilMatakuliah = new HashSet<>();
        ambilMatakuliah.add(pemogramanJava);
        ambilMatakuliah.add(skripsi);

        MahasiswaManyToManyEntity dimas = MahasiswaManyToManyEntity.builder()
                .nama("Dimas Maryanto")
                .tahunMasuk(2012)
                .nim("10512148")
                .tanggalLahir(LocalDate.of(1993, 3, 1))
                .listMatakuliah(ambilMatakuliah)
                .build();

        dimas = this.mahasiswaDao.save(dimas);
        log.info("mahasiswa baru: {}", dimas);

        MahasiswaManyToManyEntity yusuf = MahasiswaManyToManyEntity.builder()
                .nama("Muhamad Yusuf")
                .tahunMasuk(2012)
                .nim("10512150")
                .tanggalLahir(LocalDate.of(1992, 1, 1))
                .listMatakuliah(ambilMatakuliah)
                .build();

        yusuf = this.mahasiswaDao.save(yusuf);
        log.info("mahasiswa baru: {}", yusuf);
        trx.commit();
    }

    @Test
    public void testFindMahasiswaId() {
        this.session.beginTransaction();
        Optional<MahasiswaManyToManyEntity> optional = this.mahasiswaDao.findById("9e8b0765-918f-496d-8d43-d04221adf281");
        assertTrue("mahasiswa not present!", optional.isPresent());
        MahasiswaManyToManyEntity mahasiswa = optional.get();
        log.info("mahasiswa: {}", mahasiswa);
        log.info("list matakuliah {\nsize: {}, \ndata: {}\n}", mahasiswa.getListMatakuliah().size(), mahasiswa.getListMatakuliah());
    }

    @Test
    public void testFindMatakuliahId() {
        this.session.beginTransaction();
        Optional<MatakuliahManyToManyEntity> optional = this.matakuliahDao.findById("612eac0c-8b70-472c-9b3b-9354a54af3a6");
        assertTrue("kelas not present!", optional.isPresent());
        MatakuliahManyToManyEntity kelas = optional.get();
        log.info("kelas: {}", kelas);
        log.info("list mahasiswa {\nsize: {}, \ndata: {}\n}", kelas.getListMahasiswa().size(), kelas.getListMahasiswa());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
