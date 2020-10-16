package com.cardpay.paymentservice.mapper;

import com.cardpay.paymentservice.entity.PaymentJsonEntity;
import com.cardpay.paymentservice.domain.Payment;
import com.cardpay.paymentservice.entity.PaymentCsvEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class PaymentMapper {

    public List<Payment> toDomainFromCSV(List<PaymentCsvEntity> paymentCSVEntities) {
        List<Payment> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(paymentCSVEntities)) {
            for (int i = 0; i < paymentCSVEntities.size(); i++) {
                Payment payment = new Payment();
                payment
                        .setOrderId(paymentCSVEntities.get(i).getOrderId())
                        .setAmount(paymentCSVEntities.get(i).getAmount())
                        .setCurrency(paymentCSVEntities.get(i).getCurrency())
                        .setComment(paymentCSVEntities.get(i).getComment())
                        .setLine((long) i + 1)
                        .setResult("OK");
                resultList.add(payment);
            }
        }

        return resultList;
    }

    public List<Payment> toDomainFromJSON(List<PaymentJsonEntity> paymentEntities) {
        List<Payment> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(paymentEntities)) {
            for (int i = 0; i < paymentEntities.size(); i++) {
                Payment payment = new Payment();
                payment
                        .setOrderId(paymentEntities.get(i).getOrderId())
                        .setAmount(paymentEntities.get(i).getAmount())
                        .setCurrency(paymentEntities.get(i).getCurrency())
                        .setComment(paymentEntities.get(i).getComment())
                        .setLine((long) i + 1)
                        .setResult("OK");
                resultList.add(payment);
            }
        }

        return resultList;
    }
}
