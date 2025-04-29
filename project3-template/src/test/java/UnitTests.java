import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clojure.java.api.Clojure;

class UnitTests {
	@BeforeAll
	static void requires() {
        var require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("Alice"));
        require.invoke(Clojure.read("Michael"));
		require.invoke(Clojure.read("Gracie"));
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
		var input1 = List.of(1, 2, 3, 4);
		var input2 = List.of();
		assertEquals(List.of(1, 8, 27, 64), Michael.map(x -> x * x * x, input1));
		assertEquals(List.of(), Michael.map(null, input2));
	}

	@Test
	void testMichaelMapClojure() {
		var map = Clojure.var("Michael", "map");
		var input1 = List.of(1, 2, 3, 4);
		var input2 = List.of();
		var cubed = input1.stream().map(x -> x * x * x).collect(Collectors.toList());
		assertEquals(List.of(1, 8, 27, 64), map.invoke(cubed, input1));
		assertEquals(List.of(), map.invoke(cubed, input2));
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
		// This is for testing Mason's intersect function (Java)
	}

	@Test
	void testMasonIntersectClojure() {
		// This is for testing Mason's intersect function (Clojure)
	}
}
