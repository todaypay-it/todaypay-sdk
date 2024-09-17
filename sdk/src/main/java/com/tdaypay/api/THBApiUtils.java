package com.tdaypay.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.tdaypay.api.common.CommonApiUtils;
import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayoutRespDTO;
import com.tdaypay.dto.req.THB.THBPayinReqDTO;
import com.tdaypay.dto.req.THB.THBPayoutReqDTO;
import com.tdaypay.dto.resp.THB.THBPayinRespDTO;
import com.tdaypay.strategy.Strategy;
import com.tdaypay.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * THB-thailand Interface THBApiUtils
 */
@Component
public class THBApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public THBPayinRespDTO payin(THBPayinReqDTO reqDTO) {
        return (THBPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(THBPayoutReqDTO reqDTO) {
        return  commonApiUtils.payout(reqDTO);
    }

    @Override
    public THBPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, THBPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        THBPayinReqDTO payinReqDTO = (THBPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        THBPayoutReqDTO payoutReqDTO = (THBPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
