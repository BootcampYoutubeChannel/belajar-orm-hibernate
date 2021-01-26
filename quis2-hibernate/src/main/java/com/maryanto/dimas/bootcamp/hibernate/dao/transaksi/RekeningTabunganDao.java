package com.maryanto.dimas.bootcamp.hibernate.dao.transaksi;

import com.maryanto.dimas.bootcamp.hibernate.entity.transaksi.RekeningTabungan;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;

import java.math.BigDecimal;

public interface RekeningTabunganDao extends CrudRepository<RekeningTabungan, String> {

    RekeningTabungan setoran(RekeningTabungan value, BigDecimal jumlahSetoran);

    RekeningTabungan penarikan(RekeningTabungan value, BigDecimal jumlahPenarikan);

}
