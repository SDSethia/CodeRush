package sd.codedash2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author Snehadeep Sethia
 * 
 */
public class Mailer {

	private int count;
	private int bundle;

	public Mailer(final int count, final int bundle) {
		super();
		this.count = count;
		this.bundle = bundle;
	}

	private static TreeMap<Integer, Mailer> map5 = new TreeMap<Integer, Mailer>();
	private static TreeMap<Integer, Mailer> map3 = new TreeMap<Integer, Mailer>();
	private static TreeMap<Integer, Mailer> map = new TreeMap<Integer, Mailer>();

	private static void addZipToBucket(final int zip, final int count) {
		if (count > 9) {
			int bundle = count / 15;
			final int reminder = count % 15;
			if (reminder > 9) {
				bundle++;
			}
			map5.put(zip, new Mailer(count, bundle));
		}
		if (count < 10) {
			final int partZip = zip / 100;
			if (map3.containsKey(partZip)) {
				final Mailer m = map3.get(partZip);
				m.count += count;
			} else {
				map3.put(partZip, new Mailer(count, 0));
			}
			map.put(zip, new Mailer(count, 0));
		}
	}

	public static void main(final String[] args) throws IOException {

		final BufferedReader in = new BufferedReader(new FileReader(
				"src/sd/codedash2012/mailer.txt"));
		String str;
		final TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		while ((str = in.readLine()) != null) {
			try {
				final int zip = Integer.parseInt(str);
				if ((zip > 10000) && (zip < 100000)) {
					int count = tree.containsKey(zip) ? tree.get(zip) : 0;
					tree.put(zip, ++count);
				}
			} catch (final NumberFormatException e) {
				continue;
			}

		}
		for (final Entry<Integer, Integer> entry : tree.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			addZipToBucket(entry.getKey(), entry.getValue());
		}
		System.out.println("five");
		for (final Entry<Integer, Mailer> entry : map5.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue().count
					+ " " + entry.getValue().bundle);
		}
		System.out.println("three");
		for (final Entry<Integer, Mailer> entry : map3.entrySet()) {
			final int count = entry.getValue().count;
			if (count > 9) {
				int bundle = count / 15;
				final int reminder = count % 15;
				if (reminder > 9) {
					bundle++;
				}
				entry.getValue().bundle = bundle;
				System.out.println(entry.getKey() + "XX "
						+ entry.getValue().count + " "
						+ entry.getValue().bundle);

				final Iterator it = map.entrySet().iterator();
				while (it.hasNext()) {
					final Entry<Integer, Integer> dup = (Entry<Integer, Integer>) it
							.next();
					final int key = dup.getKey() / 100;
					if (key == entry.getKey()) {
						it.remove();
					}
				}
			}
		}

		System.out.println("one");
		for (final Entry<Integer, Mailer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue().count
					+ " " + entry.getValue().bundle);
		}
	}
}
