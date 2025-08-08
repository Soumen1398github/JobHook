package com.jobportal.utility;

public class Data {
	public static String getMessageBody(String otpCode) {
		 return "<!DOCTYPE html>" +
	                "<html><head><meta charset='UTF-8'><title>OTP Verification</title></head>" +
	                "<body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>" +
	                "<div style='background-color: #ffffff; padding: 20px; border-radius: 8px; max-width: 600px; margin: auto;'>" +
	                "<h2 style='color: #333;'>Verify Your Email Address</h2>" +
	                "<p>Thank you for signing up. Please use the following OTP to verify your email:</p>" +
	                "<h1 style='color: #4CAF50;'>" + otpCode + "</h1>" +
	                "<p>This OTP is valid for 10 minutes. Please do not share it with anyone.</p>" +
	                "<br><p>Thanks,<br/>The Team</p>" +
	                "</div>" +
	                "</body></html>";
	}

}
