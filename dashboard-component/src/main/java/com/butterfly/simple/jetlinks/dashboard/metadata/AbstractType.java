package com.butterfly.simple.jetlinks.dashboard.metadata;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author yanasida
 * @date 2024/8/21 13:52
 */
@Getter
@Setter
public abstract class AbstractType implements DataType{

    private Map<String, Object> expands;

    private String description;

    private String id;

    private String name;

    public AbstractType(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
