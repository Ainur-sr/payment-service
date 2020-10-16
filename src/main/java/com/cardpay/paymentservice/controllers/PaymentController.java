package com.cardpay.paymentservice.controllers;

import com.cardpay.paymentservice.domain.Payment;
import com.cardpay.paymentservice.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentController {

    private final PaymentService paymentService;

    @ApiOperation("Отправить платеж файлом CSV")
    @PostMapping("/pay/file/csv")
    public List<Payment> payByCSVFile(@RequestParam("file") MultipartFile file) {
        List<Payment> resultList = null;
        try {
            resultList = paymentService.getPaymentListFromCSV(file);
        } catch (IOException e) {
            log.error("Error on fetch data", e);
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @ApiOperation("Отправить платеж файлом JSON")
    @PostMapping("/pay/file/json")
    public List<Payment> payByJSONFile(@RequestParam("file") MultipartFile file) {
        List<Payment> resultList = null;
        try {
            resultList = paymentService.getPaymentListFromJSON(file);
        } catch (IOException e) {
            log.error("Error on fetch data", e);
            throw new RuntimeException(e);
        }
        return resultList;
    }

}
