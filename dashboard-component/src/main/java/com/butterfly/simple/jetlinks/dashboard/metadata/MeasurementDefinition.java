package com.butterfly.simple.jetlinks.dashboard.metadata;

/**
 * 指标定义
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface MeasurementDefinition extends Definition {
    static MeasurementDefinition of(String id, String name) {
        return new MeasurementDefinition() {

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
