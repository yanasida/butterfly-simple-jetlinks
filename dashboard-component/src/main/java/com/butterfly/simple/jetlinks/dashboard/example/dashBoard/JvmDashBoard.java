package com.butterfly.simple.jetlinks.dashboard.example.dashBoard;

import com.butterfly.simple.jetlinks.dashboard.base.*;
import com.butterfly.simple.jetlinks.dashboard.example.ExampleObjDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.*;
import com.butterfly.simple.jetlinks.dashboard.supports.datatype.EnumType;
import com.butterfly.simple.jetlinks.dashboard.supports.datatype.StringType;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author yanasida
 * @date 2024/8/21 9:42
 */
@Component
@Slf4j
public class JvmDashBoard implements Dashboard {

    DashboardObject dashboardObject;

    public JvmDashBoard() {
        StaticDashboardObject object = new StaticDashboardObject(ExampleObjDefinition.stats);
        StaticMeasurement measurement = new StaticMeasurement(MeasurementDefinition.of("jvmDetail", "jvm明细"));
        measurement.addDimension(new DataMeasurementDimension());
        object.add(measurement);
        this.dashboardObject = object;
    }

    @Override
    public DashboardDefinition getDefinition() {
        return DefaultDashboardDefinition.jvmMonitor;
    }

    @Override
    public List<DashboardObject> getObjects() {
        return Lists.newArrayList(dashboardObject);
    }

    @Override
    public DashboardObject getObject(String id) {
        return dashboardObject;
    }

    static class DataMeasurementDimension implements MeasurementDimension {

        @Override
        public DimensionDefinition getDefinition() {
            return CommonDimensionDefinition.current;
        }

        @Override
        public DataType getValueType() {
            return StringType.INSTANCE;
        }

        @Override
        public ConfigMetadata getParams() {
            return new ConfigMetadata()
                    .add("type", "参数类型", new EnumType()
                            .addElement(EnumType.Element.of(JvmInfoHelper.Fields.jvmName, "jvm名称"))
                            .addElement(EnumType.Element.of(JvmInfoHelper.Fields.heapMemoryUsage, "堆内存"))
                            .addElement(EnumType.Element.of(JvmInfoHelper.Fields.nonHeapMemoryUsage, "堆外内存"))
                    )
                    .add("arg0", "示例参数", StringType.INSTANCE);
        }

        @Override
        public boolean isRealTime() {
            return false;
        }

        @Override
        public Object getValue(Map<String, Object> parameter) {
            String type = Optional.ofNullable(parameter)
                    .map(pm -> pm.get("type"))
                    .map(Objects::toString)
                    .orElse("");
            String arg0 = Optional.ofNullable(parameter)
                    .map(pm -> pm.get("arg0"))
                    .map(Objects::toString)
                    .orElse(null);
            log.info("arg0={}", arg0);
            switch (type) {
                case JvmInfoHelper.Fields.jvmName:
                    return JvmInfoHelper.getJvmName();
                case JvmInfoHelper.Fields.nonHeapMemoryUsage:
                    return JvmInfoHelper.getNonHeapMemoryUsage();
                case JvmInfoHelper.Fields.heapMemoryUsage:
                    return JvmInfoHelper.getHeapMemoryUsage();
                default:
                    return "暂无数据";
            }
        }
    }
}
