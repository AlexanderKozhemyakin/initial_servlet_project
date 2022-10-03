package org.shopservlet;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class Chart {

    static String showCartPage(String url) throws SQLException, UnsupportedEncodingException {

        SqlExecutions sqlExecutions = new SqlExecutions();
        String sql = ("SELECT * FROM SESSIONS_CARTS WHERE SESSION_ID = ? AND STATUS !='CONFIRMED' ORDER BY PRODUCT");
        List<ProductsInChart> productsInCharts = sqlExecutions.getProductsInChart(sql, SessionUtils.getParameterValueFromUrl(url,"sessionId"));

        String productsInChartPage =   "<html><link rel=\"stylesheet\" href=\"styled-table.css\" type=\"text/css\"><body>" +
                "<div align=\"center\">"+
                "<table class=\"styled-table\">" +
                "    <tr>" +
                "      <th>Product</th>" +
                "      <th>Quantity</th>" +
                "      <th>Price</th>" +
                "    </tr>";
        if (productsInCharts.size()==0) {
            productsInChartPage = productsInChartPage + "<h2>Your chart is empty</h2></body></html>";
        } else {
            for (int i = 0; i < productsInCharts.size(); ) {

                String productName = productsInCharts.get(i).getProduct();
                String productQuantity = productsInCharts.get(i).getQuantity();
                String productPrice = productsInCharts.get(i).getPrice();

                productsInChartPage = productsInChartPage +
                        "   <tr>" +
                        "       <td>" + productName + "</td>" +
                        "       <td>" + productQuantity + "</td>" +
                        "       <td>" + productPrice + "</td>" +
                        "   </tr>";
                i++;
            }
            productsInChartPage = productsInChartPage + "</table>" +
                    "<form method=\"post\" target=\"_blank\" action=\"confirmorder?" +
                    "test=test&sessionId=" + SessionUtils.getParameterValueFromUrl(url, "sessionId") +
                    "&authusername=" + SessionUtils.getParameterValueFromUrl(url, "authusername") + "\">" +
                    "    <input type=\"submit\" value=\"Press to confirm order\">\n" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }
        return productsInChartPage;
    }
}
