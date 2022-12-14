package com.example.walmart.sal;

import com.example.walmart.model.ExtApiResp;
import com.example.walmart.model.User;
import com.example.walmart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.yaml.snakeyaml.tokens.Token.ID.Key;

@Service
@Slf4j
public class UserServiceSal {

    RestTemplate restTemplate;
    @Value("${api.endpoint}")
    private String baseURL;


    public UserServiceSal(RestTemplate restTemplate){this.restTemplate=restTemplate;}

    public ExtApiResp getDataFromExtAPI(String keyword, int page, String sortby){

//        ExtApiResp extApiResp = new ExtApiResp();

        try{
            String requestURL = baseURL.concat("/walmart-search-by-keyword");
            requestURL = UriComponentsBuilder.fromHttpUrl(requestURL)
                    .queryParam("keyword",keyword)
                    .queryParam("page",page)
                    .queryParam("sortBy",sortby)
                    .toUriString();
            //String requestURL = "https://axesso-walmart-data-service.p.rapidapi.com/wlm/walmart-search-by-keyword?keyword=Lego%20Star%20Wars&page=1&sortBy=best_match";
            ResponseEntity<ExtApiResp> response;

            HttpHeaders headers = new HttpHeaders();
            headers.add("X-RapidAPI-Key","21905d8883msh41912f7dd1a1a30p181f27jsnd4364afc05da");
            headers.add("X-RapidAPI-Host","axesso-walmart-data-service.p.rapidapi.com");

            HttpEntity entity = new HttpEntity<>(headers);
            log.info("Above exchange");
            response =restTemplate.exchange(requestURL, HttpMethod.GET,entity,ExtApiResp.class);
            //extApiResp.setItemClass(response.getBody());
            if(response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new InternalError("Sorry , we are not able to process your request at this time , Please try after some time or contact with Admin");
        }
    }
}
