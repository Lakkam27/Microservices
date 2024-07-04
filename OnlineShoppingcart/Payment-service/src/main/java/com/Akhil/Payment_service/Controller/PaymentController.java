package com.Akhil.Payment_service.Controller;

import com.Akhil.Payment_service.Payload.PaymentRequest;
import com.Akhil.Payment_service.Payload.PaymentResponse;
import com.Akhil.Payment_service.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        log.info("PaymentController | doPayment is called");
        log.info("PaymentController | doPayment | paymentRequest : " + paymentRequest.toString());
        return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);


    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable long orderId) {

        log.info("PaymentController | doPayment is called");

        log.info("PaymentController | doPayment | orderId : " + orderId);

        return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
    }


}
