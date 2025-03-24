/*
    Dynamic Array:
    Resizeable array-like data structure that allows elements to be accessed via an index.

    Pros:
    - Fast random access O(1) - Can directly access any index.
    - Efficient memory usage – Stores elements in contiguous memory without extra pointers.
    - Fast insertion at the end (O(1) amortized) – If there’s space, appending is quick.
    - Fast deletion at the end (O(1) amortized) – Removing from the end is efficient.

    Cons:
    - Insertion/removal at the beginning is slow (O(n)) – Requires shifting elements.
    - Middle insertions/deletions are costly (O(n)) – Due to shifting elements.
    - Resizing overhead (O(n)) – When full, resizing and copying elements to a new array is expensive.
    - Inefficient for frequent insertions/removals – Not ideal for dynamic changes except at the end
*/

public class DynamicArray {
    private int[] items;
    private int count;

    public DynamicArray(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int item) {
        // If we find it, return index
        // Otherwise, return -1
        // O(1)
        // O(n)
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void print() {
        for (int i =0; i < count; i++)
            System.out.println(items[i]);
    }
}
