/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOTiket;
import DAOImpl.DAOImplTiket;
import Model.MTiket;
import View.JFTiket;
import javax.swing.JOptionPane;
import java.util.HashMap;
import Config.Koneksi;
import java.io.File;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ferifahrul
 */
public class CTiket {

    JFTiket tiket;
    DAOTiket impl;
    Connection kon;

    public CTiket(JFTiket tiket) {
        this.tiket = tiket;
        impl = new DAOImplTiket();
    }

    public void insert(JFTiket data) {
        if (!(data.getKode().getSelectedIndex() == 0)
                && !data.getNama().getText().trim().isEmpty()
                && !data.getTipe().getText().trim().isEmpty()
                && !data.getJumlah().getText().trim().isEmpty()
                && !data.getJumlahHarga().getText().trim().isEmpty()
                && !data.getHarga().getText().trim().isEmpty()
                && !data.getUang().getText().trim().isEmpty()
                && !data.getKembalian().getText().trim().isEmpty()) {

            MTiket t = new MTiket();

            t.setKode(data.getKode().getSelectedItem().toString().trim());
            t.setNama(data.getNama().getText().trim());
            t.setType(data.getTipe().getText().trim());
            t.setHarga(data.getHarga().getText().trim());
            t.setJumlah(data.getJumlah().getText().trim());
            t.setTotal(data.getJumlahHarga().getText().trim());

            impl.insert(t);

            JOptionPane.showMessageDialog(data, "Data Transaksi Tiket Berhasil disimpan!",
                    "Sukses!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!",
                    "Pesan Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void pilih(int pilih) {

        switch (pilih) {
            case 1:
                tiket.getTipe().setText("VIP");
                tiket.getHarga().setText("500000");
                break;
            case 2:
                tiket.getTipe().setText("Medium");
                tiket.getHarga().setText("150000");
                break;
            case 3:
                tiket.getTipe().setText("Ekonomi");
                tiket.getHarga().setText("80000");
                break;
            default:
                tiket.getTipe().setText("");
                tiket.getHarga().setText("");
                break;
        }
    }

    public void hitung(String hitung) {
        if (!hitung.equals("")) {
            int hasil = Integer.parseInt(tiket.getHarga().getText()) * Integer.parseInt(hitung);
            tiket.getJumlahHarga().setText(Integer.toString(hasil));
        }
    }

    public void resetTotal() {
        tiket.getJumlahHarga().setText("");
        tiket.getJumlah().setText("");
    }

    public void kembalian(String uang) {
        int total = Integer.parseInt(tiket.getJumlahHarga().getText());
        int uang1 = Integer.parseInt(uang);
        tiket.getKembalian().setText(Integer.toString(uang1 - total));
    }

    

    public void cetak(JFTiket data) {
        if (!(data.getKode().getSelectedIndex() == 0)
                && !data.getNama().getText().trim().isEmpty()
                && !data.getTipe().getText().trim().isEmpty()
                && !data.getJumlah().getText().trim().isEmpty()
                && !data.getJumlahHarga().getText().trim().isEmpty()
                && !data.getHarga().getText().trim().isEmpty()
                && !data.getUang().getText().trim().isEmpty()
                && !data.getKembalian().getText().trim().isEmpty()) {
           
            try {
                Map parameter = new HashMap();
                kon = new Koneksi().connection();
                File file = new File("src/CetakStruk/Struk.jasper");
                parameter.put("kode", data.getKode().getSelectedItem().toString().trim());
                
                parameter.put("nama", data.getNama().getText().trim());
                parameter.put("type", data.getTipe().getText().trim());
                parameter.put("harga", data.getHarga().getText().trim());
                parameter.put("jumlah", data.getJumlah().getText().trim());
                parameter.put("total", data.getJumlahHarga().getText().trim());
//            MTiket t = new MTiket();
//
//            t.setKode(data.getKode().getSelectedItem().toString().trim());
//            t.setNama(data.getNama().getText().trim());
//            t.setType(data.getTipe().getText().trim());
//            t.setHarga(data.getHarga().getText().trim());
//            t.setJumlah(data.getJumlah().getText().trim());
//            t.setTotal(data.getJumlahHarga().getText().trim());
////
//                Object[] tiketArray = {t};
                JasperReport jr = (JasperReport) JRLoader.loadObject(file);
                JasperPrint jp = JasperFillManager.fillReport(jr, parameter, new JREmptyDataSource());
                JasperViewer.viewReport(jp, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            } catch (Exception e) {
            }

        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!",
                    "Pesan Kesalahan", JOptionPane.WARNING_MESSAGE);
        }

    }

}
