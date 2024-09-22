package cn.rentaotao.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @RequestMapping("/get")
    public List<String> getProvider() {
        return Arrays.asList("a", "b", "c");
    }
}
