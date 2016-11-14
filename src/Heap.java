import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 * Created by derek on 11/13/16.
 */
public class Heap<T extends IHeapItem>{
    //Variables
    private T[] items;
    private int itemCount;

    //Properties
    public int Count(){
        return itemCount;
    }

    //Constructors
    public Heap(int maxHeapSize){
        items = (T[]) new Object[maxHeapSize];
    }

    public T RemoveFirst(){
        T firstItem = items[0];
        itemCount--;

        items[0] = items[itemCount];
        items[0].setHeapIndex(0);

        SortDown(items[0]);
        return firstItem;
    }

    void SortDown(T item){
        while(true){
            int childIndexLeft = (item.getHeapIndex() * 2) + 1;
            int childIndexRight = (item.getHeapIndex() * 2) + 2;
            int swapIndex = 0;

            if(childIndexLeft < itemCount){
                swapIndex = childIndexLeft;

                if(childIndexRight < itemCount){
                    if(items[childIndexLeft].compareTo(items[childIndexRight]) < 0){
                        swapIndex = childIndexRight;
                    }
                }

                if(item.compareTo(items[swapIndex]) < 0){
                    Swap(item, items[swapIndex]);
                }else{
                    return;
                }
            }else{
                return;
            }
        }
    }

    public void Add(T item){
        item.setHeapIndex(this.itemCount);
        this.items[this.itemCount] = item;
        this.SortUp(item);
        this.itemCount++;
    }

    void SortUp(T item){
        int parentIndex = (item.getHeapIndex() -1) / 2;

        while(true){
            T parentItem = items[parentIndex];

            if(item.compareTo(parentItem) > 0){
                Swap(item, parentItem);
            }else{
                break;
            }

            parentIndex = (int)((item.getHeapIndex() - 1) / 2);
        }
    }


    public boolean Contains(T item){
        return items[item.getHeapIndex()].equals(item);
    }

    void Swap(T itemA, T itemB){
        items[itemA.getHeapIndex()] = itemB;
        items[itemB.getHeapIndex()] = itemA;

        int itemAIndex = itemA.getHeapIndex();
        itemA.setHeapIndex(itemB.getHeapIndex());
        itemB.setHeapIndex(itemA.getHeapIndex());
    }
}
