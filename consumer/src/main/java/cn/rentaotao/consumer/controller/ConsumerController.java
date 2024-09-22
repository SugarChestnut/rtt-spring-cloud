package cn.rentaotao.consumer.controller;

import cn.rentaotao.consumer.service.ProviderOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final ProviderOperationService providerOperationService;

    @Autowired
    public ConsumerController(ProviderOperationService providerOperationService) {
        this.providerOperationService = providerOperationService;
    }

    @RequestMapping("/index")
    public List<String> index() {
        return providerOperationService.getProvider();
    }
}
