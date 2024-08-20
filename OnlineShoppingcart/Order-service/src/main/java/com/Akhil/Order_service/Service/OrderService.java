package com.Akhil.Order_service.Service;


import com.Akhil.Order_service.Payload.OrderRequest;
import com.Akhil.Order_service.Payload.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}