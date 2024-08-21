package com.butterfly.simple.jetlinks.dashboard.web.response;

import com.butterfly.simple.jetlinks.dashboard.metadata.DataType;
import com.butterfly.simple.jetlinks.dashboard.metadata.Measurement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MeasurementInfo {

    private String id;

    private String name;

    private DataType type;

    private List<DimensionInfo> dimensions;

    public static MeasurementInfo of(Measurement measurement){
        MeasurementInfo info = new MeasurementInfo();
        info.setId(measurement.getDefinition().getId());
        info.setName(measurement.getDefinition().getName());
        info.setDimensions(measurement.getDimensions().stream()
                .map(DimensionInfo::of).collect(Collectors.toList()));
        return info;
    }
}
