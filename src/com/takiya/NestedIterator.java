package com.takiya;

import Interface.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    Stack<Integer> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        stack = new Stack<>();
    }

    @Override
    public Integer next() {

        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

}
