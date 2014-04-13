package com.bao.news.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器开始执行");
		Long startTime=System.currentTimeMillis();
		System.out.println("拦截器开始执行"+startTime);
		String result = invocation.invoke();//将请求转交给下一个拦截器或action
		System.out.println(result);
		Long endTime=System.currentTimeMillis();
		System.out.println("拦截器开始执行"+endTime);
		
		System.out.println("时间差"+(endTime-startTime));
		return result;
	}

}
