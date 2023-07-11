package org.brightk.chain;

public class Interceptor1  implements Interceptor{

    @Override
    public String interceptor(Chain chain) {
        RealChain realChain = (RealChain) chain;
        return realChain.process("拦截器1");
    }
}
