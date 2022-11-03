package com.example.walmart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Data
@Slf4j
public class ItemClass {
      List<Items> items;
//    private String id;
//    private String name;
//    List<forItem> temppo;
    @JsonProperty("props")
    public void extractItems(Map<String, Object> props) {
        Map<String, Object> pageProps = (Map<String, Object>) props.get("pageProps");
        Map<String, Object> initialData = (Map<String, Object>) pageProps.get("initialData");
        Map<String, Object> searchResult = (Map<String, Object>) initialData.get("searchResult");
        List<Object> temp = (List<Object>) searchResult.get("itemStacks");
        //System.out.println(temp);
        Map<String,Object> itemStacks = (Map<String, Object>) temp.get(0);
        this.items = (List<Items>) itemStacks.get("items");
//        System.out.println(items.get("itmes"));
//        List<Object> temp2 = (List<Object>) itemStacks.get("items");
//        Map<String, Object> items = (Map<String, Object>) temp2.get(0);
//        this.id = (String) items.get("id");
//        this.name = (String) items.get("name");
    }
}