package org.brightk.chain;

public class Interceptor3 implements  Interceptor {

    @Override
    public String interceptor(Chain chain) {
        return "拦截器3";
    }
}
