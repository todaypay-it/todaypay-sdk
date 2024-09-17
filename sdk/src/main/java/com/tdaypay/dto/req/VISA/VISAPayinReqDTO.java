package com.tdaypay.dto.req.VISA;

import com.tdaypay.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VISAPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式:CARD
     */
    @NotEmpty
    private String paymentType;
}
