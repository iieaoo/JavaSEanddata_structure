package MapAndSet;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * ClassName: Test
 * Package: MapAndSet
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/29 23:55
 * Version 1.0
 */
class Student {
    private String id;

    public Student() {

    }

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {

    }
    //查找只出现一次的数
    public int singleNumber(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
            }else {
                set.remove(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])){
                return array[i];
            }
        }
        return -1;
    }
    //复制带随机指针的链表
    //百度
    /*public HashBuck.Node copeRandomList(HashBuck.Node head) {
        Map<HashBuck.Node, HashBuck.Node> map = new HashMap<>();
        HashBuck.Node cur = head;
        while (cur != null) {
            HashBuck.Node node = new HashBuck.Node(cur.value);
            map.put(cur,node);//老节点  新节点
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }*/
    //有10个数据，并且数据有重复的 去重
    public static void main8(String[] args) {
        int[] array = {1,2,2,3,4,5,6,8,4};
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            set.add(x);
        }
        System.out.println(set);
    }
    //有10个数据 并且数据有重复的 找到第一个重复的数据
    public static void main9(String[] args) {
        int[] array = {1,2,2,3,4,5,6,8,4};
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            if (!set.contains(x)) {
                set.add(x);
            }else {
                System.out.println(x);
                return;
            }
        }
    }
    //统计10w个数据当中 统计重复数据【val>=2】出现的次数？ k-v
    //遍历数据：x->map 有 +1 没有：val是1
    //遍历map 就可以了
    public static void main10 (String[] args) {
        int[] array = {1,2,2,3,4,5,6,8,4};
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : array) {
            if (map.get(x) == null) {//说明之前没有
                map.put(x,1);
            }else {
                int val = map.get(x);
                map.put(x,val+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Key: "+entry.getValue()+" val:"+entry.getValue());
            }
        }
    }
    public static void main7(String[] args) {
        Student student1 = new Student("1234");
        System.out.println(student1.hashCode());

        Student student2 = new Student("1234");
        System.out.println(student2.hashCode());

        HashBuck2<Student,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(student1,"lisa");
        String val = hashBuck2.get(student2);
        System.out.println(val);
    }
    public static void main6(String[] args) {
        Student student1 = new Student("1234");
        System.out.println(student1.hashCode());

        Student student2 = new Student("1234");
        System.out.println(student2.hashCode());
    }
    public static void mai5(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,11);
        hashBuck.put(2,22);
        hashBuck.put(5,55);
        hashBuck.put(8,88);
        hashBuck.put(3,33);
        hashBuck.put(14,144);
        hashBuck.put(6,66);
        hashBuck.put(7,77);
        Integer val = hashBuck.get(51);
        System.out.println(val);
    }
    public static void main4(String[] args) {
        Set<String> set1 = new TreeSet<>();
        set1.add("hello");
        set1.add("abc");
        //set1.add("hello");//重复了
        set1.add("the");
        System.out.println(set1);
    }
    public static void main3(String[] args) {
        Map<Student,Integer> treeMap = new TreeMap<>();
        //key 一定是可以比较的
        treeMap.put(new Student(),1);
        treeMap.put(new Student(),4);
        System.out.println(treeMap);//error
    }
    public static void main2(String[] args) {
        Map<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("hello",3);
        treeMap.put("abc",4);
        treeMap.put("the",8);
        treeMap.put("the",18);//value会更新
        //treeMap.put(null,12);//空指针异常
        System.out.println(treeMap);
        Integer val = treeMap.get("hello");
        System.out.println(val);
        Integer val2 = treeMap.getOrDefault("hello2",100);//默认值
        System.out.println(val2);
        Set<String> keyset = treeMap.keySet();
        System.out.println(keyset);
        Set<Map.Entry<String,Integer>> set = treeMap.entrySet();
        for (Map.Entry<String,Integer> entry : set) {
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
        }
    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(21);
        binarySearchTree.insert(5);
        binarySearchTree.insert(18);
        binarySearchTree.insert(9);
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        BinarySearchTree.TreeNode ret = binarySearchTree.find(10);
        System.out.println(ret.val);

        binarySearchTree.remove(10);
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
    }
}
