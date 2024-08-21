package com.butterfly.simple.jetlinks.dashboard.supports;


import com.butterfly.simple.jetlinks.dashboard.metadata.Dashboard;
import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardManager;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementProvider;
import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @docs 仪表盘manager
 * 通过BeanPostProcessor注入关联的仪表盘数据源
 */
@Component
public class DefaultDashboardManager implements DashboardManager, BeanPostProcessor {

    private final Map<String, CompositeDashboard> dashboards = new HashMap<>();

    private void addProvider(MeasurementProvider provider) {

        DashboardDefinition definition = provider.getDashboardDefinition();

        CompositeDashboard dashboard = dashboards.computeIfAbsent(definition.getId(), one -> new CompositeDashboard(definition));

        dashboard.addProvider(provider);
    }

    private void addDashboard(Dashboard dashboard) {

        CompositeDashboard cached = dashboards.computeIfAbsent(dashboard.getDefinition().getId(), one -> new CompositeDashboard(dashboard.getDefinition()));

        cached.addDashboard(dashboard);

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof MeasurementProvider) {
            addProvider(((MeasurementProvider) bean));
        } else if (bean instanceof Dashboard) {
            addDashboard(((Dashboard) bean));
        }
        return bean;
    }

    @Override
    public List<Dashboard> getDashboards() {
        return Lists.newArrayList(dashboards.values());
    }

    @Override
    public Dashboard getDashboard(String id) {
        return dashboards.get(id);
    }
}
