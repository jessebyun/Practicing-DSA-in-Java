import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

//        for (int i = 0; i < input.length(); i++)
//            stack.push(input.charAt(i));

        // For-Each loop is cleaner (don't have to work with an index)
        // in Java, cannot use For-Each loop on a string but can convert string to character array
        for (char ch : input.toCharArray())
            stack.push(ch);

//        String reversed = "";
//        while (!stack.empty())
//            reversed += stack.pop(); // every append will create a new object -expensive-
        // when modifying a string, it is allocated in new memory space
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}
