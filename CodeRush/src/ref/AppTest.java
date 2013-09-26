package ref;

public class AppTest {

	private int counter;

	public void printIt() {
		System.out.println("printIt() no param");
	}

	public void printItString(final String temp) {
		System.out.println("printIt() with param String : " + temp);
	}

	public void printItInt(final int temp) {
		System.out.println("printIt() with param int : " + temp);
	}

	public void setCounter(final int counter) {
		this.counter = counter;
		System.out.println("setCounter() set counter to : " + counter);
	}

	public void printCounter() {
		System.out.println("printCounter() : " + counter);
	}
}
