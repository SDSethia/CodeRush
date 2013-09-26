package ref;

public class Test {

	public static void main(final String[] args) {

		final AppTest t = new AppTest();
		final Class c[] = Character.class.getDeclaredClasses();
		for (final Class x : c) {
			System.out.println(x);
		}
	}

}
