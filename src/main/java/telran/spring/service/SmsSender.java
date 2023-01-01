package telran.spring.service;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.String;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsSender implements Sender {
	String phoneNumber;
	static Scanner scanner = new Scanner(System.in);
	@Override
	public void send(String text) {
	while(!Pattern.matches("\\d{3}[-]\\d{7}", phoneNumber)) {	
		System.out.println("Enter phone number for send SMS ");
		phoneNumber = scanner.nextLine();

		if (!Pattern.matches("\\d{3}[-]\\d{7}", phoneNumber)) {
		
			System.out.printf("\n phone number '%s' is incorrect! \n",phoneNumber);
		}
	}
		
		System.out.printf("sms message '%s' has been sent to phone %s\n", text, phoneNumber);
	//	System.out.printf("SMS message: %s has been sent\n", text);

	}
	
	public SmsSender(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

}
