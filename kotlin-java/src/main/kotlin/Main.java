import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return this.x == node.x && this.y == node.y;
    }

    @Override
    public int hashCode() {
        return this.x * 1000 + this.y;
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Node> set = new HashSet<>();
        set.add(new Node(1, 1));
        set.add(new Node(1, 2));
        set.add(new Node(1, 3));

        Node node = new Node(1, 1);
        System.out.println(set.contains(node));
        node.x = 2;
        System.out.println(set.contains(node));
        node.x = 1;
        node.y = 2;
        System.out.println(set.contains(node));

    }
}