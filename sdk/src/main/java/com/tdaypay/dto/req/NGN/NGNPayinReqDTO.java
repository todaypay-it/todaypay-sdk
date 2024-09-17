package com.tdaypay.dto.req.NGN;

import com.tdaypay.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NGNPayinReqDTO extends PayinReqDTO {
    /**
     * 如果是银行卡收 款则填银行卡账 号，如果钱包收款 则填写钱包账号
     */
    @NotEmpty
    private String cardNumber;
    /**
     * 支付方式；
     * TCTD
     * NET_BANKING
     */
    private String paymentType;
    /**
     * 支付类型
     */
    private String paymentMethod;
}
