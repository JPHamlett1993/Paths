<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Path Finder</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css">
        <link rel="stylesheet" href="assets/style/form_styles.css">
        <script
                src="https://code.jquery.com/jquery-3.2.1.min.js"
                integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
                crossorigin="anonymous"></script>
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        <script src="assets/script/form.js"></script>
    </head>
    <body>
        <div class="centered">
            <form class="mui-form">
                <textarea placeholder="Enter Maze Here" id="path" rows="15"></textarea>
                <button type="submit" onclick="solve()" class="mui-btn mui-btn--raised">Submit</button>
            </form>
        </div>
    </body>
</html>