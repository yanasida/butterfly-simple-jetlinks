package com.butterfly.simple.jetlinks.dashboard.supports;

import cn.hutool.core.collection.CollUtil;
import com.butterfly.simple.jetlinks.dashboard.metadata.Dashboard;
import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardObject;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementProvider;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @docs 聚合仪表盘
 */
class CompositeDashboard implements Dashboard {

    @Getter
    private final DashboardDefinition definition;

    public CompositeDashboard(DashboardDefinition definition) {
        this.definition = definition;
    }

    private final Map<String, DashboardObject> staticObjects = new ConcurrentHashMap<>();

    private final List<Dashboard> staticDashboard = new CopyOnWriteArrayList<>();

    public void addProvider(MeasurementProvider provider) {

        DashboardObject object = staticObjects.computeIfAbsent(provider.getObjectDefinition().getId(), one -> new CompositeDashboardObject());
        if (object instanceof CompositeDashboardObject) {
            CompositeDashboardObject compose = ((CompositeDashboardObject) object);
            compose.addProvider(provider);
        }

    }

    public void addDashboard(Dashboard dashboard) {
        staticDashboard.add(dashboard);
    }

    public void addObject(DashboardObject object) {
        staticObjects.put(object.getDefinition().getId(), object);
    }


    @Override
    public List<DashboardObject> getObjects() {
        return Lists.newArrayList(CollUtil.union(
                Lists.newArrayList(staticObjects.values()),
                staticDashboard.stream().flatMap(e -> e.getObjects().stream()).collect(Collectors.toList())));
    }

    @Override
    public DashboardObject getObject(String id) {
        return getObjects().stream().filter(obj -> obj.getDefinition().getId().equals(id)).findFirst().orElse(null);
    }
}
