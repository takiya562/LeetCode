package com.takiya.LeetCode;

import java.util.*;

class TweetCounts {
    Map<String, List<Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> list = map.getOrDefault(tweetName, new ArrayList<>());
        int index = bisect_left(list, time);
        list.add(index, time);
        map.put(tweetName, list);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = getDelta(freq);
        List<Integer> list = map.getOrDefault(tweetName, null);
        List<Integer> ans = new LinkedList<>();
        if (list == null)   return ans;
        System.out.println(delta);
        for (int start = startTime; start <= endTime; start = start + delta) {
            int end = (start + delta) <= endTime ? (start + delta) : (endTime + 1);
            int left = bisect_left(list, start);
            int right = bisect_left(list, end);
            ans.add(right - left);
        }
        return ans;
    }

    private int bisect_left(List<Integer> list, int key) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);

            if (midVal >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int getDelta(String freq) {
        if (freq.equals("minute"))
            return 60;
        else if (freq.equals("hour"))
            return 3600;
        else
            return 86400;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
