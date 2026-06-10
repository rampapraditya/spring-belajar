package com.belajar.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produk")
public class Produk implements Serializable {
    
    // Sebagai nomor versi penanda agar proses serialisasi/deserialisasi tidak bentrok saat kode diubah
    private static final long serialVersionUID = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nama_produk", nullable = false, length = 100)
    private String namaProduk;

    @Column(name = "harga", nullable = false)
    private BigDecimal harga;

    @Column(name = "stok", nullable = false)
    private Integer stok;

    // --- Constructor Kosong (Wajib untuk JPA) ---
    public Produk() {
    }

    // --- Constructor Opsional untuk Mempermudah Pembuatan Objek Baru ---
    public Produk(String namaProduk, BigDecimal harga, Integer stok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    // --- Getter dan Setter ---
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
}
