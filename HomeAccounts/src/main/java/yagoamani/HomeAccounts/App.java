package yagoamani.HomeAccounts;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try {
			Interface window = new Interface();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
