import java.util.*;

public class StackSort {

    public static void main(String[] args) {

        integerStack();
        stringStack();
        
    }


    public static void integerStack() {
        Stack<Integer> integers = new Stack<Integer>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            integers.push(random.nextInt(10));
        }

        System.out.println(integers);

        integers = integers.stackSort();

        System.out.println(integers);
    }

    public static void stringStack() {
        Stack<String> strings = new Stack<String>();

        for (int i = 0; i < 20; i++) {
            strings.push(generateRandomString());
        }

        System.out.println(strings);

        strings = strings.stackSort();

        System.out.println(strings);
    }



    public static String generateRandomString() {

        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < random.nextInt(11); i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }


}
