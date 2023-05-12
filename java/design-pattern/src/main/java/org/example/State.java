package org.example;

/**
 * 状态模式
 */
public @interface State {
    /**
     * 抽象状态-电梯状态
     */
    abstract class LiftState {
        protected Context context;

        public abstract void open();

        public abstract void close();

        public abstract void run();

        public abstract void stop();
    }

    /**
     * 具体角色-电梯开门中
     */
    class OpeningState extends LiftState {
        @Override
        public void open() {
            System.out.println("OpeningState.open");
        }

        @Override
        public void close() {
            context.setState(Context.CLOSING);
            context.close();
        }

        @Override
        public void run() {

        }

        @Override
        public void stop() {

        }
    }

    /**
     * 具体角色-电梯关门中
     */
    class ClosingState extends LiftState {
        @Override
        public void open() {
            context.setState(Context.OPENING);
            context.open();
        }

        @Override
        public void close() {
            System.out.println("ClosingState.close");
        }

        @Override
        public void run() {
            context.setState(Context.RUNNING);
            context.run();
        }

        @Override
        public void stop() {
            context.setState(Context.STOPPING);
            context.stop();
        }
    }

    /**
     * 具体角色-电梯运行中
     */
    class RunningState extends LiftState {
        @Override
        public void open() {

        }

        @Override
        public void close() {

        }

        @Override
        public void run() {
            System.out.println("RunningState.run");
        }

        @Override
        public void stop() {
            context.setState(Context.STOPPING);
            context.stop();
        }
    }

    /**
     * 具体角色-电梯停止中
     */
    class StoppingState extends LiftState {
        @Override
        public void open() {
            context.setState(Context.OPENING);
            context.open();
        }

        @Override
        public void close() {
            context.setState(Context.CLOSING);
            context.close();
        }

        @Override
        public void run() {
            context.setState(Context.RUNNING);
            context.run();
        }

        @Override
        public void stop() {
            System.out.println("StoppingState.stop");
        }
    }

    /**
     * 环境角色
     */
    class Context {
        public static final LiftState OPENING = new OpeningState();
        public static final LiftState CLOSING = new ClosingState();
        public static final LiftState RUNNING = new RunningState();
        public static final LiftState STOPPING = new StoppingState();

        private LiftState state;

        public void setState(LiftState state) {
            this.state = state;
            this.state.context = this;
        }

        public void open() {
            state.open();
        }

        public void close() {
            state.close();
        }

        public void run() {
            state.run();
        }

        public void stop() {
            state.stop();
        }
    }
}
