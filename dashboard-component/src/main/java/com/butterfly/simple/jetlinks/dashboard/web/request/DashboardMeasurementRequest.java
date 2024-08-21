package com.butterfly.simple.jetlinks.dashboard.web.request;

import lombok.Getter;

import java.util.Map;

/**
 * @author yanasida
 * @date 2024/8/21 14:23
 */
@Getter
public class DashboardMeasurementRequest {

    /**
     * 分组
     * @see com.butterfly.simple.jetlinks.dashboard.web.response.DashboardMeasurementResponse#getGroup()
     */
    private String group;

    /**
     * 仪表盘,如: device
     * @see com.butterfly.simple.jetlinks.dashboard.metadata.Dashboard#getDefinition()
     */
    private String dashboard;

    /**
     * 仪表对象,如: device1
     * @see  com.butterfly.simple.jetlinks.dashboard.metadata.DashboardDefinition#getId()
     */
    private String object;

    /**
     * 指标,如: 属性ID
     * @see  com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDefinition#getId()
     */
    private String measurement;

    /**
     * 维度
     * @see com.butterfly.simple.jetlinks.dashboard.metadata.DashboardDefinition#getId()
     */
    private String dimension;

    /**
     * 查询参数
     */
    private Map<String, Object> params;

}
