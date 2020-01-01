package com.grv.day02;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Gaurav Rajput
 * Created on 01/01/20
 */
public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {this.val = val;}
    }

    static class Pair {
        ListNode node;
        int index;

        Pair (ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                return pair.node.val - t1.node.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.add (new Pair(lists[i], i));
            }
        }

        ListNode head = null;
        ListNode iter = null;
        while (!pq.isEmpty()) {
            Pair p = pq.remove();

            if (head == null) {
                head = p.node;
                iter = p.node;
            } else {
                iter.next = p.node;
                iter = iter.next;
            }

            lists[p.index] = lists[p.index].next;
            if (lists[p.index] != null) {
                pq.add(new Pair(lists[p.index], p.index));
            }
        }

        return head;
    }
}
