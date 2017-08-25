package com.tayloryan.andfixsimpledemo.fix;

import com.tayloryan.andfixdemo.MethidReplace;

/**
 * Created by taylor.yan on 8/25/17.
 */

public class Calculator {

    @MethidReplace(cls = "com.tayloryan.andfixdemo.Calculator", method = "calculate")
    public int calculate() {
        int i = 1;
        int j = 10;
        return j / i;
    }
}
