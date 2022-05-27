package com.myq.epidemic.common.utils;


import com.myq.epidemic.common.exception.BizException;
import org.springframework.util.Assert;

public abstract class AssertUtil extends Assert {
    public static void notNull( Object object, String message) {
        if (object == null) {
            throw new BizException(message);
        }
    }


}
