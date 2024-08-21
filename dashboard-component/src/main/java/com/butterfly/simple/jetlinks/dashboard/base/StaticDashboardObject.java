package com.butterfly.simple.jetlinks.dashboard.base;

import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardObject;
import com.butterfly.simple.jetlinks.dashboard.metadata.Measurement;
import com.butterfly.simple.jetlinks.dashboard.metadata.ObjectDefinition;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * @author yanasida
 * @date 2024/8/21 10:37
 */
public class StaticDashboardObject implements DashboardObject {

    @Getter
    private final ObjectDefinition definition;

    private final Map<String, Measurement> measurementMap;

    public StaticDashboardObject(ObjectDefinition definition) {
        this.definition = definition;
        this.measurementMap = Maps.newHashMap();
    }

    @Override
    public List<Measurement> getMeasurements() {
        return Lists.newArrayList(measurementMap.values());
    }

    @Override
    public Measurement getMeasurement(String id) {
        return measurementMap.get(id);
    }

    public void add(Measurement measurement) {
        measurementMap.put(measurement.getDefinition().getId(), measurement);
    }
}
