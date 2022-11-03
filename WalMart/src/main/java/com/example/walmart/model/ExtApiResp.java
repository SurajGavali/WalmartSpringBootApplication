package com.example.walmart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExtApiResp {
    @JsonProperty("item")
    private ItemClass itemClass;

    public ExtApiResp(){
        System.out.println(this.itemClass);
    }
}
