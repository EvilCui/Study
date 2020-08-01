package Iterator;

public interface Aggregate {
    void add(Object object);
    void remove(Object object);
    newIterator getIterator();
}
