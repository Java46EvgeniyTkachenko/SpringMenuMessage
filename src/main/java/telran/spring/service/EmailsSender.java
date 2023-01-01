package telran.spring.service;

import java.util.Scanner;
import java.lang.String;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailsSender implements Sender {
	String emailAddress;
	static Scanner scanner = new Scanner(System.in);
	@Override
	public void send(String text) {
	while (!emailAddress.matches(emailRegex())) {	
		System.out.println("Enter email address for send message ");
		emailAddress = scanner.nextLine();
		
		if (!emailAddress.matches(emailRegex())) {	
			System.out.printf("\n email address '%s' is incorrect!\n",emailAddress);			
		}
	}
		System.out.printf("email message '%s' has been sent to email address %s\n", text, emailAddress);
	//	System.out.printf("Email message: %s has been sent\n", text);

	
	}
	public EmailsSender(String emailAddress) {

		this.emailAddress = emailAddress;
	}
	private String emailRegex() {
		String prefix = "[A-Za-z\\d]([A-Za-z\\d]|[._-][A-Za-z\\d])+";
		String domain = "[A-Za-z\\d]([A-Za-z\\d]|-[A-Za-z\\d])+(\\.[A-Za-z\\d]([A-Za-z\\d]|-[A-Za-z\\d])+){1,4}";
		return String.format("(%s)@(%s)", prefix, domain);
	}

}
