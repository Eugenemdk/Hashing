package hashing;

import java.util.Hashtable;


public class Main {

	public static void main(String[] args) {
		
		 HashTableOpenAddressing<String, String> ht = new HashTableOpenAddressing<>();
		    int h;
		    System.out.println("hash(a) = " + (h = ht.hash("a")) + ", index(a) = " + ht.getIndex(h));
		    System.out.println("hash(b) = " + (h = ht.hash("b")) + ", index(b) = " + ht.getIndex(h));
		    System.out.println("hash(c) = " + (h = ht.hash("c")) + ", index(c) = " + ht.getIndex(h));
		    System.out.println("hash(d) = " + (h = ht.hash("d")) + ", index(d) = " + ht.getIndex(h));
		    System.out.println("hash(e) = " + (h = ht.hash("e")) + ", index(e) = " + ht.getIndex(h));
		    System.out.println("hash(f) = " + (h = ht.hash("f")) + ", index(f) = " + ht.getIndex(h));
		    ht.put("a", "a");
		    ht.put("a", "b");
		    ht.put("b", "c");
		    ht.put("c", "c");
		    ht.put("d", "d");
		    ht.put("e", "e");
		    ht.put("f", "f");
		    System.out.println("ht.get(\"f\") = " + ht.searchElement("f"));
		    System.out.println("ht.get(\"b\") = " + ht.searchElement("b"));
		    ht.print();
		    ht.remove("f");
		    ht.remove("e");
		    ht.remove("d");
		    ht.remove("c");
		    ht.remove("b");
		    ht.print();
		    System.out.println("ht.get(\"f\") = " + ht.searchElement("f"));
		    System.out.println("ht.get(\"b\") = " + ht.searchElement("b"));
}
}
