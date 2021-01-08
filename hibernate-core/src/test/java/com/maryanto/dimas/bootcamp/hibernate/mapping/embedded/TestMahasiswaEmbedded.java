package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.dao.MahasiswaEmbeddedDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.AlamatEmbeddable;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbedded;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

@Ignore
@Slf4j
public class TestMahasiswaEmbedded extends TestCase {

    private Session session;
    private MahasiswaEmbeddedDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaEmbeddedDao(session);
    }

    @Test
    public void testInsertValid() {
        MahasiswaEmbedded mhs = MahasiswaEmbedded.builder()
                .nim("15011150")
                .nama("Dimas Maryanto")
                .tahunMasuk(2011)
                .tanggalLahir(LocalDate.of(1991, 3, 3))
                .alamat(AlamatEmbeddable.builder()
                        .provinsi("Jawa Barat")
                        .kota("Kab. Bandung")
                        .kelurahan("Cinunuk")
                        .kecamatan("Cileuyi")
                        .rt(6)
                        .rw(18)
                        .kodePos("40526")
                        .build()
                ).build();

        this.session.beginTransaction();
        mhs = this.dao.save(mhs);
        this.session.getTransaction().commit();

        Optional<MahasiswaEmbedded> mahasiswaOptional = this.dao.findById(mhs.getId());
        assertTrue("mahasiswa present: {}", mahasiswaOptional.isPresent());
        log.info("mahasiswa => {}", mahasiswaOptional.get());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
