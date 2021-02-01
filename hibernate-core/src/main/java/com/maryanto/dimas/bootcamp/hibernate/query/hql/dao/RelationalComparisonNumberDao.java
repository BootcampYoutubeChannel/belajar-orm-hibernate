package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RelationalComparisonNumberDao {

    private Session session;

    public RelationalComparisonNumberDao(Session session) {
        this.session = session;
    }

    public List<KelasManyToOneEntity> findEqualByTahunAngkatan(Integer angkatan) {
        //language=HQL
        String hql = "from KelasManyToOneEntity where angkatan = :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findNotSameByTahunAngkatan(Integer angkatan) {
        String hql = "from KelasManyToOneEntity where angkatan != :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findNotEqualByTahunAngkatan(Integer angkatan) {
        String hql = "from KelasManyToOneEntity where angkatan <> :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findHigherByTahunAngkatan(Integer angkatan) {
        String hql = "from KelasManyToOneEntity where angkatan > :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findHigherThenByTahunAngkatan(Integer angkatan) {
        String hql = "from KelasManyToOneEntity where angkatan >= :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findLowerByTahunAngkatan(Integer angkatan) {
        String hql = "from KelasManyToOneEntity where angkatan < :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findLowerThanByTahunAngkatan(Integer angkatan) {
        String hql = "from KelasManyToOneEntity where angkatan <= :angkatan";
        Query<KelasManyToOneEntity> query = this.session.createQuery(hql, KelasManyToOneEntity.class);
        return query.setParameter("angkatan", angkatan)
                .getResultList();
    }
}
