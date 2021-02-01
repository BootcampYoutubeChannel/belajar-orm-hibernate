package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CoalesceAndNullIfDao {

    private Session session;

    public CoalesceAndNullIfDao(Session session) {
        this.session = session;
    }

    public String findAlamatMahasiswaCoalesce(Long id) {
        //language=HQL
        String hql = "select coalesce(alamatOrangtua.provinsi, alamatRumah.provinsi, 'Tidak memiliki alamat') \n" +
                "from MahasiswaEmbeddedOverrideAttributes \n" +
                "where id = :id";
        Query<String> query = this.session.createQuery(hql, String.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    public String findAlamatMahasiswaNullIf(Long id) {
        //language=HQL
        String hql = "select nullif(alamatOrangtua.provinsi, alamatRumah.provinsi) \n" +
                "from MahasiswaEmbeddedOverrideAttributes \n" +
                "where id = :id";
        Query<String> query = this.session.createQuery(hql, String.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }
}
