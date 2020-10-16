package com.cardpay.paymentservice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "Данные платежа")
public class Payment {

    @ApiModelProperty(value = "идентификатор ордера")
    private Long orderId;

    @ApiModelProperty(value = "сумма ордера")
    private Double amount;

    @ApiModelProperty(value = "валюта суммы ордера")
    private String currency;

    @ApiModelProperty(value = "комментарий по ордеру")
    private String comment;

    @ApiModelProperty(value = "номер строки исходного файла")
    private Long line;

    @ApiModelProperty(value = "результат парсинга записи исходного файла")
    private String result;

}
