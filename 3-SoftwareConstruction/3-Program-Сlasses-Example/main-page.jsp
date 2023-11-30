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
        <h1>Get Air Clear State</h1>
        <h3>Please enter the data below:</h3>
        <form action="/air-clear-info" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">password:</label>
            <input type="text" id="password" name="password" required><br>

            <label for="location">location:</label>
            <input type="text" id="location" name="location" required><br>

            <button type="submit">OK</button>
        </form>
    </center>
</div>
</body>
</html>
