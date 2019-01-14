package hashtable;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Hashtable<T1, T2> {
    private LinkedList<String>[] buckets;

    public Hashtable (int size) {
        this.buckets = new LinkedList[size];
    }

    private int getHash(T1 key) {
       int hashValue = 0;
       String keyToHash = key.toString();
       for (int i = 0; i < keyToHash.length(); i++) {
           hashValue += keyToHash.codePointAt(i);
       }
       hashValue = hashValue * 167 % this.buckets.length;
       return hashValue;
    }

    public void add(T1 key, T2 value) {
        int idx = getHash(key);
        buckets[idx].add(key + ": " + value);
    }

    public boolean contains(T1 key) {
        int idx = getHash(key);
        if (buckets[idx].peek() == null) {
            return false;
        } else {
            return true;
        }
    }

    public T2 find(T1 key) throws NoSuchElementException {
        int idx= getHash(key);
        if (buckets[idx].peek() == null) {
            throw new NoSuchElementException("No such value found for the key" + key);
        }
        for (int i = 0; i < buckets[idx].size(); i++) {
            String current = buckets[idx].get(i);
            if (current.contains(key.toString())) {
                return (T2) current.split(": ")[1];
            }
        }
        return (T2) buckets[idx].peek().split(": ")[1];
    }

    public int size() {
        return buckets.length;
    }
}
