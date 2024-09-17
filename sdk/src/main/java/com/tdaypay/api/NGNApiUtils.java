package com.tdaypay.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.tdaypay.api.common.CommonApiUtils;
import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayoutRespDTO;
import com.tdaypay.dto.req.NGN.NGNPayinReqDTO;
import com.tdaypay.dto.req.NGN.NGNPayoutReqDTO;
import com.tdaypay.dto.resp.NGN.NGNPayinRespDTO;
import com.tdaypay.strategy.Strategy;
import com.tdaypay.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * NGN-nigeria Interface NGNApiUtils
 */
@Component
public class NGNApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public NGNPayinRespDTO payin(NGNPayinReqDTO reqDTO) {
        return (NGNPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(NGNPayoutReqDTO reqDTO) {
        return  commonApiUtils.payout(reqDTO);
    }

    @Override
    public NGNPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, NGNPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        NGNPayinReqDTO payinReqDTO = (NGNPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        NGNPayoutReqDTO payoutReqDTO = (NGNPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
