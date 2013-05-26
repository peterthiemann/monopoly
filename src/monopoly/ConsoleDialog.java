package monopoly;

import java.util.Scanner;

public class ConsoleDialog implements IDialog {
	
	Scanner input = new Scanner(System.in);

	@Override
	public void message(String msg) {
		System.out.println(msg);
	}

	@Override
	public boolean askYesOrNo() {
		System.out.print("Yes or no? ");
		String line = input.nextLine();
		return line.matches("[yY][eE][sS]");
	}

	@Override
	public int choose(int nrChoices) {
		int choice;
		do {
			System.out.print("Enter number (1-" + nrChoices + "): ");
			choice = input.nextInt();
		} while ((choice < 1) || (choice > nrChoices) && (nrChoices > 0));
		return choice;
	}

}
