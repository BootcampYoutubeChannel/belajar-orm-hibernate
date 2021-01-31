package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.query.dto.ArithmeticModel;
import com.maryanto.dimas.bootcamp.hibernate.query.dto.ConcatnationModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ConcatnationDao {

    private Session session;

    public ConcatnationDao(Session session) {
        this.session = session;
    }

    public List<ConcatnationModel> functionConcat() {
        //language=HQL
        String hql = "select new com.maryanto.dimas.bootcamp.hibernate.query.dto.ConcatnationModel(\n" +
                "     msh.nama, \n" +
                "     concat(alm.provinsi, ', ', alm.kota, ', ', alm.namaJalan)\n" +
                ")\n" +
                "from MahasiswaOneToOneEntity msh join AlamatOneToOneEntity alm on (msh.alamat = alm)";
        Query<ConcatnationModel> query = this.session.createQuery(hql, ConcatnationModel.class);
        return query.getResultList();
    }

    public List<ConcatnationModel> operatorConcat() {
        //language=HQL
        String hql = "select new com.maryanto.dimas.bootcamp.hibernate.query.dto.ConcatnationModel(\n" +
                "     msh.nama, \n" +
                "     alm.provinsi || ', ' || alm.kota || ', ' || alm.namaJalan\n" +
                ")\n" +
                "from MahasiswaOneToOneEntity msh join AlamatOneToOneEntity alm on (msh.alamat = alm)";
        Query<ConcatnationModel> query = this.session.createQuery(hql, ConcatnationModel.class);
        return query.getResultList();
    }
}
