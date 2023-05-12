package org.example;

/**
 * 备忘录模式
 */
public @interface Memento {
    /**
     * 备忘录接口-对外提供窄接口
     */
    interface RoleBMemento {

    }

    /**
     * 发起人-角色A
     */
    class GameRoleA {
        private int hp;
        private int atk;
        private int def;

        public GameRoleA(int hp, int atk, int def) {
            this.hp = hp;
            this.atk = atk;
            this.def = def;
        }

        public void fight() {
            hp = 0;
            atk = 0;
            def = 0;
        }

        public RoleStateMementoA save() {
            return new RoleStateMementoA(hp, atk, def);
        }

        public void load(RoleStateMementoA memento) {
            hp = memento.getHp();
            atk = memento.getAtk();
            def = memento.getDef();
        }

        @Override
        public String toString() {
            return String.format("GameRoleA{hp=%d, atk=%d, def=%d}", hp, atk, def);
        }
    }

    /**
     * 备忘录-角色A状态备忘录
     */
    class RoleStateMementoA {
        private final int hp;
        private final int atk;
        private final int def;

        public RoleStateMementoA(int hp, int atk, int def) {
            this.hp = hp;
            this.atk = atk;
            this.def = def;
        }

        public int getHp() {
            return hp;
        }

        public int getAtk() {
            return atk;
        }

        public int getDef() {
            return def;
        }
    }

    /**
     * 备忘录管理-角色A状态备忘录管理
     */
    class RoleStateCaretakerA {
        private RoleStateMementoA memento;

        public RoleStateMementoA getMemento() {
            return memento;
        }

        public void setMemento(RoleStateMementoA memento) {
            this.memento = memento;
        }
    }

    /**
     * 发起人-角色B
     */
    class GameRoleB {
        private int hp;
        private int atk;
        private int def;

        public GameRoleB(int hp, int atk, int def) {
            this.hp = hp;
            this.atk = atk;
            this.def = def;
        }

        public void fight() {
            hp = 0;
            atk = 0;
            def = 0;
        }

        public RoleBMemento save() {
            return new RoleStateMementoB(hp, atk, def);
        }

        public void load(RoleBMemento memento) {
            RoleStateMementoB stateMemento = (RoleStateMementoB) memento;
            hp = stateMemento.getHp();
            atk = stateMemento.getAtk();
            def = stateMemento.getDef();
        }

        @Override
        public String toString() {
            return String.format("GameRoleB{hp=%d, atk=%d, def=%d}", hp, atk, def);
        }

        /**
         * 备忘录-角色B状态备忘录
         */
        private static class RoleStateMementoB implements RoleBMemento {
            private final int hp;
            private final int atk;
            private final int def;

            public RoleStateMementoB(int hp, int atk, int def) {
                this.hp = hp;
                this.atk = atk;
                this.def = def;
            }

            public int getHp() {
                return hp;
            }

            public int getAtk() {
                return atk;
            }

            public int getDef() {
                return def;
            }
        }
    }

    /**
     * 备忘录管理-角色B状态备忘录管理
     */
    class RoleStateCaretakerB {
        private RoleBMemento memento;

        public RoleBMemento getMemento() {
            return memento;
        }

        public void setMemento(RoleBMemento memento) {
            this.memento = memento;
        }
    }
}
