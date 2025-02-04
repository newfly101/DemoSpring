package com.daybreak.demospring.singleton;

public class StatefulService {

    /**
     * 상태 유지로 코드를 선언된 부분
     */
    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 여기가 문제!
    }

    public int getPrice() {
        return price;
    }
    /**
     * 무상태(stateless)로 설계되는 경우 지역 변수를 사용
     */
    public int orderLess(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }
}


