package com.butterfly.simple.jetlinks.dashboard.base;

import com.butterfly.simple.jetlinks.dashboard.metadata.DimensionDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 指标维度
 *
 * @author yanasida
 * @date 2024-08-20-21:01
 */
@AllArgsConstructor
@Getter
public enum CommonDimensionDefinition implements DimensionDefinition {
    realTime("实时数据"),
    history("历史数据"),
    current("当前数据"),
    agg("聚合数据");

    private final String name;

    @Override
    public String getId() {
        return name();
    }
}