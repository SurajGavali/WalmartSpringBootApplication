package com.example.walmart.clients;

import com.example.walmart.config.FeignConfig;
import com.example.walmart.model.ExtApiResp;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "display-products-service",url = "${api.endpoint}",configuration = {FeignConfig.class})
@RibbonClient(name = "display-products-service")
public interface ProductsServiceClient {

    @GetMapping("/walmart-search-by-keyword")
    ExtApiResp getProductsFromExtAPI(@RequestHeader(name = "X-RapidAPI-Key") String key, @RequestParam String keyword, @RequestParam int page, @RequestParam String sortBy);
}
