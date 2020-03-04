package com.takiya.LeetCode;

import java.util.ArrayList;

public class StockSpanner {
    class Pair {
        int stock;
        int next;

        Pair(int stock, int next) {
            this.stock = stock;
            this.next = next;
        }
    }
    ArrayList<Pair> stockList;

    public StockSpanner() {
        this.stockList = new ArrayList<>();
    }

    public int next(int price) {
        int index = stockList.size()-1;
        int span = 1;
        while (index >= 0) {
            Pair history = stockList.get(index);
            if (history.stock > price)
                break;
            else
                span += history.next;
            index -= history.next;
        }
        stockList.add(new Pair(price, span));
        return span;
    }
}
