
package POS;


public class Konstruktor {
    int kode_barang;
    String nama_barang;
    String jenis_barang;
    double harga_barang;
    int stock;
    int terjual;

    public Konstruktor(int kode_barang, String nama_barang, String jenis_barang, double harga_barang, int stock) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.harga_barang = harga_barang;
        this.stock = stock;
    }

    public Konstruktor(int kode_barang, String nama_barang, String jenis_barang, double harga_barang, int stock, int terjual) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.harga_barang = harga_barang;
        this.stock = stock;
        this.terjual = terjual;
    }
    
    

 public String toString(){
     String tampil = ""+kode_barang+" ; "+nama_barang+" ; "+jenis_barang+" ; "+harga_barang+" ; "+stock+" ; "+terjual+"";
     return  tampil;
 }
    
    
    
}
