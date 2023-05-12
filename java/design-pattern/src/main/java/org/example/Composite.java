package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 */
public @interface Composite {
    /**
     * 抽象根节点
     */
    abstract class MenuComponent {
        protected String name;
        protected int level;

        public MenuComponent(String name) {
            this.name = name;
        }

        public void add(MenuComponent component) {
            throw new RuntimeException("不支持该操作");
        }

        public MenuComponent get(int index) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(' ');
            }
            sb.append(name).append('\n');
            return sb.toString();
        }
    }

    /**
     * 树枝节点
     */
    class Menu extends MenuComponent {
        private final List<MenuComponent> components = new ArrayList<>();

        public Menu(String name) {
            super(name);
        }

        @Override
        public void add(MenuComponent component) {
            component.level = level + 1;
            components.add(component);
        }

        @Override
        public MenuComponent get(int index) {
            return components.get(index);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            for (MenuComponent component : components) {
                sb.append(component);
            }
            return sb.toString();
        }
    }

    /**
     * 叶子节点
     */
    class MenuItem extends MenuComponent {
        public MenuItem(String name) {
            super(name);
        }
    }
}
