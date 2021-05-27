<!DOCTYPE html>

<html lang="en-GB">

  <head>
    <meta charset="utf-8">
    <title>Log In</title>
    <%@ page import="java.util.List" %>
    <%@ page import="app.entities.Direction" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel='stylesheet' href="style.css"/>
    <script src = "func.js"></script>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />
  </head>
  <body style = "background-color: rgb(70, 64, 64);">
  <div class="d-flex justify-content-end mr-3">
      <a href="/add">Log In</a>
  </div>
  <h4 style = "color: rgb(236, 178, 222);" class = "d-flex justify-content-center mt-3">Directions:</h4>
    <div class = "d-flex justify-content-around mt-3">
        <button class = "forSubmit" onclick="sort()">Sort by region</button>

    <div class = "row mt-3">
        <label for="filter" style = "color: rgb(236, 178, 222);">Filter by region:</label>
        <br>
        <select name="filter" id="filter" class = "ml-3" style = "border-radius: 12px;">
            <option value="Lviv">Lviv</option>
            <option value="Kyiv">Kyiv</option>
            <option value="Odessa">Odessa</option>
        </select>

        <button class = "forSubmit ml-3" onclick="filter()">Filter</button>
    </div>
    </div>
    <br/>
    <br/>
    <div class = "d-flex justify-content-center">
        <table id = "id01" class="table table-hover">
            <thead>
                <tr>
                  <th scope="col">Region</th>
                  <th scope="col">Type of delivery</th>
                  <th scope="col">Capacity (m^3)</th>
                  <th scope="col">Weight (kg)</th>
                  <th scope="col">Pricing (hrn)</th>
                </tr>
              </thead>
              <tbody>
            <%
               List<Direction> directions = (List<Direction>) request.getAttribute("directions");

               if (directions != null && !directions.isEmpty()) {

                  for (Direction d : directions) {
                      out.println("<tr>");
                      out.println("<td>" + d.getRegion() + "</td>");
                      out.println("<td>" + d.getTypeOfDelivery() + "</td>");
                      out.println("<td>" + d.getCapacity() + "</td>");
                      out.println("<td>" + d.getWeight() + "</td>");
                      out.println("<td>" + d.getPricing() + "</td>");
                      out.println("</tr>");
                  }

               }
            %>
          </tbody>
        </table>
    </div>

  </body>
</html>