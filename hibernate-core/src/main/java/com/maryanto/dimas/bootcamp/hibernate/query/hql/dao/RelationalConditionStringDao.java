package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RelationalConditionStringDao {

    private Session session;

    public RelationalConditionStringDao(Session session) {
        this.session = session;
    }

    public List<KelasManyToOneEntity> findEqualBy(String namaKelas) {
        //language=HQL
        String hql = "from KelasManyToOneEntity where nama = :namaKelas";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class)
                .setParameter("namaKelas", namaKelas);
        return query.getResultList();
    }

    public List<KelasManyToOneEntity> findNotEqualBy(String namaKelas) {
        //language=HQL
        String hql = "from KelasManyToOneEntity where nama <> :namaKelas";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class)
                .setParameter("namaKelas", namaKelas);
        return query.getResultList();
    }

    public List<KelasManyToOneEntity> findNotSameBy(String namaKelas) {
        //language=HQL
        String hql = "from KelasManyToOneEntity where nama != :namaKelas";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class)
                .setParameter("namaKelas", namaKelas);
        return query.getResultList();
    }
}

