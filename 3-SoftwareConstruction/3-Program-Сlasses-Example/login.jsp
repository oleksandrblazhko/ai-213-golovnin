<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <center>
        <form action="/doLogin" method="post">
            <label for="username">username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="gender">gender:</label>
            <input type="text" id="gender" name="gender" required><br>

            <label for="date_of_birth">date_of_birth:</label>
            <input type="text" id="date_of_birth" name="date_of_birth" required><br>

            <button type="submit">OK</button>
        </form>
    </center>
</div>
</body>
</html>
