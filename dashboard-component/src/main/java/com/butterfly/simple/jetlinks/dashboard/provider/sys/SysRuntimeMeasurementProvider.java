package com.butterfly.simple.jetlinks.dashboard.provider.sys;

import com.butterfly.simple.jetlinks.dashboard.base.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;

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

    private static final SystemInfo systemInfo;

    static {
        systemInfo = new SystemInfo();
    }

    public SysRuntimeMeasurementProvider() {
        super(DefaultDashboardDefinition.systemMonitor, SysObjDefinition.stats);

        addMeasurement(new StaticMeasurement(SysRuntimeMeasurementDef.os)
                .addDimension(new RealTimeDimension() {
                    @Override
                    public Object getValue(Map<String, String> parameter) {
                        return systemInfo.getOperatingSystem().getFamily();
                    }
                }));

        addMeasurement(new StaticMeasurement(SysRuntimeMeasurementDef.cpu)
                .addDimension(new RealTimeDimension() {
                    @Override
                    public Object getValue(Map<String, String> parameter) {
                        return systemInfo.getHardware().getProcessor().getSystemCpuLoad(2000);
                    }
                }));
    }

}
