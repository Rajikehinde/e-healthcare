package com.hackathon.ehealthcareproject.controller;

import com.hackathon.ehealthcareproject.dto.product.ProductRequestDto;
import com.hackathon.ehealthcareproject.dto.product.ProductResponseDto;
import com.hackathon.ehealthcareproject.service.products.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/health/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProducts(@RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(productService.createProduct(productRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> viewAllProducts(){
        return new ResponseEntity<>(productService.viewAllProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDto> viewSingleProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.viewSingleProduct(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponseDto> updateSingleProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(productService.updateSingleProduct(id, productRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product successfully deleted");
    }
}
