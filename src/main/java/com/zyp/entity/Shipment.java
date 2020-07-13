package com.zyp.entity;

import javax.validation.constraints.NotNull;

public class Shipment {
    // 交易id
    private long tradeId;
    // 货运序号
    private Integer seq;
    // 批次数量
    private Long quantity;

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getSeq() {
        return seq;
    }

    @NotNull
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Long getQuantity() {
        return quantity;
    }

    @NotNull
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
