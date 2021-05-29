<!DOCTYPE html>

<html lang="en-GB">

  <head>
    <meta charset="utf-8">
    <title>Profile</title>
    <%@ page import="app.entities.User" %>
    <link rel='stylesheet' href="style.css"/>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />
  </head>
  <body>
    <header class = "d-flex justify-content-end mr-3">
        <%
           String str = (String)session.getAttribute("userName");
           if(str != null) {
                 out.println(str);
           }
        %>
    </header>
    <div class = "d-flex justify-content-center w-100">
        <form action="<%= request.getContextPath() %>/auth_user_window" method="POST">
            <h1>Address</h1>

                <label for="city">Choose the city of delivery: </label>
                <select name="city" id="filter" class = "form-control" style = "border-radius: 12px;">
                     <option value="Lviv">Lviv</option>
                     <option value="Kyiv">Kyiv</option>
                     <option value="Odessa">Odessa</option>
                </select>
                <label for="street">Enter the street name:</label>
                <input type = "text" name = "street" class = "form-control"/>
                <label for = "streetNum">Enter street number:</label>
                <input type = "number" name = "streetNum" class = "form-control"/>

        </form>
    </div>
  </body>

</html>