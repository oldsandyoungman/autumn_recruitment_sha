package com.shasha.origin;

import org.junit.Test;

import java.util.*;

/** 要时刻保持两个堆顶元素是不被删除的，因此有几个地方要prune一下：
 * 1. 插入时，新加的元素不管最后在堆中还是堆顶，堆顶元素肯定不可能是要被删除的那个
 *      如果新加元素在堆顶，那么新加的数肯定不是要删的数（如果是重复的，那也会之前就删了）
 *      如果新加元素在堆中，那么堆顶的数在上一轮就是不被删除的数（也能保证）
 * 2. 插入后，两边可能不平衡，因此要动态调整将堆A的数插入到堆B，那么A需要动态调整
 *      因为在调整前，已经能保证堆A的堆顶和堆B的堆顶都是不被删除的数，所以堆B无论最终堆顶是自身，还是原堆A的数，都不用删除
 *      但是堆A新的堆顶，可能涉及到删除，所以要prune一下
 * 3. 删除某个元素，如果正好是某个堆的堆顶值，那么自己删除堆顶值后，新暴露的堆顶值可能要再考虑下
 *
 * 另外，真正的删除prune里并不需要改变small_size 和 big_size，因为我们已经在erase里修正过了
 *      （这里的small_size 和 big_size 是理想中的堆大小，而并非真正的堆大小）
 *
 * @author ShaLuwei
 * @create 2022-09-06 08:06
 */
public class leetcode_0480 {

    @Test
    public void test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, 3)));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap();
//        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; ++i) {
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }
}

//class DualHeap {
//    // 大根堆，维护较小的一半元素
//    private PriorityQueue<Integer> small;
//    // 小根堆，维护较大的一半元素
//    private PriorityQueue<Integer> large;
//    // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
//    private Map<Integer, Integer> delayed;
//
//    private int k;
//    // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
//    private int smallSize, largeSize;
//
//    public DualHeap(int k) {
//        this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer num1, Integer num2) {
//                return num2.compareTo(num1);
//            }
//        });
//        this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer num1, Integer num2) {
//                return num1.compareTo(num2);
//            }
//        });
//        this.delayed = new HashMap<Integer, Integer>();
//        this.k = k;
//        this.smallSize = 0;
//        this.largeSize = 0;
//    }
//
//    public double getMedian() {
//        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
//    }
//
//    public void insert(int num) {
//        if (small.isEmpty() || num <= small.peek()) {
//            small.offer(num);
//            ++smallSize;
//        } else {
//            large.offer(num);
//            ++largeSize;
//        }
//        makeBalance();
//    }
//
//    public void erase(int num) {
//        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
//        if (num <= small.peek()) {
//            --smallSize;
//            if (num == small.peek()) {
//                prune(small);
//            }
//        } else {
//            --largeSize;
//            if (num == large.peek()) {
//                prune(large);
//            }
//        }
//        makeBalance();
//    }
//
//    // 不断地弹出 heap 的堆顶元素，并且更新哈希表
//    private void prune(PriorityQueue<Integer> heap) {
//        while (!heap.isEmpty()) {
//            int num = heap.peek();
//            if (delayed.containsKey(num)) {
//                delayed.put(num, delayed.get(num) - 1);
//                if (delayed.get(num) == 0) {
//                    delayed.remove(num);
//                }
//                heap.poll();
//            } else {
//                break;
//            }
//        }
//    }
//
//    // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
//    private void makeBalance() {
//        if (smallSize > largeSize + 1) {
//            // small 比 large 元素多 2 个
//            large.offer(small.poll());
//            --smallSize;
//            ++largeSize;
//            // small 堆顶元素被移除，需要进行 prune
//            prune(small);
//        } else if (smallSize < largeSize) {
//            // large 比 small 元素多 1 个
//            small.offer(large.poll());
//            ++smallSize;
//            --largeSize;
//            // large 堆顶元素被移除，需要进行 prune
//            prune(large);
//        }
//    }
//}

class DualHeap{

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    int small_size;
    int big_size;
    HashMap<Integer, Integer> delete;

    public DualHeap(){
        small = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o2, o1);
        });
        big = new PriorityQueue<>();
        delete = new HashMap<>();
        small_size = 0;
        big_size = 0;
    }

    public double getMedian(){
        if(small_size>big_size){
            return (small.peek()+big.peek())/2.0;
        }
        return small.peek();
    }

    public void insert(int num){
        if(small.isEmpty() || small.peek()>=num){
            small.offer(num);
            small_size++;
        }else{
            big.offer(num);
            big_size++;
        }
        balance();
    }

    public void erase(int num){
        delete.put(num, delete.getOrDefault(num, 0)+1);
        if(small.peek()>=num){
            if(num==small.peek()){
                prune(small);
            }
            small_size--;
        }else{
            if(num==big.peek()){
                prune(big);
            }
            big_size--;
        }
        balance();
    }

    public void balance(){
        if(small_size>big_size+1){
            big.offer(small.poll());
            big_size++;
            small_size--;
            prune(small);
        }else if(big_size>small_size){
            small.offer(big.poll());
            big_size--;
            small_size++;
            prune(big);
        }

    }

    public void prune(PriorityQueue<Integer> q){
        while(!q.isEmpty()){
            int num = q.peek();
            if(delete.containsKey(num)){
                int new_val = delete.get(num)-1;
                delete.put(num, new_val);
                if(new_val==0){
                    delete.remove(num);
                }
                q.poll();
            }else{
                break;
            }
        }
    }


}