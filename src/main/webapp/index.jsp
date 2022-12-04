<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ivaaaak.lab2web.model.Point" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>lab2web</title>
    <link rel="stylesheet" href="css/main_style.css">
</head>

<body>
<div id="page-header">

    <div id="headers">
        <h1>Канукова Ева, P32302</h1>
        <h2>Вариант 86231</h2>
    </div>

   <div id="header-cats">
        <img src="images/kitty1.gif" class="kitties" width="140" height="110" alt="" hidden>
        <img src="images/kitty2.gif" class="kitties" width="140" height="110" alt="" hidden>
        <img src="images/kitty3.gif" class="kitties" width="140" height="110" alt="" hidden>
        <img src="images/kitty4.gif" class="kitties" width="140" height="110" alt="" hidden>
    </div>

</div>

<div id="page-container">

    <div id="form-block">

        <canvas id="graph" width="250" height="250"></canvas>
        <p id="r-warning" class="important" hidden>You can't send a point until you choose R value</p>

        <div id="input-box">
            <form action="${pageContext.request.contextPath}/float_args" method="POST" accept-charset="UTF-8" id="graph-points-form">
                <p>
                    <label for="select-x"> Select X </label>
                    <select id="select-x" name="x">
                        <% for (int i = -5; i <=3; i++) { %>
                        <option><%=i%></option>
                        <%}%>
                    </select>
                </p>

                <p>
                    <label for="input-y"> Type Y </label>
                    <input type="text" id="input-y" name="y" placeholder="from -5 to 3" required>
                </p>

                <p id="y-warning" class="important" hidden>You should enter the number in (-5; 3)</p>

                <p id="input-r"> Select R </p>
                <% for (float i = 1; i <= 3; i+= 0.5) { %>
                    <input type="radio" name="r" value=<%=i%> required>
                    <label> <%=i%> </label>
                <%}%>

                <p>
                    <button type="submit" id="check-button">Check</button>
                    <button type="button" id="clear-button">Clear table</button>
                </p>
            </form>
            <img id="clear-animation" src="images/clear-moment.gif" width="130" height="100" alt="" hidden>
        </div>
    </div>

    <div id="table-block">
        <table id="result-table">
            <tr>
                <th>№</th>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Result</th>
            </tr>
            <% Object allPoints = session.getAttribute("points");
            if (allPoints != null) {
                int rowsNum = ((LinkedList<Point>)allPoints).size();
                Iterator<Point> iterator = ((LinkedList<Point>)allPoints).descendingIterator();
                while (iterator.hasNext()) {
                    Point curPoint = iterator.next();
                    out.println("<tr>");
                    out.println("<td>" + rowsNum + "</td>");
                    out.println("<td>" + curPoint.getX() + "</td>");
                    out.println("<td>" + curPoint.getY() + "</td>");
                    out.println("<td>" + curPoint.getR() + "</td>");
                    out.println("<td class=\"important\">" + curPoint.isHit() + "</td>");
                    out.println("</tr>");
                    rowsNum--;
               }
            } %>
        </table>
    </div>
</div>
<script src="js/jquery-3.6.1.js"></script>
<script src="js/Dot.js"></script>
<script src="js/DotsReceiver.js"></script>
<script src="js/DotsSender.js"></script>
<script src="js/GraphDrawer.js"></script>
<script src="js/Main.js"></script>
<script src="js/validation.js"></script>
<script src="js/clear.js"></script>
<script src="js/animation.js"></script>
</body>
</html>