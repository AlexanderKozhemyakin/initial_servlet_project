<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>T-shirts shop</title>
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
    <ol class="rounded">
        <ul>
            <li><a href="/shopservletapp/main?catalog" target="_blank" methods="post">Каталог продукции</a></li>
            <li><a href="/shopservletapp/main?onefileload" target="_blank" methods="post">Загрузка Вашего эксиза(печать на 1 стороне)</a></li>
            <li><a href="/shopservletapp/main?twofilesload" target="_blank" methods="post">Загрузка Ваших двух эскизов(лицевая и обратная сторона футкболки)</a></li>
            <li><a href="/shopservletapp/main?cart" target="_blank" methods="post">Корзина</a></li>
            <li><a href="/shopservletapp/main?login" target="_blank" methods="post">Войти</a></li>
            <li><a href="/shopservletapp/main?logout" target="_blank" methods="post">Выйти</a></li>
            <li><a href="/shopservletapp/main?profile" target="_blank" methods="post">Профиль</a></li>
            <li><a href="/shopservletapp/main?viewtshirtpictures" target="_blank" methods="post">PIC</a></li>
            <li><a href="/shopservletapp/displayImage.jsp" target="_blank" methods="post">tag test</a></li>
            <li><a href="/shopservletapp/addImage.jsp" target="_blank" methods="post">О нас</a></li>
        </ul>
    </ol>
</body>
</html>
