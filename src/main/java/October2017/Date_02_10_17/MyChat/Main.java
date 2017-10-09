package October2017.Date_02_10_17.MyChat;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Запустить программу в режиме сервера или клиента? (S(server) / C(client))");
		while (true) {
			char answer = Character.toLowerCase(in.nextLine().charAt(0));
			if (answer == 's') {
				new Server();
				break;
			} else if (answer == 'c') {
				new Client();
				break;
			} else {
				System.out.println("Некорректный ввод. Повторите.");
			}
		}
	}

}