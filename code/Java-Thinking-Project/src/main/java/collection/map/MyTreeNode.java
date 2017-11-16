package collection.map;

import java.util.Map;
import java.util.Objects;

final class MyTreeNode<K, V> extends MyEntry<K, V> {

    public static void main(String[] args) {
        System.out.println(hash("xxhaaaaaaaaaaaaaaaa"));
    }

    MyTreeNode<K, V> parent; // red-black tree links
    MyTreeNode<K, V> left;
    MyTreeNode<K, V> right;
    MyTreeNode<K, V> prev; // needed to unlink next upon deletion
    boolean red;

    MyTreeNode(int hash, K key, V val, MyNode<K, V> next) {
        super(hash, key, val, next);
    }

    /**
     * Returns root of tree containing this node.
     */
    final MyTreeNode<K, V> root() {
        for (MyTreeNode<K, V> r = this, p;;) {
            if ((p = r.parent) == null)
                return r;
            r = p;

        }
    }

    static final int hash(Object key) {
        int tmp = key.hashCode();
        System.out.println(tmp);
        System.out.println((tmp >>> 16));
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}

class MyEntry<K, V> extends MyNode<K, V> {
    MyEntry<K, V> before, after;

    MyEntry(int hash, K key, V value, MyNode<K, V> next) {
        super(hash, key, value, next);
    }
}

class MyNode<K, V> implements Map.Entry<K, V> {
    final int hash;
    final K key;
    V value;
    MyNode<K, V> next;

    MyNode(int hash, K key, V value, MyNode<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final String toString() {
        return key + "=" + value;
    }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}