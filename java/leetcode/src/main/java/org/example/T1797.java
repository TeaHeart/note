package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1797 {
    class AuthenticationManager {
        int timeToLive;

        Map<String, Integer> map = new HashMap<>();

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            Integer expirationTime = map.get(tokenId);
            if (expirationTime == null) {
                return;
            }
            if (currentTime < expirationTime) {
                map.put(tokenId, currentTime + timeToLive);
            } else {
                map.remove(tokenId);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (Integer expirationTime : map.values()) {
                if (currentTime < expirationTime) {
                    count++;
                }
            }
            return count;
        }
    }
}
