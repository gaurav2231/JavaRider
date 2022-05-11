package com.gaurav.Service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.gaurav.Entity.Customer;
import com.gaurav.Repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
    @Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String getOtp() {
		 Random rnd = new Random();
		    int number = rnd.nextInt(999999);

		    // this will convert any number sequence into 6 character.
		 System.out.println("OTP is : "+String.format("%06d", number)); 
		 String otp=String.format("%06d", number);
		 return otp;
		
	}

		@Override
        public void register(Customer customer) {
		 customerRepo.save(customer);
	}
	
		public void sendEmail(String subject , String From , String To , String content) {
	      MimeMessage mimeMessage=javaMailSender.createMimeMessage();
	      try {
			MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setFrom(From);
			mimeMessageHelper.addTo(To);
			mimeMessageHelper.setText(content);
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
		        }catch(MessagingException mex) {
		        	mex.printStackTrace();
		        }
		}

		@Override
		public double calculateDistance(String source, String destination) {
			double slat = Double.parseDouble(source.split(",")[0]);
			double slong = Double.parseDouble(source.split(",")[1]);

			double dlat = Double.parseDouble(destination.split(",")[0]);
			double dlong = Double.parseDouble(destination.split(",")[1]);

			final double R = 6371e3;
			final double A = slat * Math.PI / 180;
			final double B = dlat * Math.PI / 180;
			final double calculate1 = (dlat - slat) * Math.PI / 180;
			final double calculate2 = (dlong - slong) * Math.PI / 180;

			final double a = Math.sin(calculate1 / 2) * Math.sin(calculate1 / 2)
					+ Math.cos(A) * Math.cos(B) * Math.sin(calculate2 / 2) * Math.sin(calculate2 / 2);
			final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

			final double d = R * c;
			return d/1000;
		}     
}	 
		 
		 
		 
		 