package org.shopservlet;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class ProductCatalog {

    static String showProductsPage(String url) throws SQLException, UnsupportedEncodingException {

        SqlExecutions sqlExecutions = new SqlExecutions();
        String sql = ("select * from products order by id");
        List<Products> products = sqlExecutions.getProducts(sql);

        String productsPage =   "<html><link rel=\"stylesheet\" href=\"styled-table.css\" type=\"text/css\"><body>" +
                                "<input type=\"button\" value=\"Press to close this tab\" onclick=\"self.close()\">" +
                                "<div align=\"center\">" +
                                "<table class=\"styled-table\">" +
                                "    <tr>" +
                                "      <th>Product</th>" +
                                "      <th>Image</th>" +
                                "      <th>Price</th>" +
                                "      <th>Add to cart button</th>" +
                                "    </tr>";
        for (int i = 0; i < products.size(); ) {
            String productName = products.get(i).getName();
            String price = products.get(i).getPrice();
            String pictureName = products.get(i).getPictureName();
            String username = SessionUtils.getUserNameFromUrl(url);
            String sessionId = SessionUtils.getSessionIdFromUrl(url);
            productsPage = productsPage +   "   <tr>" +
                                            "       <td>" + productName + "</td>" +
                                            "       <td><img src=\"images/" + pictureName + "\" style=\"width:300px;height:250px\"></td>" +
                                            "       <td>" + price + "</td>" +
                                            "<td><form method=\"post\" target=\"_blank\" action=\"addtochart?" +
                                            "test=test&sessionId=" + sessionId +
                                            "&addproductnametochart=" + productName +
                                            "&addproducttochartquantity=1" +
                                            "&addproducttochartusername=" + username +
                                            "&addproducttochartprice=" + price + "\">" +
                                            "    <input type=\"hidden\" name=\"add_to_chart\" value=\"1\">\n" +
                                            "    \n" +
                                            "    <label for=\"add-quantity\">Quantity:</label>\n" +
                                            "    <input type=\"number\" name=\"product_quantity\" value=\"1\">\n" +
                                            "    \n" +
                                            "    <input type=\"submit\" value=\"Add to cart\">\n" +
                                            "</form>" +
                                            "</td></tr>";
            i++;
        }
        productsPage = productsPage + "</table><br></br><br></br>image with Red dot from base64: <img src=\"data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAAAUA\n" +
                "    AAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO\n" +
                "        9TXL0Y4OHwAAAABJRU5ErkJggg==\" alt=\"Red dot\" /></body></html>";
        return productsPage;
    }
}