# StackStackSort

A Java project demonstrating multiple algorithms for sorting stacks **without using additional data structures like arrays or lists** beyond auxiliary stacks. 
Ths Stack Class assumes that you are extending Comparable so that the elements can be sorted.  
It includes three unique stack-sorting methods, testing via JUnit, and examples using both integers and strings.

---

## 📁 Project Structure

StackStackSort/  
├── Stack.java # Generic Stack implementation with sorting algorithms  
├── StackSort.java # Main class for demonstration and random stack generation  
├── TestStack.java # JUnit test suite for validating stack-sorting methods


---

## 🧩 Features

### `Stack.java`
Implements a generic stack class `Stack<T extends Comparable<T>>` backed by an `ArrayList<T>` with:
- Basic operations: `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`
- Three sorting algorithms:
    1. **`stackSort()`** – Sorts using two auxiliary stacks (`orderedStack` and `reverseOrder`)
    2. **`twoStackSort()`** – Sorts using only two stacks (`this` and `orderedStack`)
    3. **`originalStackSort()`** – Sorts in place using the original stack and a temporary helper stack

### `StackSort.java`
A simple driver class that:
- Generates stacks of random integers and random strings.
- Sorts them using `stackSort()`.
- Prints the stacks before and after sorting.

### `TestStack.java`
A JUnit 5 test suite that:
- Uses parameterized tests with `@MethodSource`.
- Validates all three sorting methods (`stackSort`, `twoStackSort`, and `originalStackSort`) for correctness.
- Tests stacks of multiple data types including:
    - `Integer`
    - `Double`
    - `String`
    - `Character`
    - `LocalDate`

---

## 🧠 How It Works

The sorting algorithms rely on **stack-to-stack comparisons**:
- Elements are popped from the original stack and inserted into a helper stack in sorted order.
- When a new element is smaller than the top of the helper stack, items are temporarily moved back to ensure correct positioning.

This simulates insertion sort logic using only stack operations (`push`, `pop`, and `peek`).

---

## 🚀 Running the Program

### 1. Compile the Java Files
```
javac Stack.java StackSort.java
```

### 1. Run the Demo
```
java StackSort
```
You’ll see randomly generated stacks printed before and after sorting.  

## 🧪 Running the Tests

To run the JUnit 5 tests:

Ensure JUnit 5 is available on your classpath.

Compile the source files:
```
javac -cp .:junit-platform-console-standalone.jar *.java
```
Run the tests:

    java -jar junit-platform-console-standalone.jar -cp . --scan-class-path

## 🧰 Example Output

[3, 7, 2, 9, 4, 1]  
[1, 2, 3, 4, 7, 9]

[cat, banana, apple]  
[apple, banana, cat]

## ⏱️ Complexity Analysis
| Method              | 	Description	                                                                        | Time Complexity | Space Complexity |
|---------------------|--------------------------------------------------------------------------------------|:---------------:|:----------------:|
| stackSort()         | Uses two helper stacks (orderedStack and reverseOrder) to sort elements              |      O(n²)      |       O(n)       |
| twoStackSort()      | Uses only the main and one helper stack; repeatedly moves elements to maintain order |      O(n²)      |       O(n)       |
| originalStackSort() | Sorts elements directly within the original stack using two temporary stacks         |      O(n²)      |       O(n)       |

Explanation:
All three algorithms rely on repeatedly comparing and transferring stack elements to maintain sorted order.
Each element may be moved multiple times, leading to quadratic time complexity.
The use of extra stacks leads to linear auxiliary space usage.
## 💻 Author

Developed by Elisheva Goldfarb
For educational purposes and demonstration of stack-based sorting algorithms in Java.


