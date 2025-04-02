/*
LIFO Last in First out principal. Stack works like a wrapper around an array or linked list.
Stacks are good when trying to do something in reverse order.

4 operations in a stack:
    push(item) adds element to the top
    pop() removes element from the top
    peek() returns item from the top without removing
    isEmpty()
 No lookups - not for storing list of products, customers, etc.

 Runtime Complexity for all 4 operations: O(1)

 */

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stackRev = new Stack<>();
        stackRev.push(10);
        stackRev.push(20);
        stackRev.push(30);
        System.out.println(stackRev);
        var top = stackRev.pop();
        System.out.println(top);
        System.out.println(stackRev);
        top = stackRev.peek();
        System.out.println(top);

        String str = "abcd";

        StringReverser reverser = new StringReverser();
        var result = reverser.reverse(str);
        System.out.println(result);

        // Edge cases
        // (
        // (()
        // ) (  Throws EmptyStackException - Need to check if stack is empty before pop
        String str1 = "(1 + 2)";
        String str2 = "(1 + 2>";
        String str3 = "[1 + 2]]";
        Expression exp = new Expression();
        var strResult1 = exp.isBalanced(str1);
        System.out.println(strResult1);
        var strResult2 = exp.isBalanced(str2);
        var strResult3 = exp.isBalanced(str3);
        System.out.println(strResult2);
        System.out.println(strResult3);

        StackBuild stack = new StackBuild();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
    }
}