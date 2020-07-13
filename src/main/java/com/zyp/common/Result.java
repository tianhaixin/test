package com.zyp.common;

public class Result {
    private boolean success;

    private String message;

    private Object data;

    private int totalSize;

    private int dataSize;

    public Result() {
    }

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result(boolean success, String message, Object data, int totalSize, int dataSize) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.totalSize = totalSize;
        this.dataSize = dataSize;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    @Override
    public String toString() {
        return "Result{" + "success=" + success + ", message='" + message + '\'' + ", data=" + data + ", totalSize="
                + totalSize + ", dataSize=" + dataSize + '}';
    }
}