package heapmemorytest.com;

import java.util.ArrayList;
import java.util.List;

public class HeapMemoryTest {
	public static void main(String[] args) {
		List<byte[]> list = new ArrayList<>();

		try {
			for (int i = 0; i < 200000; i++) {
				byte[] bytes = new byte[10000];
				list.add(bytes);
				System.out.println(list);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

