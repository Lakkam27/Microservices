package com.Akhil.Payment_service.Exception;

import com.Akhil.Payment_service.Payload.PaymentRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaymentServiceCustomException extends  RuntimeException{
    private final String errorCode;
    public PaymentServiceCustomException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }


}
