package org.shopservlet;

public class AuthHandler {

    static String registerForm(String url){
        String regPage = "<html>\n" +
                "<style>\n" +
                "    body{\n" +
                "        font-family: Calibri, Helvetica, sans-serif;\n" +
                "        background-color: white;\n" +
                "    }\n" +
                "    .container {\n" +
                "        padding: 10px;\n" +
                "        background-color: white;\n" +
                "    }\n" +
                "    input[type=text], input[type=password], textarea {\n" +
                "        width: 50%;\n" +
                "        height: 10px;\n" +
                "        padding: 15px;\n" +
                "        margin: 5px 0 15px 0;\n" +
                "        display: inline-block;\n" +
                "        border: none;\n" +
                "        background: #f1f1f1;\n" +
                "    }\n" +
                "    input[type=text]:focus, input[type=password]:focus {\n" +
                "        background-color: orange;\n" +
                "        outline: none;\n" +
                "    }\n" +
                "    div {\n" +
                "        padding: 10px 0;\n" +
                "    }\n" +
                "    hr {\n" +
                "        border: 1px solid #f1f1f1;\n" +
                "        margin-bottom: 15px;\n" +
                "    }\n" +
                "    .header{\n" +
                "        alignment: center;\n" +
                "    .registerbtn {\n" +
                "        background-color: #4CAF50;\n" +
                "        color: white;\n" +
                "        padding: 16px 20px;\n" +
                "        margin: 8px 0;\n" +
                "        border: none;\n" +
                "        cursor: pointer;\n" +
                "        width: 100%;\n" +
                "        opacity: 0.9;\n" +
                "    }\n" +
                "    .registerbtn:hover {\n" +
                "        opacity: 1;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "<form action=\"/shopservletapp/simpleregister\" method=\"post\">\n" +
                "    <br/><br/>\n" +
                "    <div class=\"container\"><h1>Register form</h1>\n" +
                "    First Name:<input type=\"text\" name=\"first_name\" required/><br/><br/>\n" +
                "    Last Name:<input type=\"text\" name=\"last_name\"/><br/><br/>\n" +
                "    Login:<input type=\"text\" name=\"login\" required/><br/><br/>\n" +
                "    Password:<input type=\"password\" name=\"password\" required/><br/><br/>\n" +
                "    Email:<input type=\"text\" name=\"email\"/><br/><br/>\n" +
                "    Birthdate<input type=\"date\" name=\"date\" i=\"date\" min=\"1950-01-01\">\n" +
                "    City:\n" +
                "    <select name=\"userCity\">\n" +
                "        <option>Moscow</option>\n" +
                "        <option>Sochi</option>\n" +
                "        <option>other</option>\n" +
                "    </select>\n" +
                "    <br/><br/>\n" +
                "    Address:<input type=\"text\" name=\"address\" required/><br/><br/>\n" +
                "    Mobile:<input type=\"text\" name=\"contact_number\" placeholder=\"+7(912)3456789\" required/><br/><br/>\n" +
                "    <input type=\"submit\" class=\"registerbtn\" value=\"register\"/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
        return regPage;
    }
}