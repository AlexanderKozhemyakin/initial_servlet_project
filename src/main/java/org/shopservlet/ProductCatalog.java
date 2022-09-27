package org.shopservlet;

public class ProductCatalog {
    static String showProductsPage(){

        String productsPage =   "<html><body>" +
                                "<div align=\"center\">"+
                                "<table border=\"5px\" style=\"width:600px\">" +
                                "    <tr>" +
                                "      <th>Product</th>" +
                                "      <th>Image</th>" +
                                "      <th>Add to cart button</th>" +
                                "    </tr>";
//TODO add select all products from database
// if(imgFileName!="" && imgId!=""){
        if(true){
            productsPage = productsPage +   "   <tr>" +
                                            "       <td>Tshirt1</td>" +
                                            "       <td><img src=\"images/tshirt1.jpeg\" style=\"width:300px;height:250px\"></td>" +
                                            "       <td><button method=\"post\" action=\"addtocart\" formaction=\"addToCart\"><img src=\"images/cart.jpeg\" alt=\"Cart\"></button></td>" +
                                            "   </tr>" +
                    "   <tr>" +
                    "       <td>Tshirt2</td>" +
                    "       <td><img src=\"images/tshirt2.jpeg\" style=\"width:300px;height:250px\"></td>" +
                    "       <td><button method=\"post\" action=\"addtocart\" formaction=\"addToCart\"><img src=\"images/cart.jpeg\" alt=\"Cart\"></button></td>" +
                    "   </tr>";
        }
        productsPage = productsPage +
                                "    </div>" +
                                "  </table>" +
                                "</body>" +
                                "</html>";
        return productsPage;
    }


}
