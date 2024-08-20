package com.butterfly.simple.jetlinks.dashboard.base;

import com.butterfly.simple.jetlinks.dashboard.metadata.Measurement;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDimension;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基本-指标类
 *
 * @author yanasida
 * @date 2024-08-20-21:29
 */
public class StaticMeasurement implements Measurement {

    @Getter
    private MeasurementDefinition definition;


    public StaticMeasurement(MeasurementDefinition definition) {
        this.definition = definition;
    }

    private final Map<String, MeasurementDimension> dimensions = Maps.newHashMap();

    public StaticMeasurement addDimension(MeasurementDimension dimension) {

        dimensions.put(dimension.getDefinition().getId(), dimension);

        return this;

    }

    @Override
    public List<MeasurementDimension> getDimensions() {
        return Lists.newArrayList(dimensions.values());
    }

    @Override
    public MeasurementDimension getDimension(String id) {
        return dimensions.get(id);
    }
}

