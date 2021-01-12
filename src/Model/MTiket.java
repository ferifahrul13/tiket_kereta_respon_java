/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ferifahrul
 */
public class MTiket {
    
    String kode,type,nama,jumlah,harga,total;
    
    public void setKode(String Kode)
    {
        this.kode = Kode;
    }
    
    public void setType(String Type)
    {
        this.type = Type;
    }
    
    public void setNama(String Nama)
    {
        this.nama = Nama;
    }
    
    public void setHarga(String Harga)
    {
        this.harga = Harga;
    }
    
    
    public void setJumlah(String Jumlah)
    {
        this.jumlah = Jumlah;
    }
    
    public void setTotal(String Total)
    {
        this.total = Total;
    }
    
    public String getKode()
    {
        return kode;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public String getHarga()
    {
        return harga;
    }
    
    public String getJumlah()
    {
        return jumlah;
    }
    
    public String getTotal()
    {
        return total;
    }
    
}
