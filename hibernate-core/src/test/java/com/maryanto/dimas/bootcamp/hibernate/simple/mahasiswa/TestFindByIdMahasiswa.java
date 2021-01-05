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
import java.util.Optional;

@Slf4j
@Ignore
public class TestFindByIdMahasiswa extends TestCase {

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
        this.session.beginTransaction();
//        save data and then return auto generated id
        Long mahasiswaId = 3L;
        Optional<Mahasiswa> mahasiswaOptional = this.dao.findById(mahasiswaId);
        assertTrue("object mahasiswa not null", mahasiswaOptional.isPresent());
        log.info("mahasiswa by id {} => {}", mahasiswaId, mahasiswaOptional.orElse(null));
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
