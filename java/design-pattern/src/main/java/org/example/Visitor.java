package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 */
public @interface Visitor {
    /**
     * 抽象访问者-喂食访问者
     */
    interface FeedVisitor {
        void feed(Cat cat);

        void feed(Dog dog);
    }

    /**
     * 抽象元素角色-动物
     */
    interface Animal {
        void accept(FeedVisitor master);
    }

    /**
     * 具体元素角色-猫
     */
    class Cat implements Animal {
        @Override
        public void accept(FeedVisitor visitor) {
            visitor.feed(this);
        }
    }

    /**
     * 具体元素角色-狗
     */
    class Dog implements Animal {
        @Override
        public void accept(FeedVisitor visitor) {
            visitor.feed(this);
        }
    }

    /**
     * 具体访问者-主人
     */
    class Owner implements FeedVisitor {
        @Override
        public void feed(Cat cat) {
            System.out.println("Owner.feed");
        }

        @Override
        public void feed(Dog dog) {
            System.out.println("Owner.feed");
        }
    }

    /**
     * 具体访问者-其他人
     */
    class Other implements FeedVisitor {
        @Override
        public void feed(Cat cat) {
            System.out.println("Other.feed");
        }

        @Override
        public void feed(Dog dog) {
            System.out.println("Other.feed");
        }
    }

    /**
     * 房间
     */
    class Home {
        private final List<Animal> animals = new ArrayList<>();

        public Home add(Animal animal) {
            animals.add(animal);
            return this;
        }

        public void action(FeedVisitor visitor) {
            for (Animal animal : animals) {
                animal.accept(visitor);
            }
        }
    }
}
