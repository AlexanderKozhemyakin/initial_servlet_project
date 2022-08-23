<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP testing</title>
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Register Form</h1>
<form action="SimpleRegister" method="post" autocomplete="on" enctype="text/plain">
    <table style="with: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="first_name" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="last_name" /></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" /></td>
        </tr>
        <tr>
            <td>Contact Number</td>
            <td><input type="tel" name="contact_number" /></td>
        </tr></table>
    <input type="submit" value="Submit" /></form>
</body>
</html>