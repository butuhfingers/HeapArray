/**
 * Created by derek on 11/13/16.
 */
public interface IHeapItem<T> extends Comparable<T>{
    public int getHeapIndex();
    public void setHeapIndex(int set);
}