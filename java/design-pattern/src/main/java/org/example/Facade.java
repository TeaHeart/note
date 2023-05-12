package org.example;

/**
 * 外观模式
 */
public @interface Facade {
    /**
     * 子系统类-电灯
     */
    class Light {
        public void on() {
            System.out.println("Light.on");
        }

        public void off() {
            System.out.println("Light.off");
        }
    }

    /**
     * 子系统类-电视
     */
    class TV {
        public void on() {
            System.out.println("TV.on");
        }

        public void off() {
            System.out.println("TV.off");
        }
    }

    /**
     * 子系统类-空调
     */
    class AirConditioner {
        public void on() {
            System.out.println("AirConditioner.on");
        }

        public void off() {
            System.out.println("AirConditioner.off");
        }
    }

    /**
     * 统一接口类-智能终端
     */
    class IntelligentTerminal {
        private final Light light = new Light();
        private final TV tv = new TV();
        private final AirConditioner airConditioner = new AirConditioner();

        public void listen(String msg) {
            if (msg.contains("打开")) {
                openAll();
            } else if (msg.contains("关闭")) {
                closeAll();
            } else {
                System.out.println("未知的命令");
            }
        }

        private void openAll() {
            light.on();
            tv.on();
            airConditioner.on();
        }

        private void closeAll() {
            light.off();
            tv.off();
            airConditioner.off();
        }
    }
}
