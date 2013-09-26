package ref;

import java.lang.reflect.Method;

public class Reflect {
	public static void main(final String[] args) {

		// no paramater
		final Class noparams[] = {};

		// String parameter
		final Class[] paramString = new Class[1];
		paramString[0] = String.class;

		// int parameter
		final Class[] paramInt = new Class[1];
		paramInt[0] = Integer.TYPE;

		try {
			// load the AppTest at runtime
			final Class cls = Class.forName("ref.AppTest");
			final Object obj = cls.newInstance();

			// call the printIt method
			Method method = cls.getDeclaredMethod("printIt", noparams);
			method.invoke(obj, null);

			// call the printItString method, pass a String param
			method = cls.getDeclaredMethod("printItString", paramString);
			method.invoke(obj, new String("mkyong"));

			// call the printItInt method, pass a int param
			method = cls.getDeclaredMethod("printItInt", paramInt);
			method.invoke(obj, 123);

			// call the setCounter method, pass a int param
			method = cls.getDeclaredMethod("setCounter", paramInt);
			method.invoke(obj, 999);

			// call the printCounter method
			method = cls.getDeclaredMethod("printCounter", noparams);
			method.invoke(obj, null);

		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}
}
