package com.butterfly.simple.jetlinks.dashboard.base;

import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.Measurement;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementProvider;
import com.butterfly.simple.jetlinks.dashboard.metadata.ObjectDefinition;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 基本-指标维护者
 *
 * @author yanasida
 * @date 2024-08-20-21:08
 */
public class StaticMeasurementProvider implements MeasurementProvider {

    @Getter
    private final DashboardDefinition dashboardDefinition;
    @Getter
    private final ObjectDefinition objectDefinition;

    private final Map<String, Measurement> measurementMap = Maps.newHashMap();

    public StaticMeasurementProvider(DashboardDefinition dashboardDefinition, ObjectDefinition objectDefinition) {
        this.dashboardDefinition = dashboardDefinition;
        this.objectDefinition = objectDefinition;
    }

    @Override
    public List<Measurement> getMeasurements() {
        return Lists.newArrayList(measurementMap.values());
    }

    @Override
    public Measurement getMeasurement(String id) {
        return measurementMap.get(id);
    }

    public void addMeasurement(Measurement measurement) {
        measurementMap.put(measurement.getDefinition().getId(), measurement);
    }
}
