package cn.rentaotao.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * contextId: bean name
 * name：服务名，如果 url 不存在，那么使用 name + path，通过注册中心，获取服务地址
 * qualifier: 生成 bean 的别名
 * url: 服务地址
 * decode404: 404 是否解析请求，或者直接报异常
 * configuration:
 * fallback:
 * fallbackFactory:
 * primary:
 *
 * contextId -> value -> name -> serviceId 依次获取 clientName
 */
@FeignClient(url = "服务地址", path = "路径", name = "服务名")
public interface ProviderOperationService {

    List<String> getProvider();
}
