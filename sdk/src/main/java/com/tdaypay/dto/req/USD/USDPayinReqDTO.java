package com.tdaypay.dto.req.USD;

import com.tdaypay.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class USDPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式：CASHAPP
     */
    @NotEmpty
    private String paymentType;
    /**
     * 持卡人所在的真实IP地址：24.23.42.24
     */
    @NotEmpty
    private String ipAddress;
}
