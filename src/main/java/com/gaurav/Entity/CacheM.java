package com.gaurav.Entity;

import java.util.Date;

public class CacheM {

	 private String otp;
		
		Date expiryTime =new Date(System.currentTimeMillis()+(1000*60*5));

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public Date getExpiryTime() {
			return expiryTime;
		}

		public void setExpiryTime(Date expiryTime) {
			this.expiryTime = expiryTime;
		}

		
		
}
