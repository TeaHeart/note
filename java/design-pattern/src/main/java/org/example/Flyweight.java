package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public @interface Flyweight {
    /**
     * 抽象享元角色-抽象方格
     */
    interface AbstractBox {
        String getShape();

        default void show(String color) {
            System.out.printf("%s:%s%n", color, getShape());
        }
    }

    /**
     * 具体享元-I方格
     */
    class IBox implements AbstractBox {
        @Override
        public String getShape() {
            return "I";
        }
    }

    /**
     * 具体享元-L方格
     */
    class LBox implements AbstractBox {
        @Override
        public String getShape() {
            return "L";
        }
    }

    /**
     * 具体享元-O方格
     */
    class OBox implements AbstractBox {
        @Override
        public String getShape() {
            return "O";
        }
    }

    /**
     * 享元工厂
     */
    final class BoxFactory {
        private static final BoxFactory INSTANCE = new BoxFactory();
        private final Map<String, AbstractBox> map = new HashMap<>();

        private BoxFactory() {
            IBox i = new IBox();
            LBox l = new LBox();
            OBox o = new OBox();
            map.put(i.getShape(), i);
            map.put(l.getShape(), l);
            map.put(o.getShape(), o);
        }

        public static BoxFactory getInstance() {
            return INSTANCE;
        }

        public AbstractBox getBox(String shape) {
            return map.get(shape);
        }
    }
}
