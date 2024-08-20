package com.butterfly.simple.jetlinks.dashboard.provider.sys;

import com.butterfly.simple.jetlinks.dashboard.metadata.ObjectDefinition;
import lombok.AllArgsConstructor;

/**
 * 系统仪表盘的组件
 *
 * @author yanasida
 * @date 2024-08-20-20:41
 */
@AllArgsConstructor
public enum SysObjDefinition implements ObjectDefinition {

    cpu("CPU"),
    memory("内存"),
    stats("运行状态");

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
