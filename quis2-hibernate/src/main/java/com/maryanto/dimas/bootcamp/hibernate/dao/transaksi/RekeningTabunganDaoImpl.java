package com.maryanto.dimas.bootcamp.hibernate.dao.transaksi;

import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.RekeningTabungan;
import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.TransaksiTabungan;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class RekeningTabunganDaoImpl implements RekeningTabunganDao {

    private Session session;

    public RekeningTabunganDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public RekeningTabungan save(RekeningTabungan value) {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    @Deprecated
    public RekeningTabungan update(RekeningTabungan value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public RekeningTabungan setoran(RekeningTabungan value, BigDecimal jumlahSetoran) {
        BigDecimal saldoCurrent = value.getSaldoCurrent();
        saldoCurrent = saldoCurrent.add(jumlahSetoran);
        value.setSaldoCurrent(saldoCurrent);
        this.session.update(value);

        TransaksiTabungan setoran = TransaksiTabungan.builder()
                .rekening(value)
                .debit(BigDecimal.ZERO)
                .kredit(jumlahSetoran)
                .saldo(value.getSaldoCurrent())
                .tanggal(LocalDateTime.now()).build();
        this.session.save(setoran);
        return value;
    }

    @Override
    public RekeningTabungan penarikan(RekeningTabungan value, BigDecimal jumlahPenarikan) {
        BigDecimal saldoCurrent = value.getSaldoCurrent();
        saldoCurrent = saldoCurrent.subtract(jumlahPenarikan);
        value.setSaldoCurrent(saldoCurrent);
        this.session.update(value);

        TransaksiTabungan penarikan = TransaksiTabungan.builder()
                .rekening(value)
                .debit(jumlahPenarikan)
                .kredit(BigDecimal.ZERO)
                .saldo(value.getSaldoCurrent())
                .tanggal(LocalDateTime.now()).build();
        this.session.save(penarikan);
        return value;
    }

    @Override
    public Optional<RekeningTabungan> findById(String value) {
        try {
            RekeningTabungan data = this.session.find(RekeningTabungan.class, value);
            return data != null ? Optional.of(data) : Optional.empty();
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }
}
