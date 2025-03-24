import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var list = new LinkedList();
        System.out.println("Size: " + list.size());
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        System.out.println("Size: " + list.size());
        list.removeFirst();
        System.out.println("Size: " + list.size());
        System.out.println("Index: " + list.indexOf(30));
        System.out.println("Contains: " + list.contains(10));
        list.removeLast();
        System.out.println("Size: " + list.size());

        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        list.reverse();
        var array2 = list.toArray();
        System.out.println(Arrays.toString(array2));

        System.out.println(list.getKthFromTheEnd(3));

        list.printMiddle();
    }
}