package com.ey.vehicleadv.service;

import org.springframework.stereotype.Service;

import com.ey.vehicleadv.bean.FactorialBean;

@Service
public class FactorialService {
	
	public FactorialBean factorialOfNumber(int number) {
		int result=1;

		for(int i=2;i<=number;i++)
		{
			result*=i;
		}
		FactorialBean fBean=new FactorialBean();
		fBean.setNumber(number);
		fBean.setFactorialOfNumber(result);
		
		return fBean;
	}

}
