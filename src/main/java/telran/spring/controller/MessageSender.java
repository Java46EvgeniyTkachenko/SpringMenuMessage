package telran.spring.controller;

import java.util.*;
import telran.view.*;

import org.springframework.stereotype.Component;

import telran.spring.service.Sender;

@Component
public class MessageSender {
Map<String, Sender> senders;
public MessageSender(Map<String, Sender> senders) {
	
	this.senders = senders;
}

public void menu() {
//	Scanner scanners = new Scanner(System.in);
//	String line;
	
	Menu menu = new Menu("Send Messege", getItems());
	menu.perform(new ConsoleInputOutput());
	System.out.println(" \n End of process sending message!");

	
	
	
//	while (true) {
//		System.out.printf("enter type from %s or exit\n", getTypes());
//		line = scanners.nextLine();
//		if (line.equalsIgnoreCase("exit")) {
//			break;
//		}
//		Sender sender = senders.get(line);
//		if (sender == null) {
//			System.out.println(line + " type doesn't exist");
//		} else {
//			System.out.println("Enter text");
//			line = scanners.nextLine();
//			sender.send(line);
//		}
//	}
}
private  Item[] getItems() {
	Item[] res = { Item.of("Send messege", t -> {
		System.out.printf("enter type from %s or exit\n", getTypes());
		String line = t.readString(null);
		Sender sender = senders.get(line);
		if (sender == null) {
			System.out.println(line + " type doesn't exist");
		} else {
			System.out.println("Enter text");
			line = t.readString(null);
			sender.send(line);
		}
		
	}, false),

			Item.exit()
	};
	return res;
}
private Set<String> getTypes() {
	
	return senders.keySet();
}

}
