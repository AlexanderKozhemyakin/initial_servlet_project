package org.shopservlet;

import lombok.Data;

@Data
public class ProductsInChart {
    private String session_id;
    private String product;
    private String quantity;
    private String username;
    private String price;
}