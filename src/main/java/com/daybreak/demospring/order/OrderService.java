package com.daybreak.demospring.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
