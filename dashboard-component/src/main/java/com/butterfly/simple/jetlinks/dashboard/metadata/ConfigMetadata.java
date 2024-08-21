package com.butterfly.simple.jetlinks.dashboard.metadata;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author yanasida
 * @date 2024/8/21 10:10
 */
@Getter
@Setter
@ToString
public class ConfigMetadata {
    /**
     * 配置名称
     */
    String name;

    /**
     * 配置说明
     */
    String description;

    /**
     * 配置属性信息
     */
    List<ConfigPropertyMetadata> properties;

    public ConfigMetadata() {
        this.properties = Lists.newArrayList();
    }

    public ConfigMetadata add(String property, String name, DataType type) {
        this.properties.add(new ConfigPropertyMetadata(property, name, type));
        return this;
    }

    @Getter
    @ToString
    static
    class ConfigPropertyMetadata {

        String property;

        String name;

        String description;

        DataType type;

        Map<String, Object> expands;

        public ConfigPropertyMetadata(String property, String name, DataType type) {
            this.property = property;
            this.name = name;
            this.type = type;
        }
    }
}
