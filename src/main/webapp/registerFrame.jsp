<html>
<style>
    body{
        font-family: Calibri, Helvetica, sans-serif;
        background-color: white;
    }
    .container {
        padding: 10px;
        background-color: white;
    }
    input[type=text], input[type=password], textarea {
        width: 50%;
        height: 10px;
        padding: 15px;
        margin: 5px 0 15px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }
    input[type=text]:focus, input[type=password]:focus {
        background-color: orange;
        outline: none;
    }
    div {
        padding: 10px 0;
    }
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 15px;
    }
    .header{
        alignment: center;
    .registerbtn {
        background-color: #4CAF50;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }
    .registerbtn:hover {
        opacity: 1;
    }
</style>
<body>
<form action="/shopservletapp/simpleregister" method="post">
    <br/><br/>
    <div class="container"><h1>Register form</h1>
    First Name:<input type="text" name="first_name"/><br/><br/>
    Last Name:<input type="text" name="last_name"/><br/><br/>
    Login:<input type="text" name="login"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    Email:<input type="text" name="email"/><br/><br/>
    City:
    <select name="userCity">
        <option>Moscow</option>
        <option>Sochi</option>
        <option>other</option>
    </select>
    <br/><br/>
    Address:<input type="text" name="address"/><br/><br/>
    Mobile:<input type="text" name="contact_number"/><br/><br/>
    <input type="submit" class="registerbtn" value="register"/>
</form>
</body>
</html>