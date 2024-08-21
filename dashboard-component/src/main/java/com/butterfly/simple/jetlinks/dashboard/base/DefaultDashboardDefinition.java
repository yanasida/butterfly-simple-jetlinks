package com.butterfly.simple.jetlinks.dashboard.base;

import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardDefinition;
import lombok.AllArgsConstructor;

/**
 * 系统仪表盘定义
 *
 * @author yanasida
 * @date 2024-08-20-20:50
 */
@AllArgsConstructor
public enum DefaultDashboardDefinition implements DashboardDefinition {
    systemMonitor("系统监控"),
    jvmMonitor("jvm监控"),
    device("设备监控")

    ;
    private final String name;

    @Override
    public String getId() {
        return name();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
