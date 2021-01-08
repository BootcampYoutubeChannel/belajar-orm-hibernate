package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.dao.MahasiswaEmbeddedOverrideAttributesDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.AlamatEmbeddable;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbeddedOverrideAttributes;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;

@Ignore
@Slf4j
public class TestMahasiswaEmbeddedOverrideAttributes extends TestCase {

    private Session session;
    private MahasiswaEmbeddedOverrideAttributesDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaEmbeddedOverrideAttributesDao(session);
    }

    @Test
    public void testInsertValid() {
        MahasiswaEmbeddedOverrideAttributes mhs = MahasiswaEmbeddedOverrideAttributes.builder()
                .nim("15011148")
                .nama("Dimas Maryanto")
                .tahunMasuk(2011)
                .tanggalLahir(LocalDate.of(1991, 3, 3))
                .alamatRumah(AlamatEmbeddable.builder()
                        .provinsi("Jawa Barat")
                        .kota("Kab. Bandung")
                        .kelurahan("Cinunuk")
                        .kecamatan("Cileuyi")
                        .rt(6)
                        .rw(18)
                        .kodePos("40526")
                        .namaJalan("Jl. Bukit Indah No B8")
                        .build()
                )
                .build();

        this.session.beginTransaction();
        this.dao.save(mhs);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
