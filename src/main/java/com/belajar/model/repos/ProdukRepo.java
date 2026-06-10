package com.belajar.model.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.belajar.model.entities.Produk;

public interface ProdukRepo extends CrudRepository<Produk, UUID>{
 
    // ini yang untuk custom
    public List<Produk> findByNamaProdukContainsIgnoreCase(String namaProduk);
}
