package MapAndSet;

import java.util.*;

/**
 * ClassName: ZuoYe
 * Package: MapAndSet
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/6/1 1:22
 * Version 1.0
 */
public class ZuoYe {
    public static List<String> topKFrequent(String[] words, int k) {
        //1、遍历数组 统计每个单词出现出现
        Map<String,Integer> hashMap = new HashMap<>();
        for (String s : words) {
            if (hashMap.get(s) == null) {
                hashMap.put(s,1);
            }else {
                hashMap.put(s,hashMap.get(s)+1);
            }
        }
        //2、建立小根堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        }
        );
        //3、遍历hashMap 把里边的数据 放到小根堆
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }else {
                //小根堆放满了K个 下一个entry和堆顶元素比较
                Map.Entry<String,Integer> top = minHeap.peek();
                //堆顶的频率小于当前entry的频率 就出队 然后入entry
                if (top.getValue().compareTo(entry.getValue()) < 0) {
                    minHeap.poll();
                    minHeap.add(entry);
                }else {
                    //频率相同  比较Key
                    if (top.getValue().compareTo(entry.getValue()) == 0) {
                        if (top.getKey().compareTo(entry.getKey()) > 0) {
                            minHeap.poll();
                            minHeap.add(entry);
                        }
                    }
                }
            }
        }
        //4、此时 小根堆当中已经 有了结果
       // System.out.println(minHeap);
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String key = minHeap.poll().getKey();
            ret.add(key);
        }
        Collections.reverse(ret);
        //System.out.println("ret: "+ret);
        return ret;
    }

    public static void main1(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 3));
    }

    public static int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 && i > res) {
                res = i + 1;
            }
            if (map.containsKey(sum)) {
                res = Math.max(i - map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,0,1,0,1,1};
        findMaxLength(arr);
        System.out.println("======");
    }

}
