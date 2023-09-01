package MapAndSet;

/**
 * ClassName: HashBuck2
 * Package: MapAndSet
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/30 21:19
 * Version 1.0
 */
public class HashBuck2<K,V> {
    static class Node<K,V> {
        public K key;
        public V value;
        public Node<K,V> next;
        public Node(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node<K,V>[] array = (Node<K, V>[])new Node[10];
    public int usedSize;

    public void put(K key,V value) {
        int hash = key.hashCode();//重写
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {//重写
                cur.value = value;
                return;
            }
            cur = cur.next;
            //头插
            Node<K,V> node = new Node<>(key, value);
            node.next = array[index];
            array[index] = node;
            usedSize++;
        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

}
