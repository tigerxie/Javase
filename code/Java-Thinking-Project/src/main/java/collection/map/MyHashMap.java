package collection.map;

class MyHashMap {
    static int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        // System.out.println(Integer.toBinaryString(tableSizeFor(1)));
        // System.out.println(Integer.toBinaryString(tableSizeFor(666633334)));
        int hashValue = hash("xxh");
        System.out.println(hashValue);
    }

    private static final int tableSizeFor(int cap) {
        System.out.println(Integer.toBinaryString(cap));
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n >>> 1));
        System.out.println(Integer.toBinaryString(n >>> 2));
        System.out.println(Integer.toBinaryString(n >>> 4));
        System.out.println(Integer.toBinaryString(n >>> 8));
        System.out.println(Integer.toBinaryString(n >>> 16));
        System.out.println("===========");
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static final int hash(Object k) {
        int h = 0;
        System.out.println(k.hashCode());
        h ^= k.hashCode();
        System.out.println(h);
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        System.out.println(h);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
