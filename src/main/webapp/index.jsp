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
    <% System.out.println("ASDF: \n" + request.getAttribute("path")); %>
    <c:choose>
        <c:when test = "${100 > 50}">
            TRUE
        </c:when>
        <c:otherwise>
           FALSE
        </c:otherwise>
    </c:choose>
</body>
</html>