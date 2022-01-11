package com.kuang.demo02;

import java.util.concurrent.Callable;

//线程创建方式三：实现callable接口
public class TestCallable implements Callable {
    @Override
    public Boolean call() throws Exception {
        return true;
    }
}
