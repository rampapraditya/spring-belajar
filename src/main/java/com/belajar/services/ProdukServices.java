package com.belajar.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.model.entities.Produk;
import com.belajar.model.repos.ProdukRepo;

import jakarta.transaction.Transactional;

// Untuk bisnis logic
@Service
@Transactional
public class ProdukServices {
    
    @Autowired
    private ProdukRepo produkRepo;

    public Produk save_update(Produk produk){
        return produkRepo.save(produk);
    }

    public Produk findOne(UUID id){
        return produkRepo.findById(id).orElse(null); 
    }

    public Iterable<Produk> findAll(){
        return produkRepo.findAll();
    }

    public void removeOne(UUID id){
        produkRepo.deleteById(id);
    }

    public List<Produk> findByName(String name){
        return produkRepo.findByNamaProdukContainsIgnoreCase(name);
    }
}
