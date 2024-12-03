package model;

public class ModelAdminTransaksi {
    private String id_transaksi, id_produk,id_pelanggan,order_date,start_time,end_time; 

    public ModelAdminTransaksi(String id_transaksi, String id_produk,String id_pelanggan, String order_date, String start_time, String end_time) {
        this.id_transaksi = id_transaksi;
        this.id_produk = id_produk;
        this.id_pelanggan = id_pelanggan;
        this.order_date =order_date;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    
    
    
}