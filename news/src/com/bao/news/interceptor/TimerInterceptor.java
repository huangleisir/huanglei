package com.bao.news.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��������ʼִ��");
		Long startTime=System.currentTimeMillis();
		System.out.println("��������ʼִ��"+startTime);
		String result = invocation.invoke();//������ת������һ����������action
		System.out.println(result);
		Long endTime=System.currentTimeMillis();
		System.out.println("��������ʼִ��"+endTime);
		
		System.out.println("ʱ���"+(endTime-startTime));
		return result;
	}

}
