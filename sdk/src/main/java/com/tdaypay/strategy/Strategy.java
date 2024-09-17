package com.tdaypay.strategy;

import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayinRespDTO;

import java.util.Map;

public interface Strategy {
    PayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap);

    String convertPayinJsonString(PayinReqDTO reqDTO);

    String convertPayoutJsonString(PayoutReqDTO reqDTO);
}
