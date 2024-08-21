package com.butterfly.simple.jetlinks.dashboard.supports.datatype;

import com.butterfly.simple.jetlinks.dashboard.metadata.AbstractType;

/**
 * @author yanasida
 * @date 2024/8/21 13:54
 */
public class IntType extends AbstractType {

    public static final IntType INSTANCE = new IntType();

    public IntType() {
        super("int", "整数");
    }

    @Override
    public Integer format(Object value) {
        return Integer.parseInt(String.valueOf(value));
    }
}
