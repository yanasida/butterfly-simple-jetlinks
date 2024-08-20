package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.List;

/**
 * 仪表盘组件
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface DashboardObject {

    ObjectDefinition getDefinition();

    List<Measurement> getMeasurements();

    Measurement getMeasurement(String id);

}
