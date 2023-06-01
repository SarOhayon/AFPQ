import adt.PriorityQueue;

public class Main {

    public static void printQueue(PriorityQueue<String> queue) {
        System.out.println();
        System.out.println("Queue - Size " + queue.size() + ": ");
        System.out.println(queue);
    }

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        System.out.println("Inserted pair: (8, D)");
        var entryD = queue.insert(8, "D");
        System.out.println("Inserted pair: (5, C)");
        var entryF = queue.insert(5, "F");
        System.out.println("Inserted pair: (4, F)");
        var entryB = queue.insert(4, "B");
        System.out.println("Inserted pair: (0, A)");
        queue.insert(0, "A");
        System.out.println("Inserted pair: (1, C)");
        queue.insert(1, "C");
        System.out.println("Inserted pair: (2, E)");
        queue.insert(2, "E");
        System.out.println("Inserted pair: (10, H)");
        queue.insert(10, "H");
        System.out.println("Inserted pair: (12, G)");
        var entryG = queue.insert(12, "G");
        System.out.println("Inserted pair: (7, I)");
        queue.insert(7, "I");

        printQueue(queue);
        queue.toggle();
        printQueue(queue);
queue.replaceKey(entryB, 15);
      printQueue(queue);

        /*
        printQueue(queue);

        var entry = queue.removeTop();
        System.out.println("Removed: " + entry.getValue());
        entry = queue.removeTop();
        System.out.println("Removed: " + entry.getValue());
        entry = queue.removeTop();
        System.out.println("Removed: " + entry.getValue());

        printQueue(queue);

        queue.remove(entryD);
        System.out.println("Removed entry (8, D)");

        queue.remove(entryG);
        System.out.println("Removed entry (12, G)");

        printQueue(queue);

        System.out.println("Toggled queue, new state: " + queue.state());
        queue.toggle();

        printQueue(queue);

        queue.replaceKey(entryF, 15);
        System.out.println("Replaced key of F with 15");
        queue.replaceValue(entryB, "J");
        System.out.println("Replaced value of B with J");

        printQueue(queue);

        entry = queue.removeTop();
        System.out.println("Removed: " + entry.getValue());
        entry = queue.removeTop();
        System.out.println("Removed: " + entry.getValue());

        printQueue(queue);

        System.out.println("Toggled queue, new state: " + queue.state());
        queue.toggle();

        printQueue(queue);

        while (!queue.isEmpty()) {
            var top = queue.top();
            System.out.println("Top entry: (" + top.getKey() + ", " + top.getValue() + ")");
            queue.removeTop();
            System.out.println("Removed top entry");
        }
*/
        //printQueue(queue);
    }

}
