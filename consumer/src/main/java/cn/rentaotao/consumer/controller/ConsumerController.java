package cn.rentaotao.consumer.controller;

import cn.rentaotao.consumer.feign.ProviderOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final ProviderOperationService providerOperationService;

    private final RestTemplate template;

    @Autowired
    public ConsumerController(ProviderOperationService providerOperationService, RestTemplate template) {
        this.providerOperationService = providerOperationService;
        this.template = template;
    }

    @RequestMapping("/index")
    public List<String> getProvider() {
        return providerOperationService.getProvider();
    }

    @RequestMapping("/default")
    public List<String> getDefault() {
        return providerOperationService.getDefault();
    }

    @RequestMapping("/t")
    @SuppressWarnings("unchecked")
    public List<String> getT() {
        ResponseEntity<String[]> forEntity = template.getForEntity("http://cloud-provider/provider/get", String[].class);
        if(forEntity.getStatusCode() == HttpStatus.OK && forEntity.getBody() != null) {
            return Arrays.asList(forEntity.getBody());
        }
        return Collections.emptyList();
    }
}