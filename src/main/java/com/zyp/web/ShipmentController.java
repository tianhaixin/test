package com.zyp.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyp.dto.RequestDto;
import com.zyp.entity.Shipment;
import com.zyp.service.ShipmentService;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private static final Log logger = LogFactory.getLog(ShipmentController.class);

    @Autowired
    private ShipmentService service;

    /**
     * 查询交易下的货运信息
     * 
     * @param tradeId
     * @return
     */
    @RequestMapping(value = "/{tradeId}", method = RequestMethod.GET)
    public List<Shipment> getShipment(@PathVariable long tradeId) {
        return service.getShipments(tradeId);
    }

    /**
     * 更新货运信息
     * 
     * @param requestDto
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody @Validated RequestDto requestDto) throws Exception {
        service.update(requestDto.getTrade(), requestDto.getShipmentList());

        logger.info("-------------------updated successfully---------------------");
        return "success";
    }
}
