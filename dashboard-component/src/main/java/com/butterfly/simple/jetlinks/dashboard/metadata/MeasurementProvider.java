package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.List;

/**
 * 指标提供者
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface MeasurementProvider {

    /**
     * @return 仪表定义
     */
    DashboardDefinition getDashboardDefinition();

    /**
     * @return 对象定义
     */
    ObjectDefinition getObjectDefinition();

    /**
     * @return 全部指标
     */
    List<Measurement> getMeasurements();

    /**
     * @param id 指标ID {@link Measurement#getDefinition()} {@link MeasurementDefinition#getId()}
     * @return 对应等指标, 不存在则返回 null
     * @see MeasurementDefinition
     */
    Measurement getMeasurement(String id);

}
