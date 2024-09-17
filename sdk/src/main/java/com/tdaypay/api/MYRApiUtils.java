package com.tdaypay.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.tdaypay.api.common.CommonApiUtils;
import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayoutRespDTO;
import com.tdaypay.dto.req.MYR.MYRPayinReqDTO;
import com.tdaypay.dto.req.MYR.MYRPayoutReqDTO;
import com.tdaypay.dto.resp.MYR.MYRPayinRespDTO;
import com.tdaypay.strategy.Strategy;
import com.tdaypay.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * MYR-malaysia Interface MYRApiUtils
 */
@Component
public class MYRApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public MYRPayinRespDTO payin(MYRPayinReqDTO reqDTO) {
        return (MYRPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(MYRPayoutReqDTO reqDTO) {
        return  commonApiUtils.payout(reqDTO);
    }

    @Override
    public MYRPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, MYRPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        MYRPayinReqDTO payinReqDTO = (MYRPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        MYRPayoutReqDTO payoutReqDTO = (MYRPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
