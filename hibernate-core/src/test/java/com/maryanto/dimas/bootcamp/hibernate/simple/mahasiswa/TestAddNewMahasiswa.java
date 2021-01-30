package com.maryanto.dimas.bootcamp.hibernate.simple.mahasiswa;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.simple.dao.MahasiswaDao;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Ignore
public class TestAddNewMahasiswa extends TestCase {

    private Session session;
    private MahasiswaDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
//        init value
        Mahasiswa mahasiswa = Mahasiswa.builder()
                .kode(1L)
                .nim("10511151")
                .nama("Dimas Maryanto")
                .active(true)
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .tglLahir(LocalDate.of(1990, 1, 1))
                .thnMasuk(2011).build();

        this.session.beginTransaction();
//        save data and then return auto generated id
        mahasiswa = this.dao.save(mahasiswa);

//        commit
        this.session.getTransaction().commit();

        log.info("mahasiswa saved: {}", mahasiswa);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
