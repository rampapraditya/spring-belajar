package com.belajar.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.model.entities.Produk;
import com.belajar.services.ProdukServices;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    private final ProdukServices produkServices;

    public ProdukController(ProdukServices produkServices) {
        this.produkServices = produkServices;
    }

    // 1. Create atau Update Produk (POST)
    @PostMapping
    public ResponseEntity<Produk> create(@RequestBody Produk produk) {
        Produk produkBaru = produkServices.save_update(produk);
        return new ResponseEntity<>(produkBaru, HttpStatus.CREATED);
    }

    // 2. Get All Produk (GET)
    @GetMapping
    public ResponseEntity<Iterable<Produk>> findAll() {
        Iterable<Produk> listProduk = produkServices.findAll();
        return ResponseEntity.ok(listProduk);
    }

    // 3. Get Produk Berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Produk> findOne(@PathVariable("id") UUID id) {
        Produk produk = produkServices.findOne(id); // Langsung tampung ke objek Produk
        if (produk != null) {
            return ResponseEntity.ok(produk);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Delete Produk Berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeOne(@PathVariable("id") UUID id) {
        Produk produk = produkServices.findOne(id); // Langsung tampung ke objek Produk
        if (produk != null) {
            produkServices.removeOne(id);
            return ResponseEntity.ok("Produk berhasil dihapus");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
