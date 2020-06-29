import java.util.LinkedList;
import java.util.Queue;

public class MyClass {
    public static void main(String args[]) {
        LinkedList<String> queue = new LinkedList<String>();
        queue.addLast("one");
        queue.addLast("two");
        queue.addLast("three");
        queue.addLast("four");
        System.out.println(queue);
        String polledElement = queue.removeFirst();
        System.out.println(polledElement);
        System.out.println(queue);
        String peekedElement = queue.getFirst();
        System.out.println(peekedElement);
        System.out.println(queue);
        while(queue.size() > 0) {
        System.out.println(queue.removeFirst());
        }
    }
}