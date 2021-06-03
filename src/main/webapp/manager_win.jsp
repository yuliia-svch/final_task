<!DOCTYPE html>

<html lang="en-GB">

  <head>
    <meta charset="utf-8">
    <title>Log In</title>
    <%@ page import="java.util.List" %>
    <%@ page import="app.entities.Application" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel='stylesheet' href="style.css"/>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />
  </head>
  <body>

    <h4 class = "d-flex justify-content-center mt-3">Applications:</h4>
    <form action="<%= request.getContextPath() %>/manager_win" method="GET"
    class = "d-flex justify-content-center">
        <input type="submit" value="Show all applications" class="btn btn-outline-danger"/>
    </form>
    <br/>
    <div class = "d-flex justify-content-center">
        <table id = "id01" class="table table-hover">
            <thead>
                <tr>
                  <th scope="col">Address</th>
                  <th scope="col">Baggage Type</th>
                  <th scope="col">Weight (kg)</th>
                  <th scope="col">Volume (m<sup>3</sup>)</th>
                  <th scope="col">Date of receival</th>
                  <th scope="col">Customer</th>
                </tr>
              </thead>
              <tbody>
            <%
               List<Application> apps = (List<Application>) request.getAttribute("applications");

               if (apps != null && !apps.isEmpty()) {

                  for (Application a : apps) {
                      out.println("<tr>");
                      out.println("<td>" + a.getAddress() + "</td>");
                      out.println("<td>" + a.getBaggageType() + "</td>");
                      out.println("<td>" + a.getWeight() + "</td>");
                      out.println("<td>" + a.getVolume() + "</td>");
                      out.println("<td>" + a.getDateOfReceival() + "</td>");
                      out.println("<td>" + a.getLogin() + "</td>");
                      out.println("</tr>");
                  }

               }
            %>
          </tbody>
        </table>
    </div>

  </body>
</html>