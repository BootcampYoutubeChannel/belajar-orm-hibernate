package com.maryanto.dimas.bootcamp.hibernate.dao.transaksi;

import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.ProdukTabungan;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.Optional;

public class ProdukTabunganDaoImpl implements ProdukTabunganDao {

    private Session session;

    public ProdukTabunganDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<ProdukTabungan> findById(String value) {
        try {
            ProdukTabungan data = this.session.find(ProdukTabungan.class, value);
            return data != null ? Optional.of(data) : Optional.empty();
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }
}
