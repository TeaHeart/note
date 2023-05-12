package org.example;

/**
 * 模板模式
 */
public @interface Template {
    /**
     * 模板类-烹饪
     */
    abstract class AbstractCook {
        /**
         * 模板方法
         */
        public final void cookProcess() {
            pourOil();
            heatOil();
            pourVegetable();
            pourSauce();
            pourSugar();
            fry();
        }

        /**
         * 具体方法
         */
        public void pourOil() {
            System.out.println("倒油");
        }

        /**
         * 具体方法
         */
        public void heatOil() {
            System.out.println("热油");
        }

        /**
         * 具体方法
         */
        public void pourSugar() {
            if (isPourSugar()) {
                System.out.println("加糖");
            }
        }

        /**
         * 钩子方法
         */
        public boolean isPourSugar() {
            return true;
        }

        /**
         * 抽象方法
         */
        public abstract void pourVegetable();

        /**
         * 抽象方法
         */
        public abstract void pourSauce();

        /**
         * 具体方法
         */
        public void fry() {
            System.out.println("翻炒");
        }
    }

    /**
     * 具体子类-爆炒包菜
     */
    class CookCabbage extends AbstractCook {
        @Override
        public void pourVegetable() {
            System.out.println("包菜");
        }

        @Override
        public void pourSauce() {
            System.out.println("辣椒");
        }
    }

    /**
     * 具体子类-蒜蓉菜心
     */
    class CookFloweringCabbage extends AbstractCook {
        @Override
        public void pourVegetable() {
            System.out.println("菜心");
        }

        @Override
        public void pourSauce() {
            System.out.println("蒜蓉");
        }

        @Override
        public boolean isPourSugar() {
            return false;
        }
    }
}
