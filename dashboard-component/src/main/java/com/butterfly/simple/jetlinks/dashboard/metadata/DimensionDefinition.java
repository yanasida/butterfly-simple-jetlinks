package com.butterfly.simple.jetlinks.dashboard.metadata;

/**
 * 维度定义
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface DimensionDefinition extends Definition {
    static DimensionDefinition of(String id, String name) {
        return new DimensionDefinition() {

            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }
        };
    }

}