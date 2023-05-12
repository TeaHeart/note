package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器模式
 */
public @interface Interpreter {
    /**
     * 抽象表达式
     */
    interface Expression {
        int interpret(Context context);
    }

    /**
     * 终结符表达式-变量
     */
    class Variable implements Expression {
        private final String name;

        public Variable(String name) {
            this.name = name;
        }

        @Override
        public int interpret(Context context) {
            return context.get(this);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * 非终结表达式-加法
     */
    class Plus implements Expression {
        private final Expression left;
        private final Expression right;

        public Plus(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret(Context context) {
            return left.interpret(context) + right.interpret(context);
        }

        @Override
        public String toString() {
            return "(" + left + "+" + right + ")";
        }
    }

    /**
     * 非终结表达式-减法
     */
    class Minus implements Expression {
        private final Expression left;
        private final Expression right;

        public Minus(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret(Context context) {
            return left.interpret(context) - right.interpret(context);
        }

        @Override
        public String toString() {
            return "(" + left + "-" + right + ")";
        }
    }

    /**
     * 环境-上下文
     */
    class Context {
        private final Map<Variable, Integer> map = new HashMap<>();

        public void put(Variable var, int value) {
            map.put(var, value);
        }

        public int get(Variable var) {
            return map.get(var);
        }
    }
}
