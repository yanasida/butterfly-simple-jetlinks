package com.butterfly.simple.jetlinks.dashboard.metadata;

import java.util.Map;

/**
 * @author yanasida
 * @date 2024/8/21 13:49
 */
public interface DataType {


    /**
     * @return 类型标识
     */
    String getId();

    /**
     * @return 类型名称
     */
    String getName();

    /**
     * 格式化
     *
     * @param value obj
     * @return dateType
     */
    Object format(Object value);

    /**
     * @return 拓展属性
     */
    default Map<String, Object> getExpands() {
        return null;
    }

}
