package com.butterfly.simple.jetlinks.dashboard.supports;


import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardObject;
import com.butterfly.simple.jetlinks.dashboard.metadata.Measurement;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementProvider;
import com.butterfly.simple.jetlinks.dashboard.metadata.ObjectDefinition;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

class CompositeDashboardObject implements DashboardObject {

    private ObjectDefinition definition;

    private final List<MeasurementProvider> providers = new CopyOnWriteArrayList<>();

    public void addProvider(MeasurementProvider provider) {
        if (definition == null) {
            definition = provider.getObjectDefinition();
        }
        providers.add(provider);
    }

    @Override
    public ObjectDefinition getDefinition() {
        return definition;
    }

    @Override
    public List<Measurement> getMeasurements() {
        return providers.stream().flatMap(e -> e.getMeasurements().stream()).collect(Collectors.toList());
    }

    @Override
    public Measurement getMeasurement(String id) {
        return getMeasurements().stream().filter(e -> e.getDefinition().getId().equals(id)).findFirst().orElse(null);
    }


}
