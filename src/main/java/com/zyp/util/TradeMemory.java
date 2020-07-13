package com.zyp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zyp.entity.Trade;

/**
 * 交易数据的存储
 * 
 * @author Zyp
 *
 */
public class TradeMemory extends HashMap<Long, Trade> {
    private static final long serialVersionUID = 1L;

    private TradeMemory() {
    };

    private static TradeMemory memory = new TradeMemory();

    static public void save(Trade trade) {
        trade.setVersion(1);
        memory.put(trade.getTradeId(), trade);
    }

    static public Trade find(Long id) {
        return memory.get(id);
    }

    static public List<Trade> getAllTrades() {
        return new ArrayList<Trade>(memory.values());
    }
}
