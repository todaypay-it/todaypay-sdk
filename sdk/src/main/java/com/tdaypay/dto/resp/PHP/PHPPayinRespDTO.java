package com.tdaypay.dto.resp.PHP;

import com.tdaypay.dto.common.resp.PayinRespDTO;
import lombok.Data;

@Data
public class PHPPayinRespDTO extends PayinRespDTO {
    /**
     * 二维码字符串; 当支付方式为paymentType=QRIS会返回;
     */
    private String qrCodeString;
}
