package cn.rentaotao.consumer.feign;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * contextId: bean name
 * name：服务名，如果 url 不存在，那么使用 name + path，通过注册中心，获取服务地址
 * qualifier: 生成 bean 的别名
 * url: 服务地址
 * decode404: 404 是否解析请求，或者直接报异常
 * configuration: 指定加解码配置
 * fallback:
 * fallbackFactory:
 * primary:
 *
 * contextId -> value -> name -> serviceId 依次获取 clientName
 */
@FeignClient(contextId = "providerOperationService", path = "/provider/get", name = "cloud-provider")
public interface ProviderOperationService {

    @GetMapping
    List<String> getProvider();

    default List<String> getDefault() {
        return Arrays.asList("d", "e", "f", "a", "u", "l", "t");
    }
}
