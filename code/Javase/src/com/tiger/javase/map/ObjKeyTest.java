package com.tiger.javase.map;

import java.util.HashMap;
import java.util.Map;

public class ObjKeyTest {

	public static void main(String[] args) {
		Map<ObjKey, String> map = new HashMap<ObjKey, String>();
		ObjKey ok1 = new ObjKey(1, 11, "a");
		map.put(ok1, "aa");
		System.out.println(map.get(new ObjKey(1, 11, "a")));

		System.out.println(map.get(new ObjKey(2, 11, "a")));

		ObjKey ok2 = new ObjKey(1, 11, "a");
		ok2.setName("b");
//		ok2.setId(3);
		map.put(ok2, "bb");
		System.out.println(map.get(new ObjKey(1, 11, "a")));
	}

	static class ObjKey {
		private int id;
		private int old;
		private String name;

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			if (this.id != ((ObjKey) obj).id)
				return false;
			return true;
		}

		public int hashCode() {
			final int ii = 8;
			final int jj = 10;
			return ii * jj + this.id;
		}

		public int getId() {
			return id;
		}

		public ObjKey(final int id, int old, String name) {
			super();
			this.id = id;
			this.old = old;
			this.name = name;
		}

		public int getOld() {
			return old;
		}

		public void setOld(int old) {
			this.old = old;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
