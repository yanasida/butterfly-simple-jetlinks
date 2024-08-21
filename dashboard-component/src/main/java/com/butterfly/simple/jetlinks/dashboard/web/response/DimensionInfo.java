package com.butterfly.simple.jetlinks.dashboard.web.response;

import com.butterfly.simple.jetlinks.dashboard.metadata.ConfigMetadata;
import com.butterfly.simple.jetlinks.dashboard.metadata.DataType;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDimension;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DimensionInfo {
    private String id;

    private String name;

    private DataType type;

    private ConfigMetadata params;

    private boolean realTime;

    public static DimensionInfo of(MeasurementDimension dimension) {
        DimensionInfo dimensionInfo = new DimensionInfo();
        dimensionInfo.setId(dimension.getDefinition().getId());
        dimensionInfo.setName(dimension.getDefinition().getName());
        dimensionInfo.setParams(dimension.getParams());
        dimensionInfo.setType(dimension.getValueType());
        dimensionInfo.setRealTime(dimension.isRealTime());
        return dimensionInfo;
    }
}
