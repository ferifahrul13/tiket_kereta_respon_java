/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import Config.Koneksi;
import DAO.DAOTiket;
import Model.MTiket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferifahrul
 */
public class DAOImplTiket implements DAOTiket {

    Connection kon;

    @Override
    public void insert(MTiket data) {
        kon = new Koneksi().connection();
        String kode = data.getKode();
        String nama = data.getNama();
        String type = data.getType();
        String jumlah = data.getJumlah();
        String harga = data.getHarga();
        String total = data.getTotal();

        try {
            String sql = "insert into tiket_kereta (nama,kode,type,jumlah,harga,total) values (?,?,?,?,?,?)";

            PreparedStatement ps = kon.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, kode);
            ps.setString(3, type);
            ps.setString(4, jumlah);
            ps.setString(5, harga);
            ps.setString(6, total);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
