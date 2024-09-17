package com.tdaypay.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.tdaypay.api.common.CommonApiUtils;
import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayoutRespDTO;
import com.tdaypay.dto.req.ZAR.ZARPayinReqDTO;
import com.tdaypay.dto.req.ZAR.ZARPayoutReqDTO;
import com.tdaypay.dto.resp.ZAR.ZARPayinRespDTO;
import com.tdaypay.strategy.Strategy;
import com.tdaypay.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ZAR-southAfrica Interface ZARApiUtils
 */
@Component
public class ZARApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public ZARPayinRespDTO payin(ZARPayinReqDTO reqDTO) {
        return (ZARPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(ZARPayoutReqDTO reqDTO) {
        return commonApiUtils.payout(reqDTO);
    }

    @Override
    public ZARPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, ZARPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        ZARPayinReqDTO payinReqDTO = (ZARPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        ZARPayoutReqDTO payoutReqDTO = (ZARPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
