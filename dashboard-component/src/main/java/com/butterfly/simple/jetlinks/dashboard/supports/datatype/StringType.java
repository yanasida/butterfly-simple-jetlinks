package com.butterfly.simple.jetlinks.dashboard.supports.datatype;

import com.butterfly.simple.jetlinks.dashboard.metadata.AbstractType;

/**
 * @author yanasida
 * @date 2024/8/21 13:54
 */
public class StringType extends AbstractType {

    public static final StringType INSTANCE = new StringType();

    public StringType() {
        super("string", "字符串");
    }

    @Override
    public String format(Object value) {
        return String.valueOf(value);
    }
}
