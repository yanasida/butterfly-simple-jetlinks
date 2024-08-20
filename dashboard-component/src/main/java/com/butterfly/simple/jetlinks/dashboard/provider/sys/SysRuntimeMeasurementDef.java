package com.butterfly.simple.jetlinks.dashboard.provider.sys;

import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDefinition;
import lombok.RequiredArgsConstructor;

/**
 * @author yanasida
 * @date 2024-08-20-21:25
 */
@RequiredArgsConstructor
public enum SysRuntimeMeasurementDef implements MeasurementDefinition {


    cpu("cpu信息"),
    memory("内存使用率"),
    os("系统"),
    diskStores("磁盘")
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
