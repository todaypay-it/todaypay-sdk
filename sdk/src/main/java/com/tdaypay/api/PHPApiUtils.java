package com.tdaypay.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.tdaypay.api.common.CommonApiUtils;
import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayoutRespDTO;
import com.tdaypay.dto.req.PHP.PHPPayinReqDTO;
import com.tdaypay.dto.req.PHP.PHPPayoutReqDTO;
import com.tdaypay.dto.resp.PHP.PHPPayinRespDTO;
import com.tdaypay.strategy.Strategy;
import com.tdaypay.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * PHP-philippines Interface PHPApiUtils
 */
@Component
public class PHPApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public PHPPayinRespDTO payin(PHPPayinReqDTO reqDTO) {
        return (PHPPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(PHPPayoutReqDTO reqDTO) {
        return  commonApiUtils.payout(reqDTO);
    }

    @Override
    public PHPPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, PHPPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        PHPPayinReqDTO payinReqDTO = (PHPPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        PHPPayoutReqDTO payoutReqDTO = (PHPPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
