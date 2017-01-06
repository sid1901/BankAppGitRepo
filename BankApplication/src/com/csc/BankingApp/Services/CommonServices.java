package com.csc.BankingApp.Services;

public class CommonServices {

	//code to generate 10digit random acc no.
	public String randomNumGen(){
		int len=10;
		String ALPHA_NUM = "0123456789";
		String result =null;

		StringBuffer sb = new StringBuffer(len);
			for (int i = 0; i < len; i++) {
				int ndx = (int) (Math.random() * ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			result= sb.toString();
		return result;
	}
	
	
}
