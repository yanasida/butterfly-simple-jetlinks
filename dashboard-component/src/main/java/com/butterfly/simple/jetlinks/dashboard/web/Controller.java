package com.butterfly.simple.jetlinks.dashboard.web;

import com.butterfly.simple.jetlinks.dashboard.provider.sys.SysRuntimeMeasurementProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanasida
 * @date 2024-08-20-22:01
 */
@RestController("dashboard")
public class Controller {

    @Resource
    private SysRuntimeMeasurementProvider provider;


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
        System.out.println(provider.getMeasurement(measurementName).getDimension(dimensionName));
    }

}
