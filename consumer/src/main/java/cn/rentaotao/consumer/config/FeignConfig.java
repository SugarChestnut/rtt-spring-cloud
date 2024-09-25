package cn.rentaotao.consumer.config;

import feign.*;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author rtt
 * @date 2024/9/24 16:00
 */
//@Configuration(proxyBeanMethods = false)
public class FeignConfig {

    @Bean("myDecoder")
    public Decoder decoder() {
        return new Decoder() {
            @Override
            public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
                /*
                    response    远程请求结果
                    type        接口需要返回的类型
                 */
                if (response.status() != 200) {
                    return Util.emptyValueOf(type);
                }
                if (response.body() == null) {
                    return null;
                }
                Reader reader = response.body().asReader(response.charset());
                return null;
            }
        };
    }

    @Bean("myEncoder")
    public Encoder encoder() {
        return new Encoder() {
            @Override
            public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {

            }
        };
    }

    @Bean("myContract")
    public Contract contract() {
        return new Contract() {
            @Override
            public List<MethodMetadata> parseAndValidateMetadata(Class<?> targetType) {
                return null;
            }
        };
    }

    @Bean("myRequestInterceptor")
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                System.out.println("Request interceptor");
            }
        };
    }
}
