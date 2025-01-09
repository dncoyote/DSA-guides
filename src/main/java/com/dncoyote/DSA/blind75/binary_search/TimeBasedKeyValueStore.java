package com.dncoyote.DSA.blind75.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    Map<String, List<Pair>> timeMap;

    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    TimeMap() {
        timeMap = new HashMap<>();
    }

    void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = timeMap.get(key);
        String result = "";
        int maxTimestamp = Integer.MIN_VALUE;

        for (Pair pair : pairs) {
            if (pair.timestamp <= timestamp && pair.timestamp > maxTimestamp) {
                result = pair.value;
                maxTimestamp = pair.timestamp;
            }
        }

        return result;
    }

    String getOptimal(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = timeMap.get(key);

        int low = 0;
        int high = pairs.size() - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (pairs.get(mid).timestamp <= timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0) {
            return "";
        }
        return pairs.get(high).value;
    }
}

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.getOptimal("foo", 1));
        System.out.println(obj.getOptimal("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.getOptimal("foo", 4));
        System.out.println(obj.getOptimal("foo", 5));
    }
}
