package com.tdaypay.dto.req.RUB;

import com.tdaypay.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RUBPayoutReqDTO extends PayoutReqDTO {
    /**
     * 支付类型;
     * NET_BANKING：银行转账
     */
    @NotEmpty
    private String paymentType;
    /**
     * 收款人银行编码
     */
    @NotEmpty
    private String beneficiaryBankCode;
    /**
     * 	账号类型；
     * BANK
     * PHONE
     */
    @NotEmpty
    private String beneficiaryBankType;
}
