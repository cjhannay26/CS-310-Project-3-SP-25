import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clojure.java.api.Clojure;

class UnitTests {
	@BeforeAll
	static void requires() {
        var require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("Alice"));
        // require.invoke(Clojure.read("Bob"));
	}

	@Test
	void testAliceThirdClojure() {
		var third = Clojure.var("Alice", "third");
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", third.invoke(list));
	}

	@Test
	void testAliceThirdJava() {
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", Alice.third(list));
	}

	@Test
	void testMichaelMapJava() {
		// This is for testing Michael's map function (Java)
	}

	@Test
	void testMichaelMapClojure() {
		// This is for testing Michael's map function (Clojure)
	}

	@Test
	void testMichaelSameJava() {
		var list1 = List.of("A", "B", "C", "D", "E");
		var list2 = List.of("A", "B", "C", "D", "E");
		var list3 = List.of("Z", "B", "C", "D", "E");
		assertEquals(true, Michael.same(list1, list2));
		assertEquals(false, Michael.same(list1, list3));
	}

	@Test
	void testMichaelSameClojure() {
		/*var same = Clojure.var("Michael", "same");
		var list1 = List.of("A", "B", "C", "D", "E");
		var list2 = List.of("A", "B", "C", "D", "E");
		var list3 = List.of("Z", "B", "C", "D", "E");
		assertEquals(true, same.invoke(list1, list2));
		assertEquals(false, same.invoke(list1, list3));*/
	}

	@Test
	void testGracieMemberJava() {
		// This is for testing Gracie's member function (Java)
	}

	@Test
	void testGracieMemberClojure() {
		// This is for testing Gracie's member function (Clojure)
	}

	@Test
	void testGracieAppendJava() {
		// This is for testing Gracie's append function (Java)
	}

	@Test
	void testGracieAppendClojure() {
		// This is for testing Gracie's append function (Clojure)
	}

	@Test
	void testMasonIntersectJava() {
		// This is for testing Mason's intersect function (Java)
	}

	@Test
	void testMasonIntersectClojure() {
		// This is for testing Mason's intersect function (Clojure)
	}
}
