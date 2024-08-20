package com.Akhil.Payment_service.Service;

import com.Akhil.Payment_service.Payload.PaymentRequest;
import com.Akhil.Payment_service.Payload.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
