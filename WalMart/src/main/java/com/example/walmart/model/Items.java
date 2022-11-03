package com.example.walmart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    private String id;
    private String name;
}
