package com.cardpay.paymentservice.service;

import com.cardpay.paymentservice.entity.PaymentJsonEntity;
import com.cardpay.paymentservice.domain.Payment;
import com.cardpay.paymentservice.entity.PaymentCsvEntity;
import com.cardpay.paymentservice.mapper.PaymentMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public List<Payment> getPaymentListFromCSV(MultipartFile file) throws IOException {
        CsvToBeanBuilder<PaymentCsvEntity> csvToBeanBuilder
                = new CsvToBeanBuilder<PaymentCsvEntity>(new InputStreamReader(file.getInputStream()));
        List<PaymentCsvEntity> paymentCSVEntities = csvToBeanBuilder.withType(PaymentCsvEntity.class).build().parse();

        return paymentMapper.toDomainFromCSV(paymentCSVEntities);
    }

    public List<Payment>  getPaymentListFromJSON(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<PaymentJsonEntity> paymentEntities = objectMapper.readValue(new InputStreamReader(file.getInputStream()),
                new TypeReference<List<PaymentJsonEntity>>(){});

        return paymentMapper.toDomainFromJSON(paymentEntities);
    }

}
