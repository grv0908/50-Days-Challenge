package com.grv.day02;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Gaurav Rajput
 * Created on 31/12/19
 */
public class MergeKSortedArrays {
    static class Pair {
        int data;
        int i;
        int j;

        Pair (int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }
    public int[] mergeKSortedArrays(int[][] arrays) {
        int[] res = new int[arrays.length * arrays[0].length];

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                return pair.data - t1.data;
            }
        });

        for (int i = 0; i < arrays.length; i++) {
            pq.add(new Pair(arrays[i][0], i, 0));
        }

        int index = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            res[index++] = p.data;
            if (p.j < arrays[p.i].length - 1) {
                pq.add(new Pair(arrays[p.i][p.j + 1], p.i, p.j + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{8,10,13,14},{5,7,8,10}, {20,30,40,50}};
        MergeKSortedArrays m = new MergeKSortedArrays();
        int res[] = m.mergeKSortedArrays(matrix);
        m.printArray(res);
    }

    public void printArray (int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
