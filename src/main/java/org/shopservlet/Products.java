package org.shopservlet;

import lombok.Data;

@Data
public class Products {
    private int id;
    private String name;
    private String desc;
    private String price;
    private String pictureName;
}
