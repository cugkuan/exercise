package org.brightk.chain;

import java.util.LinkedList;
import java.util.List;

public class TestInterceptor {


    public static void main(String[] args){
        List<Interceptor> interceptors = new LinkedList<>();
        interceptors.add(new Interceptor1());
        interceptors.add(new Interceptor2());
        interceptors.add(new Interceptor3());

        Chain chain = new RealChain(interceptors,0);


        System.out.println(chain.process("测试"));
    }
}
