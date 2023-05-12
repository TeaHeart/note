package org.example;

import java.io.*;

/**
 * 原型模式
 */
public @interface Prototype {
    /**
     * 具体原型-老师
     */
    class Teacher implements Cloneable {
        private String name;

        public Teacher(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Teacher{name='%s'}", name);
        }

        @Override
        public Teacher clone() {
            try {
                Teacher clone = (Teacher) super.clone();
                clone.name = name;
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 具体原型-学生
     */
    class Student implements Serializable {
        private final String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Student{name='%s'}", name);
        }

        public Student serializeClone() {
            try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
                try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                    oos.writeObject(this);
                    try (ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray())) {
                        try (ObjectInputStream ois = new ObjectInputStream(is)) {
                            return (Student) ois.readObject();
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
