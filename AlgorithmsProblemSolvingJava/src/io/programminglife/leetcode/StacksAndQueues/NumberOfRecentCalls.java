package io.programminglife.leetcode.StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    Queue<Integer> calls;

    public NumberOfRecentCalls() {
        calls = new LinkedList<>();
    }
    
    public int ping(int t) {
        calls.add(t);

        while(calls.peek() < t - 3000) {
            calls.poll();
        }

        return calls.size();
    }
    
}
