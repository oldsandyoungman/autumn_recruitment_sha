package com.shasha.struct;

/**
 * @author ShaLuwei
 * @create 2022-08-16 10:38
 */
public class MaxPQ <Key extends Comparable<Key>>{

    private Key[] pq;
    int sz;

    public MaxPQ(int cap){
        pq = (Key[]) new Comparable[cap+1];
        sz = 0;
    }

    private void swim(int i){

        while(i>1 && less(parent(i), i)){
            swap(parent(i), i);
            i = parent(i);
        }

    }

    private void sink(int i){

        while (left(i)<=sz){
            int max = left(i);
            if(right(i)<=sz && less(left(i), right(i))){
                max = right(i);
            }
            if(less(max, i)){
                break;
            }
            swap(i, max);
            i = max;
        }

    }

    public void add(Key val){
        if(sz>=pq.length-1){
            return;
        }
        sz++;
        pq[sz] = val;
        swim(sz);
    }

    public Key poll(){
        if(sz==0){
            return null;
        }
        Key val = pq[1];
        pq[1] = pq[sz];
        pq[sz] = null;
        sz--;
        sink(1);
        return val;
    }


    private int parent(int i){
        return i/2;
    }

    private int left(int i){
        return 2*i;
    }

    private int right(int i){
        return 2*i+1;
    }





    private void swap(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }


}
