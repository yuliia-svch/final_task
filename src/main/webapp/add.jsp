<!DOCTYPE html>

<html lang="en-GB">

  <head>
    <meta charset="utf-8">
    <title>Log In</title>
    <link rel='stylesheet' href="style.css"/>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />
  </head>
  <body style = "background-color: rgb(70, 64, 64);">
  <div class = "d-flex justify-content-center mt-3 mb-3">
    <div class="cute">
        <form action="<%= request.getContextPath() %>/add" method="POST" id = "myForm">
            <h2>Log In</h2>
            <hr/>
            <%
               if(request.getAttribute("pass_incorr") != null) {
                   out.println("<p>" + request.getAttribute("pass_incorr") + "</p>");
               }
            %>
             <div class = "user-name">
                  <label for = "login">Enter first and last name</label>
                  <br>
                  <input type="text" name="userName" id="userName" minlength = "3" maxlength = "30"
                    style = "border-radius: 12px;" pattern="[a-zA-Z]+[ ][a-zA-Z]+" placeholder = "Yuliia Savchenko" required>
             </div>
             <br/>

             <div class = "password">
                  <label for="password">Enter the password</label>
                  <br>
                  <input type = "password" id = "password" name="password" style = "border-radius: 12px;" minlength = "8" required>
             </div>
             <br/>
             <%
                if(request.getAttribute("register") != null) {
                    out.println("<p>" + request.getAttribute("register") + "</p>");
                    out.println("Register <a href='/register'>here</a>");
                }
             %>
             <div class = "d-flex d-flex justify-content-center">
                 <input type="submit"
                 <%

                    if(request.getAttribute("register") != null) {
                        out.println(" value='Register' ");
                    } else {
                        out.println(" value='Log In' ");
                    }
                 %>
                 class = "forSubmit">
             </div>
        </form>
      </div>
  </div>
  </body>
</html>