package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.List;

/**
 * 仪表盘
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface Dashboard {

    /**
     * 获取仪表盘定义
     */
    DashboardDefinition getDefinition();

    /**
     * 获取仪表盘组件
     */
    List<DashboardObject> getObjects();

    /**
     * 获取仪表盘组件
     */
    DashboardObject getObject(String id);

}
