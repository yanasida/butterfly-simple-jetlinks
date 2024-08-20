package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.List;

/**
 * 仪表盘组件指标
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface Measurement {

    MeasurementDefinition getDefinition();

    /**
     * 获取所有指标维度
     *
     * @return 维度
     */
    List<MeasurementDimension> getDimensions();

    /**
     * 获取指定ID的维度
     *
     * @param id 维度定义ID
     * @return 指定的维度, 不存在则返回 null
     */
    MeasurementDimension getDimension(String id);

}
