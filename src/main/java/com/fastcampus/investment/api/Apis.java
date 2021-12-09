package com.fastcampus.investment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class Apis {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/product")
    public List<Products> retrieveAllProducts() {
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
        List<Products> products = new ArrayList<>();

        for(Products pro : productsRepository.findAll()) {
//            System.out.println(pro);
            if(pro.getStarted_at().isBefore(now) && pro.getFinished_at().isAfter(now)) {
                products.add(pro);
            }
        }

        return products;
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
