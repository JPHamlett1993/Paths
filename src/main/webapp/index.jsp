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
    <body id = "body">
            <c:choose>
                <c:when test="${not empty path}">
                    <div class="<c:out value="${cssMazeClass}"/>">
                    Took <c:out value="${pathSteps}"/> Steps to complete the maze
                    ${path}
                    <button type=button" onclick="reload()" class="mui-btn mui-btn--raised">Solve another maze</button>
                    </div>
                </c:when>
                <c:otherwise>
            <div class="centered">
                        <form class="mui-form">
                            <textarea placeholder="Enter Maze Here" id="path" rows="15" style="white-space: pre; overflow: scroll;" wrap="off"></textarea>
                            <br/>
                            <button type="button" onclick="solve()" class="mui-btn mui-btn--raised">Solve</button>
                        </form>
            </div>
                </c:otherwise>
            </c:choose>

    </body>
</html>