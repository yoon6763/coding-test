import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3);
        stack.add(3, 1);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}