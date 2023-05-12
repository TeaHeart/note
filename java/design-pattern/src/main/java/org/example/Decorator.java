package org.example;

/**
 * 装饰器模式
 */
public @interface Decorator {
    /**
     * 抽象组件-快餐
     */
    abstract class FastFood {
        protected final double cost;
        protected final String desc;

        public FastFood(double cost, String desc) {
            this.cost = cost;
            this.desc = desc;
        }

        public double getCost() {
            return cost;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return getDesc() + "=" + getCost();
        }
    }

    /**
     * 具体组件-炒饭
     */
    class FriedRice extends FastFood {
        public FriedRice() {
            super(10, "炒饭");
        }
    }

    /**
     * 具体组件-炒面
     */
    class FiredNoodles extends FastFood {
        public FiredNoodles() {
            super(12, "炒面");
        }
    }

    /**
     * 抽象装饰-配料
     */
    abstract class SideDish extends FastFood {
        private final FastFood food;

        public SideDish(FastFood food, double price, String desc) {
            super(price, desc);
            this.food = food;
        }

        @Override
        public double getCost() {
            return cost + food.getCost();
        }

        @Override
        public String getDesc() {
            return desc + "+" + food.getDesc();
        }
    }

    /**
     * 具体装饰-鸡蛋
     */
    class Egg extends SideDish {
        public Egg(FastFood food) {
            super(food, 1, "鸡蛋");
        }
    }

    /**
     * 具体装饰-培根
     */
    class Bacon extends SideDish {
        public Bacon(FastFood food) {
            super(food, 2, "培根");
        }
    }
}
