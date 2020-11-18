package io.jsbxyyx.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jsbxyyx
 */
@Configuration
public class WebConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    /**
     * 配置jackson序列化
     */
    @Bean
    public ObjectMapper objectMapper() {
        LOGGER.info("init ObjectMapper configuration");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        // 解决js long类型精度丢失
        SimpleModule longModule = new SimpleModule();
        longModule.addSerializer(Long.class, ToStringSerializer.instance);
        longModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(longModule);
        return objectMapper;
    }

}
