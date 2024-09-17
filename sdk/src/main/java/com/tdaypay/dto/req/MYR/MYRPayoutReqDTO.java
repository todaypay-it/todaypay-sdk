package com.tdaypay.dto.req.MYR;

import com.tdaypay.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MYRPayoutReqDTO extends PayoutReqDTO {
    /**
     * 支付类型;
     * NET_BANKING
     */
    @NotEmpty
    private String paymentType;
    /**
     * 收款人银行编码:AFBB
     */
    @NotEmpty
    private String beneficiaryBankCode;
}
