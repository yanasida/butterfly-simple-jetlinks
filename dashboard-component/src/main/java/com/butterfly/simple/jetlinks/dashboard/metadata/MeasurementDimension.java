package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.Map;

/**
 * 指标明细
 *
 * @author yanasida
 * @date 2024/8/20 18:21
 */
public interface MeasurementDimension {


    DimensionDefinition getDefinition();

    /**
     * 数据类型
     *
     * @return 数据类型
     */
    DataType getValueType();

    /**
     * 配置元数据
     *
     * @return 配置元数据
     */
    ConfigMetadata getParams();

    boolean isRealTime();

    /**
     * 获取值
     *
     * @param parameter 查询入参
     * @return 值对象
     */
//    Object getValue(MeasurementParameter parameter);
    Object getValue(Map<String, Object> parameter);

}
