package org.shopservlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProductCatalog {

    static String showProductsPage() throws SQLException {

        SqlExecutions sqlExecutions = new SqlExecutions();
        String sql = ("select * from products order by id");
        List<Products> products = new ArrayList();
        products = sqlExecutions.getProducts(sql);


        String productsPage =   "<html><body>" +
                                "<div align=\"center\">"+
                                "<table border=\"5px\" style=\"width:600px\">" +
                                "    <tr>" +
                                "      <th>Product</th>" +
                                "      <th>Image</th>" +
                                "      <th>Add to cart button</th>" +
                                "    </tr>";
        for (int i = 0; i < products.size(); ) {
            String productName = products.get(i).getName();
            productsPage = productsPage +  i + ":" + productName + "   <tr>" +
                                            "       <td>" + productName + "</td>" +
                                            "       <td><img src=\"images/" + productName + ".jpeg\" style=\"width:300px;height:250px\"></td>" +
                                            "       <td><button method=\"post\" action=\"addtocart\" formaction=\"addToCart\"><img src=\"images/cart.jpeg\" alt=\"Cart\"></button></td>" +
                                            "   </tr>";
//                    "   <tr>" +
//                    "       <td>Tshirt2</td>" +
//                    "       <td><img src=\"images/tshirt2.jpeg\" style=\"width:300px;height:250px\"></td>" +
//                    "       <td><button method=\"post\" action=\"addtocart\" formaction=\"addToCart\"><img src=\"images/cart.jpeg\" alt=\"Cart\"></button></td>" +
//                    "   </tr>";
            i++;
        }
        productsPage = productsPage + "</table></body></html>";
        return productsPage;
    }


}
