package com.example.walmart.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "display-products-service",url = "${api.endpoint}")
public interface ProductsServiceClient {

    @GetMapping("/walmart-search-by-keyword")
    Object getProductsFromExtAPI(@RequestHeader(name = "X-RapidAPI-Key") String key, @RequestParam String keyword, @RequestParam int page, @RequestParam String sortBy);
}
