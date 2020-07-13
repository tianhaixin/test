package com.zyp.entity;

import javax.validation.constraints.NotNull;

public class Trade {
    private long tradeId;
    // 交易数量
    @NotNull(message = "交易数量不能为空")
    private Long quantity;
    // 版本号（更新时用）
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
