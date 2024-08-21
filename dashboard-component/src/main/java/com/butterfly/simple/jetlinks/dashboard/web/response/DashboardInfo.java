package com.butterfly.simple.jetlinks.dashboard.web.response;

import com.butterfly.simple.jetlinks.dashboard.metadata.Dashboard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DashboardInfo {

    private String id;

    private String name;

    private List<ObjectInfo> objects;

    public static DashboardInfo of(Dashboard dashboard) {
        DashboardInfo dashboardInfo = new DashboardInfo();
        dashboardInfo.setId(dashboard.getDefinition().getId());
        dashboardInfo.setName(dashboard.getDefinition().getName());
        dashboardInfo.setObjects(dashboard.getObjects().stream()
                .map(ObjectInfo::of).collect(Collectors.toList()));
        return dashboardInfo;
    }

}
