package com.fastcampus.investment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class Apis {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/product")
    public List<Products> retrieveAllProducts() {
        return productsRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Products retrieveProduct(@PathVariable long id) {
        Optional<Products> products = productsRepository.findById(id);

        if(!products.isPresent()) {
            return null;
        }

        return products.get();
    }
}
