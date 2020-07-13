package com.zyp.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zyp.entity.Shipment;

public class ShipmentMemory extends ArrayList<Shipment> {

    private static final long serialVersionUID = 1L;

    private ShipmentMemory() {
    }

    static private ArrayList<Shipment> memory = new ArrayList<Shipment>();

    static public List<Shipment> getShipments(long tradeId) {
        List<Shipment> list = new ArrayList<Shipment>();

        for (Shipment shipment : memory) {
            if (tradeId == shipment.getTradeId()) {
                list.add(shipment);
            }
        }
        return list;
    }

    static public void saveShipments(List<Shipment> shipmentList, long tradeId) {
        for (Shipment shipment : shipmentList) {
            shipment.setTradeId(tradeId);
            memory.add(shipment);
        }
    }

    static public void deleteShipments(long tradeId) {
        Iterator<Shipment> itr = memory.iterator();
        while (itr.hasNext()) {
            Shipment shipment = itr.next();
            if (tradeId == shipment.getTradeId()) {
                itr.remove();
            }
        }
    }
}
