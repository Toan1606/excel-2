package com.eric.excel.model;

import java.math.BigDecimal;

public class Book {
    private Long id;

    private String title;

    private int quantity;

    private BigDecimal price;

    private BigDecimal totalMoney;

    public Book() {
        super();
    }

    public Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.totalMoney = builder.totalMoney;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTotalMoney() {
        return this.totalMoney;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public static class Builder {
        private Long id;

        private String title;

        private int quantity;

        private BigDecimal price;

        private BigDecimal totalMoney;

        public Builder() {

        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder totalMoney(BigDecimal totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
