package com.ecoommercetreino.controller;

import com.ecoommercetreino.entities.Category;
import com.ecoommercetreino.entities.Product;
import com.ecoommercetreino.entities.User;
import com.ecoommercetreino.services.CategoryService;
import com.ecoommercetreino.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAll();
                return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product obj){
        obj = productService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj){
        obj = productService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
