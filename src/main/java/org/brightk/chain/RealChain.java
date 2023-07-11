package org.brightk.chain;

import java.util.List;

public class RealChain implements Chain {
    private List<Interceptor> interceptors;
    private int index = 0;
    public RealChain(List<Interceptor> interceptors,int index){
        this.index = index;
        this.interceptors = interceptors;
    }
    @Override
    public String process(String requset) {
        RealChain realChain = new RealChain(interceptors,index+1);
        Interceptor interceptor = interceptors.get(index);
        return  interceptor.interceptor(realChain) +"；"+requset;
    }
}
