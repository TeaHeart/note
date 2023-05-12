package org.example;

/**
 * 桥接模式
 */
public @interface Bridge {
    /**
     * 实现化角色-视频文件
     */
    interface VideoFile {
        void decode(String filename);
    }

    /**
     * 具体实现化角色-AVI
     */
    class AVI implements VideoFile {
        @Override
        public void decode(String filename) {
            System.out.printf("AVI.decode:%s%n", filename);
        }
    }

    /**
     * 具体实现化角色-RMVB
     */
    class RMVB implements VideoFile {
        @Override
        public void decode(String filename) {
            System.out.printf("RMVB.decode:%s%n", filename);
        }
    }

    /**
     * 抽象化角色-操作系统
     */
    abstract class OperatingSystem {
        protected VideoFile file;

        public OperatingSystem(VideoFile file) {
            this.file = file;
        }

        public void setFile(VideoFile file) {
            this.file = file;
        }

        public abstract void play(String filename);
    }

    /**
     * 扩展抽象化角色-Windows
     */
    class Windows extends OperatingSystem {
        public Windows(VideoFile file) {
            super(file);
        }

        @Override
        public void play(String filename) {
            System.out.println("Windows.play");
            file.decode(filename);
        }
    }

    /**
     * 扩展抽象化角色-Mac
     */
    class Mac extends OperatingSystem {
        public Mac(VideoFile file) {
            super(file);
        }

        @Override
        public void play(String filename) {
            System.out.println("Mac.play");
            file.decode(filename);
        }
    }
}
