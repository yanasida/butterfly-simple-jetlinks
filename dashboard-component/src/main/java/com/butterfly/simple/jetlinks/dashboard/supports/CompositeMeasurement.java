package com.butterfly.simple.jetlinks.dashboard.supports;


import com.butterfly.simple.jetlinks.dashboard.metadata.Measurement;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDimension;
import org.springframework.util.Assert;


import java.util.List;
import java.util.stream.Collectors;

class CompositeMeasurement implements Measurement {

    private final List<Measurement> measurements;

    private final Measurement main;

    public CompositeMeasurement(List<Measurement> measurements) {
        Assert.notEmpty(measurements, "measurements can not be empty");
        this.measurements = measurements;
        this.main = measurements.get(0);
    }

    @Override
    public MeasurementDefinition getDefinition() {
        return main.getDefinition();
    }

    @Override
    public List<MeasurementDimension> getDimensions() {
        return measurements.stream().flatMap(e -> e.getDimensions().stream()).collect(Collectors.toList());
    }

    @Override
    public MeasurementDimension getDimension(String id) {
        return getDimensions().stream().filter(e -> e.getDefinition().getId().equals(id)).findFirst().orElse(null);
    }


}
