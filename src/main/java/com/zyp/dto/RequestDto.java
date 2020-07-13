package com.zyp.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.zyp.entity.Shipment;
import com.zyp.entity.Trade;

public class RequestDto {
    @NotNull
    @Valid
    private Trade trade;
    @NotNull
    private List<Shipment> shipmentList;

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }
}
