import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clojure.java.api.Clojure;

class UnitTests {
	@SuppressWarnings("unused")
	@BeforeAll
	static void requires() {
        var require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("Michael"));
		require.invoke(Clojure.read("Gracie"));
		require.invoke(Clojure.read("Mason"));
	}

	@Test
	void testMichaelMapJava() {
		var input1 = List.of(1, 2, 3, 4);
		var input2 = List.of();

		assertEquals(List.of(1, 8, 27, 64), Michael.map(x -> x * x * x, input1));
		assertEquals(List.of(), Michael.map(null, input2));
	}

	@Test
	void testMichaelMapClojure() {
		var map = Clojure.var("Michael", "map");
		var vec = Clojure.var("clojure.core", "vec");
		var input1 = List.of(1, 2, 3, 4);
		var input2 = List.of();

		var cubeFunction = Clojure.var("Michael", "cube");

		var clojureResult1 = vec.invoke(map.invoke(cubeFunction, input1));
		var clojureResult2 = vec.invoke(map.invoke(cubeFunction, input2));

		// We had lots of trouble testing this one and got this to work
		// We would like some feedback on whether or not there is a better way to do this
		List<Long> result1 = new ArrayList<>();
		for (Object o : (Iterable<?>) clojureResult1) {
			result1.add((Long) o);
		}

		List<Long> result2 = new ArrayList<>();
		for (Object o : (Iterable<?>) clojureResult2) {
			result2.add((Long) o);
		}

		assertEquals(List.of(1L, 8L, 27L, 64L), result1);
		assertEquals(List.of(), result2);
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
		var same = Clojure.var("Michael", "same");

		var list1 = List.of("A", "B", "C", "D", "E");
		var list2 = List.of("A", "B", "C", "D", "E");
		var list3 = List.of("Z", "B", "C", "D", "E");

		assertEquals(true, same.invoke(list1, list2));
		assertEquals(false, same.invoke(list1, list3));
	}

	@Test
	void testGracieMemberJava() {
		var element = "A";

		var list1 = List.of("A", "B", "C", "D", "E");
		var list2 = List.of("B", "C", "D", "E");
		var list3 = List.of();

		assertEquals(true, Gracie.member(element, list1));
		assertEquals(false, Gracie.member(element, list2));
		assertEquals(false, Gracie.member(element, list3));
	}

	@Test
	void testGracieMemberClojure() {
		var member = Clojure.var("Gracie", "member");

		var element = "A";
		var list1 = List.of("A", "B", "C", "D", "E");
		var list2 = List.of("B", "C", "D", "E");
		var list3 = List.of();

		assertEquals(true, member.invoke(element, list1));
		assertEquals(false, member.invoke(element, list2));
		assertEquals(false, member.invoke(element, list3));
	}

	@Test
	void testGracieAppendJava() {
		var list1 = List.of("A", "B", "C", "D");
		var list2 = List.of("W", "X", "Y", "Z");
		var list3 = List.of();

		assertEquals(List.of("A", "B", "C", "D", "W", "X", "Y", "Z"), Gracie.append(list1, list2));
		assertEquals(List.of("W", "X", "Y", "Z"), Gracie.append(list2, list3));
		assertEquals(List.of("A", "B", "C", "D"), Gracie.append(list3, list1));
	}

	@Test
	void testGracieAppendClojure() {
		var append = Clojure.var("Gracie", "append");

		var list1 = List.of("A", "B", "C", "D");
		var list2 = List.of("W", "X", "Y", "Z");
		var list3 = List.of();

		assertEquals(List.of("A", "B", "C", "D", "W", "X", "Y", "Z"), append.invoke(list1, list2));
		assertEquals(List.of("W", "X", "Y", "Z"), append.invoke(list2, list3));
		assertEquals(List.of("A", "B", "C", "D"), append.invoke(list3, list1));
	}

	@Test
	void testMasonIntersectJava() {
		var list1 = List.of("Y", "N", "E", "O", "S", "G", "T");
		var list2 = List.of("Y", "E", "S", "Z");
		var list3 = List.of("R", "A", "P");

		assertEquals(List.of("Y", "E", "S"), Mason.intersect(list1, list2)); // Returns Matching list
		assertEquals(List.of(), Mason.intersect(list1, list3)); // No matches between lists
		assertEquals(List.of(), Mason.intersect(List.of(), list3)); // First list passed is null, should return null list
	}

	@Test
	void testMasonIntersectClojure() {
		var intersect = Clojure.var("Mason", "intersect");

		var list1 = List.of("Y", "N", "E", "O", "S", "G", "T");
		var list2 = List.of("Y", "E", "S", "Z");
		var list3 = List.of();
		var list4 = List.of("R", "A", "P");

		assertEquals(List.of("Y", "E", "S"), intersect.invoke(list1, list2)); // Returns Matching list
		assertEquals(List.of(), intersect.invoke(list1, list4)); // No matches between lists
		assertEquals(List.of(), intersect.invoke(list3, list1)); // First list passed is null, should return null list
	}
}