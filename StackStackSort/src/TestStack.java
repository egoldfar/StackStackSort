
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.*;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestStack {

    @ParameterizedTest
    @MethodSource("provideArrayList")
    public <E extends Comparable<E>> void testStack(ArrayList<E> arraylist) {

        ArrayList<E> array = new ArrayList<>(arraylist);
        Stack<E> stack = new Stack<>();
        Random random = new Random();

        while(!array.isEmpty()) {
           stack.push(array.remove(random.nextInt(array.size())));
        }

        testStackSort(stack, new ArrayList<>(arraylist));
        testTwoStackSort(stack, new ArrayList<>(arraylist));
        testOriginalStackSort(stack, new ArrayList<>(arraylist));
    }

    public <E extends Comparable<E>>  void testStackSort(Stack<E> stack, ArrayList<E> arraylist) {

        stack = new Stack<>(stack);

        stack = stack.stackSort();

        stackSortAssertions(stack, arraylist);

    }

    public <E extends Comparable<E>>  void testTwoStackSort(Stack<E> stack, ArrayList<E> arraylist) {

        stack = new Stack<>(stack);

        stack = stack.twoStackSort();

        stackSortAssertions(stack, arraylist);

    }
    public <E extends Comparable<E>>  void testOriginalStackSort(Stack<E> stack, ArrayList<E> arraylist) {

        stack = new Stack<>(stack);

        stack.originalStackSort();

        stackSortAssertions(stack, arraylist);

    }

    public <E extends Comparable<E>>  void stackSortAssertions(Stack<E> stack, ArrayList<E> arrayList) {
        while(!stack.isEmpty()) {
            assertEquals(arrayList.removeLast(), stack.peek());
            stack.pop();
        }

    }

     static Stream<ArrayList> provideArrayList() {
        return Stream.of(
                new ArrayList<>(Arrays.asList("apple", "banana", "cherry")),
                new ArrayList<>(Arrays.asList("cat", "elephant")),
                new ArrayList<>(Arrays.asList("blue", "green","purple","red")),
                new ArrayList<>(Arrays.asList(1, 2, 3,4)),
                new ArrayList<>(Arrays.asList(-9, 7, 21, 112)),
                new ArrayList<>(Arrays.asList(-3.0, 0.5, 1.0, 2.987, 2.99)),
                new ArrayList<>(Arrays.asList('A', 'B', 'Y','Z')),
                new ArrayList<>(Arrays.asList('1', '2', '7')),
                new ArrayList<>(Arrays.asList(LocalDate.of(2024, 10, 13),
                    LocalDate.of(2025, 11, 14), LocalDate.of(2026, 1, 15),
                    LocalDate.of(2026, 9, 30)
                ))
        );
    }





}
