package com.butterfly.simple.jetlinks.dashboard.base;

import com.butterfly.simple.jetlinks.dashboard.metadata.DimensionDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDimension;

import java.util.Map;

/**
 * 实时数据维度
 *
 * @author yanasida
 * @date 2024-08-20-21:49
 */
public abstract class RealTimeDimension implements MeasurementDimension {

    @Override
    public DimensionDefinition getDefinition() {
        return CommonDimensionDefinition.realTime;
    }

    @Override
    public boolean isRealTime() {
        return true;
    }

}
