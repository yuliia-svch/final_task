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
    <div class = "d-flex justify-content-center mb-3">
        <form action="<%= request.getContextPath() %>/auth_user_window"
        class="w-50" method="POST">
            <div class = "d-flex justify-content-center">
                <h3>Address</h3>
            </div>
            <div class = "d-flex justify-content-center">
                <label for="city">Choose the city of delivery: </label>
                <select name="city" id="city" class = "form-control">
                     <option value="Lviv">Lviv</option>
                     <option value="Kyiv">Kyiv</option>
                     <option value="Odessa">Odessa</option>
                </select>
            </div>
            <div class = "d-flex justify-content-center">
                <label for="street">Enter the street name:</label>
                <input type = "text" name = "street" class = "form-control"/>
            </div>
            <div class = "d-flex justify-content-center">
                <label for = "streetNum">Enter street number:</label>
                <input type = "number" name = "streetNum" class = "form-control"/>
            </div>
            <hr/>
            <div class = "d-flex justify-content-center">
                <h3>Baggage Info</h3>
            </div>
            <div class = "d-flex justify-content-center">
                <label for="baggageType">What is the type of baggage?</label>
                <select name="baggageType" id="baggageType" class = "form-control">
                    <option value="Furniture">Furniture</option>
                    <option value="Building materials">Building materials</option>
                    <option value="Fragile objects">Fragile objects</option>
                </select>
            </div>
            <div class = "d-flex justify-content-center">
                <label for"weight">What is the weight?(in kg)</label>
                <input type="number" name="weight" class="form-control"/>
            </div>
            <div class = "d-flex justify-content-center">
                <label for="volume">What is the volume?(in m<sup>3</sup>)</label>
                <input type="number" name="volume" class="form-control"/>
            </div>
            <div class = "d-flex justify-content-center">
                <label for="date">Choose the date of delivery:</label>
                <input type="date" name="date" class="form-control">
            </div>
            <div class = "d-flex justify-content-center">
                <input type="submit" value="OK" class = "forSubmit mt-3">
            </div>
        </form>
    </div>
  </body>

</html>