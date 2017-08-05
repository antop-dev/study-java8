package ch01;

public class Ex08 {

	public static void main(String[] args) {
		String s = "Slack brings all your communication together in one place. It's real-time messaging, archiving and search for modern teams.";
		System.out.println(s);

		String result = "";

		for (char c : s.toCharArray()) {
			if (c != ' ') {
				result += c;
			}
		}

		System.out.println(result);
	}

}
