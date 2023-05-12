package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 命令模式
 */
public @interface Command {
    /**
     * 抽象命令
     */
    interface Cmd {
        void exec();
    }

    /**
     * 订单
     */
    class Order {
        private final int id;
        private final Map<String, Integer> foods = new HashMap<>();

        public Order(int id) {
            this.id = id;
        }

        public Order addFood(String name, int num) {
            foods.put(name, num);
            return this;
        }
    }

    /**
     * 接收者-厨师
     */
    class Chef {
        public void makeFood(String name, int num) {
            System.out.printf("%s:%d个\n", name, num);
        }
    }

    /**
     * 具体命令-订单命令
     */
    class OrderCmd implements Cmd {
        private final Chef receiver;
        private final Order order;

        public OrderCmd(Chef receiver, Order order) {
            this.receiver = receiver;
            this.order = order;
        }

        @Override
        public void exec() {
            System.out.printf("开始订单:%d\n", order.id);
            for (Map.Entry<String, Integer> entry : order.foods.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                receiver.makeFood(key, value);
            }
            System.out.printf("完成订单:%d\n", order.id);
        }
    }

    /**
     * 请求者-服务员
     */
    class Waiter {
        private final List<Cmd> cmds = new ArrayList<>();

        public Waiter addCommand(Cmd cmd) {
            cmds.add(cmd);
            return this;
        }

        public void orderUp() {
            for (Cmd cmd : cmds) {
                cmd.exec();
            }
        }
    }
}
