package org.brightk.chain;

public class Interceptor2 implements Interceptor {

    @Override
    public String interceptor(Chain chain) {

        RealChain realChain = (RealChain) chain;
        return realChain.process("拦截器2");
    }
}
