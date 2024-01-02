package com.ibm.rest.api.response;

public class Order {
    private Integer orderId;
    private String orderStatus;
    private Double orderValue;
    private String comments;

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Order(Integer orderId, String orderStatus, Double orderValue, String comments) {

        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderValue = orderValue;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderValue=" + orderValue +
                ", comments='" + comments + '\'' +
                '}';
    }
}
