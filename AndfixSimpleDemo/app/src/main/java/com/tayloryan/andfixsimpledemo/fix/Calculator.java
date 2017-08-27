package com.tayloryan.andfixsimpledemo.fix;

import com.tayloryan.andfixsimpledemo.MethodReplace;

/**
 * Created by taylor.yan on 8/25/17.
 */

public class Calculator {

    @MethodReplace(clazz = "com.tayloryan.andfixsimpledemo.Calculator", method = "calculate")
    public int calculate() {
        int i = 1;
        int j = 10;
        return j / i;
    }
}
