package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToOneEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class JoinEntityStatementDao {

    private Session session;

    public JoinEntityStatementDao(Session session) {
        this.session = session;
    }

    public List<MahasiswaOneToOneEntity> findByProvinsiWithImplicitJoin(String provinsi) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity mhs\n" +
                "where mhs.alamat.provinsi = :namaProvinsi";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("namaProvinsi", provinsi);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findByProvinsiWithExplicitJoinOn(String provnisi) {
        //language=HQL
        String hql = "select mhs from MahasiswaOneToOneEntity mhs \n" +
                "    join AlamatOneToOneEntity al on (mhs.alamat = al)\n" +
                "where al.provinsi = :namaProvinsi";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("namaProvinsi", provnisi);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findByProvinsiWithExplicitJoinWith(String provnisi) {
        //language=HQL
        String hql = "select mhs from MahasiswaOneToOneEntity mhs \n" +
                "    join AlamatOneToOneEntity al with mhs.alamat = al\n" +
                "where al.provinsi = :namaProvinsi";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("namaProvinsi", provnisi);
        return query.getResultList();
    }
}
