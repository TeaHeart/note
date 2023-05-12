package org.example;

/**
 * 迭代器模式
 */
public @interface Iterator {
    /**
     * 抽象迭代器-学生迭代器
     */
    interface StudentIterator {
        boolean hasNext();

        Student next();
    }

    /**
     * 抽象聚合角色-学生汇总
     */
    interface StudentAggregate {
        void add(Student student);

        StudentIterator iterator();
    }

    /**
     * 学生
     */
    class Student {
        private final int id;
        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Student{id=%d, name='%s'}", id, name);
        }
    }

    /**
     * 具体迭代器-学生迭代器
     */
    class StudentIteratorImpl implements StudentIterator {
        private final Student[] students;
        private final int fence;
        private int cursor = 0;

        public StudentIteratorImpl(Student[] students, int size) {
            this.students = students;
            fence = size;
        }

        @Override
        public boolean hasNext() {
            return cursor != fence;
        }

        @Override
        public Student next() {
            return students[cursor++];
        }
    }

    /**
     * 具体聚合角色-学生汇总
     */
    class StudentAggregateImpl implements StudentAggregate {
        private final Student[] students;
        private int size;

        public StudentAggregateImpl(int length) {
            students = new Student[length];
        }

        @Override
        public void add(Student student) {
            students[size++] = student;
        }

        @Override
        public StudentIterator iterator() {
            return new StudentIteratorImpl(students, size);
        }
    }
}
