package com.butterfly.simple.jetlinks.dashboard.web;

import com.butterfly.simple.jetlinks.dashboard.metadata.Dashboard;
import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardManager;
import com.butterfly.simple.jetlinks.dashboard.web.request.DashboardMeasurementRequest;
import com.butterfly.simple.jetlinks.dashboard.web.response.DashboardInfo;
import com.butterfly.simple.jetlinks.dashboard.web.response.DashboardMeasurementResponse;
import com.butterfly.simple.jetlinks.dashboard.web.response.MeasurementInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yanasida
 * @date 2024-08-20-22:01
 */
@RestController("dashboard")
public class DashBoardController {

    @Resource
    private DashboardManager dashboardManager;

    /**
     * <p> http://localhost:8080/defs </p>
     *
     * @return 仪表盘数据
     */
    @GetMapping("/defs")
    public List<DashboardInfo> getDefinitions() {
        return dashboardManager
                .getDashboards()
                .stream()
                .map(DashboardInfo::of)
                .collect(Collectors.toList());
    }

    /**
     * <p> http://localhost:8080/def/jvmMonitor/stats/measurements </p>
     *
     * @param dashboard 仪表盘id
     * @param object    对象id
     * @return 仪表盘对象明细
     */
    @GetMapping("/def/{dashboard}/{object}/measurements")
    public List<MeasurementInfo> getMeasurementDefinitions(@PathVariable String dashboard,
                                                           @PathVariable String object) {
        return Optional.ofNullable(dashboardManager.getDashboard(dashboard))
                .map(Dashboard::getObjects)
                .map(objs -> objs.stream()
                        .filter(e -> e.getDefinition().getId().equals(object))
                        .flatMap(e -> e.getMeasurements().stream())
                        .map(MeasurementInfo::of).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    /**
     * 获取某个指标的明细数据
     * <p>
     * <code>
     * {
     * "dashboard": "jvmMonitor",
     * "object": "stats",
     * "measurement": "jvmDetail",
     * "dimension": "current",
     * "group": "jvm-group",
     * "params": {
     * "type": "heapMemoryUsage",
     * "arg0": "1m"
     * }
     * }
     * </code>
     *
     * @param request 入参
     * @return 详细数据
     */
    @PostMapping(value = "/detail")
    public DashboardMeasurementResponse getMultiMeasurementValue(@RequestBody @Nonnull DashboardMeasurementRequest request) {
        return Optional.ofNullable(dashboardManager.getDashboard(request.getDashboard()))
                .map(e -> e.getObject(request.getObject()))
                .map(e -> e.getMeasurement(request.getMeasurement()))
                .map(e -> e.getDimension(request.getDimension()))
                .map(e -> e.getValue(request.getParams()))
                .map(val -> DashboardMeasurementResponse.of(request.getGroup(), val))
                .orElse(new DashboardMeasurementResponse());


    }

    /**
     * 获取数据
     *
     * @param dashboardName     仪表盘名字
     * @param objDefinitionName 组件名字
     * @param measurementName   指标名字
     * @param dimensionName     指标维度
     */
    @GetMapping("/data/{dashboardName}/{objDefinitionName}/{measurementName}/{dimensionName}")
    public void get(@PathVariable("dashboardName") String dashboardName,
                    @PathVariable("objDefinitionName") String objDefinitionName,
                    @PathVariable("measurementName") String measurementName,
                    @PathVariable("dimensionName") String dimensionName) {
        System.out.println(dashboardManager.getDashboard(dashboardName));
    }

}
