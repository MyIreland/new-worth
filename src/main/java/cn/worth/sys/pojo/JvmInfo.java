package cn.worth.sys.pojo;

import cn.worth.common.utils.Arith;
import cn.worth.common.utils.DateUtils;

import java.lang.management.ManagementFactory;
import java.util.Date;

/**
 * @author myireland
 * @version 1.0.0
 * @date 2019-10-08
 * @description
 **/
public class JvmInfo {
    /**
     * 当前JVM占用的内存总数(M)
     */
    private double total;

    /**
     * JVM最大可用内存总数(M)
     */
    private double max;

    /**
     * JVM空闲内存(M)
     */
    private double free;

    /**
     * JDK版本
     */
    private String version;

//    /**
//     * JDK路径
//     */
//    private String home;

    public double getTotal()
    {
        return Arith.div(total, (1024 * 1024), 2);
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public double getMax()
    {
        return Arith.div(max, (1024 * 1024), 2);
    }

    public void setMax(double max)
    {
        this.max = max;
    }

    public double getFree()
    {
        return Arith.div(free, (1024 * 1024), 2);
    }

    public void setFree(double free)
    {
        this.free = free;
    }

    public double getUsed()
    {
        return Arith.div(total - free, (1024 * 1024), 2);
    }

    public double getUsage()
    {
        return Arith.mul(Arith.div(total - free, total, 4), 100);
    }

    /**
     * 获取JDK名称
     */
    public String getName()
    {
        return ManagementFactory.getRuntimeMXBean().getVmName();
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }
//
//    public String getHome()
//    {
//        return home;
//    }
//
//    public void setHome(String home)
//    {
//        this.home = home;
//    }

    /**
     * JDK启动时间
     */
    public String getStartTime() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return DateUtils.formatDateTime(new Date(time));
    }

    /**
     * JDK运行时间
     */
    public String getRunTime() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return DateUtils.diffTime(new Date(), new Date(time));
    }
}
