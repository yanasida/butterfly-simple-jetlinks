package com.butterfly.simple.jetlinks.dashboard.metadata;

/**
 *
 * 指标明细
 *
 * @author yanasida
 * @date 2024/8/20 18:21
 */
public interface MeasurementDimension {


    DimensionDefinition getDefinition();

    DataType getValueType();

    ConfigMetadata getParams();

    boolean isRealTime();

     Object getValue(MeasurementParameter parameter);

}
