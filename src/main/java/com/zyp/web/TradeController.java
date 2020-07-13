package com.zyp.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyp.dto.RequestDto;
import com.zyp.entity.Trade;
import com.zyp.service.ShipmentService;

@RestController
@RequestMapping("/trades")
public class TradeController {
    private static final Log logger = LogFactory.getLog(TradeController.class);

    @Autowired
    private ShipmentService service;

    /**
     * 新增交易和货运
     * 
     * @param requestDto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody @Validated RequestDto requestDto) {
        service.add(requestDto.getTrade(), requestDto.getShipmentList());

        logger.info("-------------------saved successfully---------------------");
        return "success";
    }

    /**
     * 查询所有交易
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Trade> showAll() {
        return service.getAllTrades();
    }
}
