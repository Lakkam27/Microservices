package com.Akhil.Payment_service.Repository;

import com.Akhil.Payment_service.TransactionDetails.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {

    Optional<TransactionDetails> findByOrderId(long orderId);
}
