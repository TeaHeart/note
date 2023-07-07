package org.example;

import java.util.*;

public class T355 {
    class Twitter {
        Map<Integer, Set<Integer>> follows = new HashMap<>();
        Deque<int[]> tweets = new ArrayDeque<>();

        public void postTweet(int userId, int tweetId) {
            tweets.push(new int[]{userId, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> follow = follows.getOrDefault(userId, Collections.singleton(userId));
            List<Integer> list = new ArrayList<>();
            for (int[] tweet : tweets) {
                if (list.size() == 10) {
                    break;
                }
                if (follow.contains(tweet[0])) {
                    list.add(tweet[1]);
                }
            }
            return list;
        }

        public void follow(int followerId, int followeeId) {
            follows.computeIfAbsent(followerId, k -> new HashSet<>(Collections.singleton(followerId))).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            follows.computeIfAbsent(followerId, k -> new HashSet<>(Collections.singleton(followerId))).remove(followeeId);
        }
    }
}
