package org.example;

/**
 * 抽象工厂模式
 */
public @interface AbstractFactory {
    /**
     * 抽象产品-甜品
     */
    interface Dessert {
        String getName();
    }

    /**
     * 抽象工厂-甜品工厂
     */
    interface DessertFactory {
        Dessert getDessert();
    }

    /**
     * 具体产品-提拉米苏
     */
    class Tiramisu implements Dessert {
        @Override
        public String getName() {
            return "提拉米苏";
        }
    }

    /**
     * 具体产品-抹茶慕斯
     */
    class MochaMousse implements Dessert {
        @Override
        public String getName() {
            return "抹茶慕斯";
        }
    }

    /**
     * 具体工厂-提拉米苏工厂
     */
    class TiramisuFactory implements DessertFactory {
        @Override
        public Dessert getDessert() {
            return new Tiramisu();
        }
    }

    /**
     * 具体工厂-抹茶慕斯工厂
     */
    class MochaMousseFactory implements DessertFactory {
        @Override
        public Dessert getDessert() {
            return new MochaMousse();
        }
    }

    /**
     * 甜点工厂的工厂
     */
    class AbstractDessertFactory {
        public DessertFactory getFactory(String name) {
            switch (name) {
                case "Tiramisu":
                    return new TiramisuFactory();
                case "MochaMousse":
                    return new MochaMousseFactory();
                default:
                    return null;
            }
        }
    }
}
