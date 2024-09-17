package com.tdaypay.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.tdaypay.api.common.CommonApiUtils;
import com.tdaypay.dto.common.req.PayinReqDTO;
import com.tdaypay.dto.common.req.PayoutReqDTO;
import com.tdaypay.dto.common.resp.PayoutRespDTO;
import com.tdaypay.dto.req.BRL.BRLPayinReqDTO;
import com.tdaypay.dto.req.BRL.BRLPayoutReqDTO;
import com.tdaypay.dto.resp.BRL.BRLPayinRespDTO;
import com.tdaypay.strategy.Strategy;
import com.tdaypay.utils.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * BRL-Brazil Interface BRLApiUtils
 */
@Slf4j
@Component
public class BRLApiUtils implements Strategy {

    @Autowired
    private CommonApiUtils commonApiUtils;

    public BRLPayinRespDTO payin(BRLPayinReqDTO reqDTO) {
        return (BRLPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    public PayoutRespDTO payout(BRLPayoutReqDTO reqDTO) {
        return commonApiUtils.payout(reqDTO);
    }

    @Override
    public BRLPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, BRLPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        BRLPayinReqDTO brlPayinReqDTO = (BRLPayinReqDTO) reqDTO;
        ValidatorUtils.validate(brlPayinReqDTO);
        return JSON.toJSONString(brlPayinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        BRLPayoutReqDTO payoutReqDTO = (BRLPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }

    public static void main(String[] args) {
        BRLPayinReqDTO reqDTO = new BRLPayinReqDTO();
        reqDTO.setAmount("50.00");
        reqDTO.setCallbackUrl("https://webhook.site/41de4e56-1601-4252-a415-59e9711180f2");
        reqDTO.setRedirectUrl("www.baidu.com");
        reqDTO.setCurrency("BRL");
        reqDTO.setDynamic("1");
        reqDTO.setEmail("todaypay@qq.com");
        reqDTO.setFirstname("todaypay");
        reqDTO.setLastname("payin");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setPhone("18823407197");
        reqDTO.setDocNumber("239028308200303");
        reqDTO.setDocType("CPF");
        reqDTO.setProductinfo("Test payin");
        reqDTO.setMchId("202408081821567688447758336");
        reqDTO.setMchKey("7FdUrS5jkDOrzFe");

        BRLApiUtils tools = new BRLApiUtils();
        BRLPayinRespDTO payinRespDTO = tools.payin(reqDTO);
        log.info("BRLTodaypayApiHuTools-payin===>{}", JSON.toJSONString(payinRespDTO));

//        VerifyStatusApiUtils verifyStatusApiUtils = new VerifyStatusApiUtils();
//        VerifyStatusReqDTO verifyStatusReqDTO = new VerifyStatusReqDTO();
//        verifyStatusReqDTO.setMchId("202408081821567688447758336");
//        verifyStatusReqDTO.setMchKey("7FdUrS5jkDOrzFe");
//        verifyStatusReqDTO.setOrderId(payinRespDTO.getOrderId());
//        VerifyStatusRespDTO verifyStatusRespDTO = verifyStatusApiUtils.verifyStatus(verifyStatusReqDTO);

//        log.info("VerifyStatusTodaypayApiHuTools===>{}", JSON.toJSONString(verifyStatusRespDTO));
    }
}
