package org.example;

/**
 * 策略模式
 */
public @interface Strategy {
    /**
     * 抽象策略类-销售策略
     */
    interface MarketingStrategy {
        void show();
    }

    /**
     * 具体策略类-销售策略A
     */
    class MarketingStrategyA implements MarketingStrategy {
        @Override
        public void show() {
            System.out.println("买一送一");
        }
    }

    /**
     * 具体策略类-销售策略B
     */
    class MarketingStrategyB implements MarketingStrategy {
        @Override
        public void show() {
            System.out.println("满200减50");
        }
    }

    /**
     * 具体策略类-销售策略C
     */
    class MarketingStrategyC implements MarketingStrategy {
        @Override
        public void show() {
            System.out.println("满300减100");
        }
    }

    /**
     * 环境类
     */
    class SaleMan {
        private MarketingStrategy strategy;

        public MarketingStrategy getStrategy() {
            return strategy;
        }

        public void setStrategy(MarketingStrategy strategy) {
            this.strategy = strategy;
        }

        public void sealManShow() {
            strategy.show();
        }
    }
}
