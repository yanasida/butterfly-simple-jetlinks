package com.butterfly.simple.jetlinks.dashboard.example.dashBoard;

import lombok.experimental.FieldNameConstants;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;

/**
 * @author yanasida
 * @date 2024/8/21 10:50
 */
@FieldNameConstants
public class JvmInfoHelper {

    private String jvmName;
    private Integer heapMemoryUsage;
    private Integer nonHeapMemoryUsage;


    private static final RuntimeMXBean RUNTIMEMX_BEAN = ManagementFactory.getRuntimeMXBean();
    private static final MemoryMXBean MEMORYMX_BEAN = ManagementFactory.getMemoryMXBean();


    public static String getJvmName() {
        return RUNTIMEMX_BEAN.getName();
    }

    public static Long getHeapMemoryUsage() {
        return MEMORYMX_BEAN.getHeapMemoryUsage().getUsed();
    }

    public static Long getNonHeapMemoryUsage() {
        return MEMORYMX_BEAN.getNonHeapMemoryUsage().getUsed();
    }

}
