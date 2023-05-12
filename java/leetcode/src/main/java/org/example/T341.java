package org.example;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class T341 {
    interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {
        Iterator<NestedInteger> nestedIterator;
        Iterator<Integer> curr;

        public NestedIterator(List<NestedInteger> nestedList) {
            nestedIterator = nestedList.iterator();
            curr = Collections.emptyIterator();
        }

        @Override
        public boolean hasNext() {
            if (curr.hasNext()) {
                return true;
            }
            if (!nestedIterator.hasNext()) {
                return false;
            }
            NestedInteger next = nestedIterator.next();
            if (next.isInteger()) {
                curr = Collections.singletonList(next.getInteger()).iterator();
            } else {
                curr = new NestedIterator(next.getList());
            }
            return hasNext();
        }

        @Override
        public Integer next() {
            return curr.next();
        }
    }
}
