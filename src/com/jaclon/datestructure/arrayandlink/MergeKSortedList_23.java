package com.jaclon.datestructure.arrayandlink;

import com.jaclon.datestructure.basic.ListNode;

import java.util.PriorityQueue;

/**
 * 自己想到的有两种解法： 归并（两两合并），
 * 参考 合并两个的方法，每次取个list的最小值。
 * 时间复杂度：考虑优先队列中的元素不超过 kk 个，那么插入和删除的时间代价为 O(logk)，这里最多有 kn个点，对于每个点都被插入删除各一次，故总的时间代价即渐进时间复杂度为 O(kn×logk)。
 * 空间复杂度：这里用了优先队列，优先队列中的元素不超过 k个，故渐进空间复杂度为 O(k)。
 *  ps: 空间复杂度也可以优化，不创建新的list，使用in-place
 * @author jaclon
 * @date 2020/7/30
 */
public class MergeKSortedList_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        PriorityQueue <ListNode> queue = new PriorityQueue <>((x, y) -> x.val - y.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            node = node.next;
            if(node != null){
                queue.offer(node);
            }
        }
        return dummy.next;
    }
}
