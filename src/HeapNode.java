/**
 * Created by derek on 11/13/16.
 */
public class HeapNode<T extends Comparable> implements IHeapItem<HeapNode>{
    //Variables
    T item;
    int heapIndex = -1;

    //Properties
    public int getHeapIndex(){
        return heapIndex;
    }
    public void setHeapIndex(int value){
        heapIndex = value;
    }

    //Constructor
    public HeapNode(T value){
        item = value;
    }

    public int compareTo(HeapNode nodeToCompare){
        int compare = item.compareTo(nodeToCompare);

        return compare;
    }
}
