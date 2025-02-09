package com.dncoyote.DSA.blind75.heaps_priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> following; // userId -> Set of followees
    private Map<Integer, List<Tweet>> tweets; // userId -> List of Tweets

    static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new LinkedList<>());
        tweets.get(userId).add(0, new Tweet(tweetId, timestamp++));
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId != followerId) {
            following.putIfAbsent(followerId, new HashSet<>());
            following.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(Comparator.comparingInt(t -> t.time));
        Set<Integer> followees = following.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                for (Tweet tweet : tweets.get(followeeId)) {
                    if (minHeap.size() < 10) {
                        minHeap.add(tweet);
                    } else if (tweet.time > minHeap.peek().time) {
                        minHeap.poll();
                        minHeap.add(tweet);
                    } else {
                        break;
                    }
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            feed.add(0, minHeap.poll().id);
        }
        return feed;
    }
}

public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts tweet with id 5
        twitter.getNewsFeed(1); // Returns [5]
        twitter.follow(1, 2); // User 1 follows user 2
        twitter.postTweet(2, 6); // User 2 posts tweet with id 6
        twitter.getNewsFeed(1); // Returns [6, 5]
        twitter.unfollow(1, 2); // User 1 unfollows user 2
        twitter.getNewsFeed(1); // Returns [5]
    }
}
