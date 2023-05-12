package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public @interface Observer {
    /**
     * 抽象观察者-视频观察者
     */
    interface VideoObserver {
        void update(String msg);
    }

    /**
     * 抽象主题-视频
     */
    interface Video {
        void attach(VideoObserver observer);

        void detach(VideoObserver observer);

        void notify(String msg);
    }

    /**
     * 具体观察者-用户
     */
    class User implements VideoObserver {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public void update(String msg) {
            System.out.printf("%s<-%s\n", name, msg);
        }
    }

    /**
     * 具体主题-订阅视频
     */
    class SubscriptionVideo implements Video {
        private final List<VideoObserver> observers = new ArrayList<>();

        @Override
        public void attach(VideoObserver observer) {
            observers.add(observer);
        }

        @Override
        public void detach(VideoObserver observer) {
            observers.remove(observer);
        }

        @Override
        public void notify(String msg) {
            for (VideoObserver observer : observers) {
                observer.update(msg);
            }
        }
    }
}
