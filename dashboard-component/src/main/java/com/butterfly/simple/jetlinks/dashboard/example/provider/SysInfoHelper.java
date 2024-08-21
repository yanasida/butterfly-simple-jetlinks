package com.butterfly.simple.jetlinks.dashboard.example.provider;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

/**
 * @author yanasida
 * @date 2024/8/21 9:29
 */
public class SysInfoHelper {

    private static final SystemInfo SYSTEM_INFO;

    static {
        SYSTEM_INFO = new SystemInfo();
    }


    public static String getOsName(){
        return SYSTEM_INFO.getOperatingSystem().getFamily();
    }


    public static String getCpuUsageRate(){
        CentralProcessor processor = SYSTEM_INFO.getHardware().getProcessor();
        // 占用信息
        long[] startTicks = processor.getSystemCpuLoadTicks();
        try {
            Thread.sleep(1000); // 休眠 1 秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long[] endTicks = processor.getSystemCpuLoadTicks();
        long user = endTicks[CentralProcessor.TickType.USER.getIndex()] - startTicks[CentralProcessor.TickType.USER.getIndex()];
        long nice = endTicks[CentralProcessor.TickType.NICE.getIndex()] - startTicks[CentralProcessor.TickType.NICE.getIndex()];
        long sys = endTicks[CentralProcessor.TickType.SYSTEM.getIndex()] - startTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long idle = endTicks[CentralProcessor.TickType.IDLE.getIndex()] - startTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long ioWait = endTicks[CentralProcessor.TickType.IOWAIT.getIndex()] - startTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long irq = endTicks[CentralProcessor.TickType.IRQ.getIndex()] - startTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softIrq = endTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - startTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = endTicks[CentralProcessor.TickType.STEAL.getIndex()] - startTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long totalCpu = user + nice + sys + idle + ioWait + irq + softIrq + steal;
        double cpuUsage = 100.0 * (totalCpu - idle) / totalCpu;

        // 返回格式化后的 CPU 使用率
        return String.format("%.2f%%", cpuUsage);
    }



}
