package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }



    @GetMapping("/order-by-price")
    public ResponseEntity<Iterable<Product>> findAllByOrderByPrice() {
        return new ResponseEntity<>(productService.findAllByOrderByPrice(), HttpStatus.OK);
    }

    @GetMapping("/order-by-price-between")
    public ResponseEntity<Iterable<Product>> findAllByOrderByPriceBetween(@RequestParam String from, @RequestParam String to) {
        return new ResponseEntity<>(productService.findAllByPriceBetween(from, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        productService.remove(id);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(productOptional.get().getId());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Product>> findByName(@RequestParam String search) {
        Iterable<Product> products = productService.findAllByNameContaining(search);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/upload")
    public ResponseEntity<Product> add(@RequestParam("file") MultipartFile file, Product product) {
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        try {
            file.transferTo(new File("D:\\product_webstrom\\image\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok( productService.saveP(product));
    }

}
