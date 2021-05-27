<!DOCTYPE html>

<html lang="en-GB">

  <head>
    <meta charset="utf-8">
    <title>Register</title>
    <link rel='stylesheet' href="style.css"/>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />
  </head>
  <body style = "background-color: rgb(70, 64, 64);">
  <div class = "d-flex justify-content-center mt-3 mb-3">
    <div class="cute">
        <form action="<%= request.getContextPath() %>/register" method="POST" id = "myForm">
            <h2>Register</h2>
            <hr/>
             <div class = "user-name">
                  <label for = "login">Please, create login</label>
                  <br>
                  <input type="text" name="userName" id="userName" minlength = "3" maxlength = "30"
                    style = "border-radius: 12px;" pattern="[a-zA-Z]+[ ][a-zA-Z]+" placeholder = "Yuliia Savchenko" required>
             </div>
             <br/>

             <div class = "password">
                  <label for="password">Please, create password</label>
                  <br>
                  <input type = "password" id = "password" name="password" style = "border-radius: 12px;" minlength = "8" required>
             </div>
             <br/>
             <div className = "d-flex d-flex justify-content-center row">
                    <input type="radio" name="position" value="user">
                    <label for="user">I`m a user</label>
             </div>
             <div className = "d-flex d-flex justify-content-center">
                    <input type="radio" name="position" value="manager">
                    <label for="manager">I`m a manager</label>
             </div>
             <br/>
             <div class = "d-flex d-flex justify-content-center">
                 <input type="submit" value="Register" class = "forSubmit">
             </div>
        </form>
      </div>
  </div>
  </body>
</html>