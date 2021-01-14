package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.AlamatOneToOneDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.MahasiswaOneToOneDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.AlamatOneToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToOneEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;

@Slf4j
public class TestMahasiswaOneToOneMapping extends TestCase {

    private Session session;
    private MahasiswaOneToOneDao mahasiswaDao;
    private AlamatOneToOneDao alamatDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mahasiswaDao = new MahasiswaOneToOneDao(session);
        this.alamatDao = new AlamatOneToOneDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
        this.session.beginTransaction();

        AlamatOneToOneEntity rumahDimas = AlamatOneToOneEntity.builder().provinsi("Jakarta")
                .kecamatan("Cipete")
                .kelurahan("asldkjfdsf")
                .kodePos(2033434)
                .kota("Jakarta Selatan")
                .namaJalan("alskjkldsfjlksdfh")
                .rt(6)
                .rw(18)
                .build();

        rumahDimas = this.alamatDao.save(rumahDimas);

        MahasiswaOneToOneEntity dimas = MahasiswaOneToOneEntity.builder()
                .nama("Dimas Maryanto")
                .nim("10511150")
                .tahunMasuk(2011)
                .tanggalLahir(LocalDate.of(1993, 3, 1))
                .alamat(rumahDimas)
                .build();

        dimas = this.mahasiswaDao.save(dimas);
        log.info("mahasiswa baru: {}", dimas);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
