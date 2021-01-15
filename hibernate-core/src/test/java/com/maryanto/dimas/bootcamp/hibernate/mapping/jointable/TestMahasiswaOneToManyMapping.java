package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.AlamatOneToManyDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao.MahasiswaOneToManyDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.AlamatOneToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToManyEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class TestMahasiswaOneToManyMapping extends TestCase {


    private Session session;
    private MahasiswaOneToManyDao mahasiswaDao;
    private AlamatOneToManyDao alamatDao;


    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mahasiswaDao = new MahasiswaOneToManyDao(session);
        this.alamatDao = new AlamatOneToManyDao(session);
    }

    @Test
    public void testOpenConnection() {
        this.session.beginTransaction();
        AlamatOneToManyEntity rumahDimas = AlamatOneToManyEntity.builder().provinsi("Jawa Barat")
                .kecamatan("Cinunuk")
                .kelurahan("Cileunyi")
                .kodePos(40526)
                .kota("Kab. Bandung")
                .namaJalan("Jl Bukit indah B8")
                .rt(6)
                .rw(18)
                .build();
        rumahDimas = this.alamatDao.save(rumahDimas);


        AlamatOneToManyEntity rumahDomisili = AlamatOneToManyEntity.builder().provinsi("Jawa Barat")
                .kecamatan("Cipete")
                .kelurahan("Fatmawati")
                .kodePos(20123)
                .kota("Jakarta Selatan")
                .namaJalan("Jl damai buntu")
                .rt(6)
                .rw(18)
                .build();
        rumahDomisili = this.alamatDao.save(rumahDomisili);

        MahasiswaOneToManyEntity dimas = MahasiswaOneToManyEntity.builder()
                .nama("Dimas Maryanto")
                .nim("10511151")
                .tahunMasuk(2011)
                .tanggalLahir(LocalDate.of(1993, 3, 1))
                .listAlamat(Arrays.asList(rumahDimas, rumahDomisili))
                .build();

        dimas = this.mahasiswaDao.save(dimas);

        Optional<MahasiswaOneToManyEntity> optional = this.mahasiswaDao.findById(dimas.getId());
        assertTrue("mahasiswa is present", optional.isPresent());

        MahasiswaOneToManyEntity dataSaved = optional.get();
        assertEquals("namanya adalah ", dimas.getNama(), dataSaved.getNama());

        assertEquals("jumlah alamat", dataSaved.getListAlamat().size(), 2);
        this.session.getTransaction().commit();
        log.info("data: {}", dataSaved);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
