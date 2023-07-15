package com.wgx.fifty.day9;

import java.util.ArrayList;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/21 9:51
 */
public class 股票价格跨度 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(31));
        System.out.println(stockSpanner.next(41));
        System.out.println(stockSpanner.next(48));
        System.out.println(stockSpanner.next(59));
        System.out.println(stockSpanner.next(79));
    }
}
class StockSpanner {

    private ArrayList<Stock> stock;

    public StockSpanner() {
        stock = new ArrayList<>();
    }

    public int next(int price) {
        int next = 1;
        Stock prev = null;
        if (!stock.isEmpty()) {
            prev = this.stock.get(this.stock.size() - 1);
            while (prev != null && prev.price <= price) {
                next += prev.next;
                prev = prev.maxPrev;
            }
        }
        stock.add(new Stock(prev, price, next));
        return next;
    }
}

class Stock {
    public Stock maxPrev;
    public int price;
    public int next;

    public Stock(Stock maxPrev, int price, int next) {
        this.maxPrev = maxPrev;
        this.price = price;
        this.next = next;
    }
}