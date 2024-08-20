package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.List;

/**
 * 仪表盘管理器
 *
 * @author yanasida
 * @date 2024/8/20 18:04
 */
public interface DashboardManager {

    List<Dashboard> getDashboards();

    Dashboard getDashboard(String id);

}
