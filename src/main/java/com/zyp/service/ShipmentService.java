package com.zyp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyp.entity.Shipment;
import com.zyp.entity.Trade;
import com.zyp.util.IdGenerator;
import com.zyp.util.ShipmentMemory;
import com.zyp.util.TradeMemory;

@Service
public class ShipmentService {
    /**
     * 新增一次交易数据和货运数据
     * 
     * @param trade
     * @param shipmentList
     */
    public void add(Trade trade, List<Shipment> shipmentList) {
        Long tradeId = IdGenerator.getNewId(IdGenerator.TRADE_ID_KEY);
        trade.setTradeId(tradeId);

        TradeMemory.save(trade);
        ShipmentMemory.saveShipments(shipmentList, tradeId);
    }

    /**
     * 获取所有的交易
     * 
     * @return
     */
    public List<Trade> getAllTrades() {
        return TradeMemory.getAllTrades();
    }

    /**
     * 根据交易id查询其所有的货运数据
     * 
     * @param tradeId
     * @return
     */
    public List<Shipment> getShipments(long tradeId) {
        return ShipmentMemory.getShipments(tradeId);
    }

    /**
     * 更新交易和货运
     * 
     * @param trade
     * @param shipmentList
     * @throws Exception
     */
    public void update(Trade trade, List<Shipment> shipmentList) throws Exception {
        Long tradeId = trade.getTradeId();
        Trade oriTrade = TradeMemory.find(trade.getTradeId());// 需要对oriTrade进行锁定//TODO
        if (oriTrade.getVersion() != trade.getVersion()) {
            throw new Exception("数据已被其他用户更改。");
        }

        // 交易数量不变时
        if (trade.getQuantity().equals(oriTrade.getQuantity())) {
            ShipmentMemory.deleteShipments(tradeId);
            ShipmentMemory.saveShipments(shipmentList, tradeId);
            // 交易数量有变化时
        } else {
            Long oriTradeQuant = oriTrade.getQuantity();
            Long newTradeQuant = trade.getQuantity();

            shipmentList = ShipmentMemory.getShipments(tradeId);
            for (Shipment shipment : shipmentList) {
                if (shipment.getQuantity() * newTradeQuant % oriTradeQuant != 0) {
                    throw new Exception("交易数量不适合当前的货运分配比例。");
                }
                Long newShipQuant = shipment.getQuantity() * newTradeQuant / oriTradeQuant;
                shipment.setQuantity(newShipQuant);
            }
            TradeMemory.save(trade);
        }
    }
}
