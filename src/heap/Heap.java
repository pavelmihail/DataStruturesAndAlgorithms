package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        // Add the new value to the end of the heap.
        heap.add(value);

        // Get the index of the new value (which is at the end of the heap).
        int current = heap.size() - 1;

        // While the new value is not at the root and is greater than its parent,
        // continue to swap it with its parent to maintain the "max heap" property.
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {

            // Swap the new value with its parent.
            swap(current, parent(current));

            // Update the current index to be the index of the parent
            // (since we just swapped the new value with its parent).
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        // Start at the provided index (this is typically the root)
        int maxIndex = index;

        // Continue sinking down until the element at maxIndex is correctly positioned
        while (true) {
            // Get indices of left and right children
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            // If left child exists and is greater than the current max,
            // then update maxIndex to left child's index
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            // If right child exists and is greater than the current max,
            // then update maxIndex to right child's index
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            // If maxIndex has changed (i.e., one of the children was greater),
            // then swap the current element with the larger child and continue sinking down
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                // If the element has not been swapped, this means it's in the correct position,
                // so we break the loop and end the method
                return;
            }
        }
    }

    public Integer remove() {
        // First, check if the heap is empty (size 0). If it is,
        // there's nothing to remove, so return null.
        if (heap.size() == 0) {
            return null;
        }

        // If the heap has only one element, this block executes.
        // Here, 'heap.remove(0)' is called, which is NOT a recursive call
        // to this 'remove' method. Instead, it's a call to the 'remove'
        // method of the 'heap' object, which is a List or similar
        // collection. This standard collection method removes and returns
        // the element at index 0 (the root of the heap).
        if (heap.size() == 1) {
            return heap.remove(0); // Remove and return the only element.
        }

        // For heaps with more than one element:
        // Store the maximum value, which is always at the root
        // (index 0) in a max heap. This is the element to return
        // after reorganizing the heap.
        int maxValue = heap.get(0);

        // Replace the root element with the last element in the heap.
        // This step prepares the heap for re-heapification (sink down process).
        // The last element is then removed from the heap's end.
        heap.set(0, heap.remove(heap.size() - 1));

        // Reorganize the heap (sink down process) to maintain
        // the max heap property after removing the root element.
        // This process moves the new root down to its correct position
        // in the heap, ensuring the max heap properties are maintained.
        sinkDown(0);

        // Finally, return the original maximum value that was
        // at the root of the heap.
        return maxValue;
    }
}
