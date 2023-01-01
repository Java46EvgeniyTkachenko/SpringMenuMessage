package telran.spring.service;

import java.util.Scanner;
import java.lang.String;

import org.springframework.stereotype.Service;

@Service("TCP")
public class TcpSender implements Sender {
	String ipPort; // ipv4:port
	static Scanner scanner = new Scanner(System.in);

	@Override
	public void send(String text) {
		while (!isIPv4(ipPort)) {
			System.out.println("Enter TCP IP address  for send message ");
			ipPort = scanner.nextLine();
			if (!isIPv4(ipPort)) {
				System.out.printf("\n tcp ip '%s' incorrect! \n", ipPort);
			}
		}

		System.out.printf("tcp message '%s' has been sent to ip:port %s\n", text, ipPort);

	}

	public TcpSender(String ipPort) {
		this.ipPort = ipPort;
	}

	public static boolean isIPv4(String ipV4str) {

		return ipV4str.matches(ipV4Regex());
	}

	public static String ipV4Regex() {

		return String.format("((%s)\\.){3}(%s)\\:[1-9]\\d{3,4}", ipOctetRegex(), ipOctetRegex());
	}

	private static String ipOctetRegex() {

		return "\\d\\d?|[0,1]\\d\\d|2[0-4]\\d|25[0-5]";
	}

}
