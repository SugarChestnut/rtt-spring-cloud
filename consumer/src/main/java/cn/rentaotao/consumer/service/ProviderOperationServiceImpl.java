package cn.rentaotao.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProviderOperationServiceImpl implements ProviderOperationService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<String> getProvider() {

        return List.of();
    }
}
