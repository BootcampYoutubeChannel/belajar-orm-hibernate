package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.AlamatOneToManyDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.KelasManyToOneDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.MahasiswaManyToOneDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.MahasiswaOneToManyDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.AlamatOneToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToManyEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Ignore
@Slf4j
public class TestMahasiswaManyToOneMapping extends TestCase {


    private Session session;
    private MahasiswaManyToOneDao mahasiswaDao;
    private KelasManyToOneDao kelasDao;


    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mahasiswaDao = new MahasiswaManyToOneDao(session);
        this.kelasDao = new KelasManyToOneDao(session);
    }

    @Test
    public void testOpenConnection() {
        this.session.beginTransaction();

        KelasManyToOneEntity is01 = KelasManyToOneEntity.builder()
                .nama("IS-01")
                .angkatan(2011)
                .programStudi("Informatika")
                .build();

        is01 = this.kelasDao.save(is01);

        MahasiswaManyToOneEntity dimas = MahasiswaManyToOneEntity.builder()
                .kelas(is01)
                .nama("Dimas Maryanto")
                .tahunMasuk(2012)
                .nim("10512148")
                .tanggalLahir(LocalDate.of(1993, 3, 1))
                .build();

        dimas = this.mahasiswaDao.save(dimas);
        log.info("mahasiswa baru: {}", dimas);

        MahasiswaManyToOneEntity yusuf = MahasiswaManyToOneEntity.builder()
                .kelas(is01)
                .nama("Muhamad Yusuf")
                .tahunMasuk(2012)
                .nim("10512150")
                .tanggalLahir(LocalDate.of(1992, 1, 1))
                .build();

        yusuf = this.mahasiswaDao.save(yusuf);
        log.info("mahasiswa baru: {}", yusuf);
        this.session.getTransaction().commit();
    }

    @Test
    public void testFindByIdKelas() {
        this.session.beginTransaction();

        Optional<KelasManyToOneEntity> optional = this.kelasDao.findById("4c366dc1-dfb0-4fc5-8d04-fb2497a0cbec");
        assertTrue("kelas is present", optional.isPresent());

        KelasManyToOneEntity kelas = optional.get();
        log.info("kelas: {}", kelas);

        log.info("list mahasiswa: {}", kelas.getListMahasiswa());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
