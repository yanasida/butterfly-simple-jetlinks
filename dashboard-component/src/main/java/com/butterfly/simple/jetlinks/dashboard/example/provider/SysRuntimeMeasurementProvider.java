package com.butterfly.simple.jetlinks.dashboard.example.provider;

import com.butterfly.simple.jetlinks.dashboard.base.*;
import com.butterfly.simple.jetlinks.dashboard.example.ExampleObjDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.ConfigMetadata;
import com.butterfly.simple.jetlinks.dashboard.metadata.DataType;
import com.butterfly.simple.jetlinks.dashboard.metadata.DimensionDefinition;
import com.butterfly.simple.jetlinks.dashboard.metadata.MeasurementDimension;
import com.butterfly.simple.jetlinks.dashboard.supports.datatype.StringType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 系统仪表盘数据维护者
 *
 * @author yanasida
 * @date 2024-08-20-20:47
 */
@Component
@Slf4j
public class SysRuntimeMeasurementProvider extends StaticMeasurementProvider {


    public SysRuntimeMeasurementProvider() {
        super(DefaultDashboardDefinition.systemMonitor, ExampleObjDefinition.stats);

        addMeasurement(new StaticMeasurement(SysRuntimeMeasurementDef.os)
                .addDimension(new RealTimeDimension() {
                    @Override
                    public Object getValue(Map<String, Object> parameter) {
                        return SysInfoHelper.getOsName();
                    }
                }));

        addMeasurement(new StaticMeasurement(SysRuntimeMeasurementDef.cpu)
                .addDimension(new RealTimeDimension() {
                    @Override
                    public Object getValue(Map<String, Object> parameter) {
                        return SysInfoHelper.getCpuUsageRate();
                    }
                }));
    }

    /**
     * 实时数据维度
     *
     * @author yanasida
     * @date 2024-08-20-21:49
     */
    abstract static class RealTimeDimension implements MeasurementDimension {

        @Override
        public DimensionDefinition getDefinition() {
            return CommonDimensionDefinition.realTime;
        }

        @Override
        public boolean isRealTime() {
            return true;
        }

        @Override
        public DataType getValueType() {
            return StringType.INSTANCE;
        }

        @Override
        public ConfigMetadata getParams() {
            return null;
        }
    }

}
