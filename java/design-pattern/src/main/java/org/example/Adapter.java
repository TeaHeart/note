package org.example;

/**
 * 适配器模式
 */
public @interface Adapter {
    /**
     * 目标接口
     */
    interface TFCard {
        void writeTF(String data);
    }

    /**
     * 适配者类
     */
    interface SDCard {
        void writeSD(String data);
    }

    /**
     * 目标实现
     */
    class TFCardImpl implements TFCard {
        @Override
        public void writeTF(String data) {
            System.out.printf("TFCardImpl.writeTF:%s%n", data);
        }
    }

    /**
     * 适配者实现
     */
    class SDCardImpl implements SDCard {
        @Override
        public void writeSD(String data) {
            System.out.printf("SDCardImpl.writeSD:%s%n", data);
        }
    }

    /**
     * 计算机
     */
    class Computer {
        public void write(SDCard card) {
            card.writeSD(card.toString());
        }
    }

    /**
     * 适配器-类适配器
     */
    class ClassAdapter extends TFCardImpl implements SDCard {
        @Override
        public void writeSD(String data) {
            writeTF(data);
        }
    }

    /**
     * 适配器-对象适配器
     */
    class ObjectAdapter implements SDCard {
        private TFCard card;

        public ObjectAdapter(TFCard card) {
            this.card = card;
        }

        public void setCard(TFCard card) {
            this.card = card;
        }

        @Override
        public void writeSD(String data) {
            card.writeTF(data);
        }
    }
}
