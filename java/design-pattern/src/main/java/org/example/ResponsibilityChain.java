package org.example;

/**
 * 责任链模式
 */
public @interface ResponsibilityChain {
    /**
     * 请假
     */
    class LeaveRequest {
        private final String name;
        private final int num;

        public LeaveRequest(String name, int num) {
            this.name = name;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public int getNum() {
            return num;
        }
    }

    /**
     * 抽象处理者-请假处理
     */
    abstract class Handler {
        protected static final int LEVEL_ONE = 1;
        protected static final int LEVEL_THREE = 3;
        protected static final int LEVEL_SEVEN = 7;

        private final int high;
        private final Handler next;

        public Handler(int high) {
            this(high, null);
        }

        public Handler(int high, Handler next) {
            this.high = high;
            this.next = next;
        }

        protected abstract void handlerLevel(LeaveRequest request);

        public final void handler(LeaveRequest request) {
            if (request.getNum() <= high) {
                handlerLevel(request);
            } else if (next != null) {
                next.handler(request);
            } else {
                System.out.printf("%s:请假失败%n", request.getName());
            }
        }
    }

    /**
     * 具体处理者-组长
     */
    class GroupLeader extends Handler {
        public GroupLeader(Handler handler) {
            super(LEVEL_ONE, handler);
        }

        @Override
        protected void handlerLevel(LeaveRequest request) {
            System.out.printf("%s:组长同意%n", request.getName());
        }
    }

    /**
     * 具体处理者-经理
     */
    class Manager extends Handler {
        public Manager(Handler handler) {
            super(LEVEL_THREE, handler);
        }

        @Override
        protected void handlerLevel(LeaveRequest request) {
            System.out.printf("%s:经理同意%n", request.getName());
        }
    }

    /**
     * 具体处理者-总经理
     */
    class GeneralManager extends Handler {
        public GeneralManager(Handler handler) {
            super(LEVEL_SEVEN, handler);
        }

        @Override
        protected void handlerLevel(LeaveRequest request) {
            System.out.printf("%s:总经理同意%n", request.getName());
        }
    }
}
