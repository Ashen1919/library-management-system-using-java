<?php
session_start();


include 'includes/conn.php'; // Include your database connection file

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Query to check the username and password from the admin table
    $sql = "SELECT * FROM admin WHERE username = ? LIMIT 1";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param('s', $username);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        if (password_verify($password, $row['password'])) {
            $_SESSION['admin'] = $row['id']; // Store admin ID in session
            header('location:home.php'); // Redirect to home.php
            exit();
        } else {
            $_SESSION['error'] = 'Invalid Password';
        }
    } else {
        $_SESSION['error'] = 'Invalid Username';
    }
    $stmt->close();
    $conn->close();
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Saegis Library</title>
  <link href="img/favicon.png" rel="icon">
  <link rel="stylesheet" href="admin-styles.css">
</head>
<body>
<img class="library_img" src="img/library.jpg" alt="Library Image">
<div class="center-container">
  <div id="logo_back"></div>
  <img id="lp_logo" src="img\saegis logo.png" alt="Saegis Logo">
</div> 
<div class="wrapper">
    <form action="" method="post" class="login-form" onsubmit="return validateForm()" autocomplete="off" >
      <h2>ADMIN LOGIN</h2>
      <div class="input-field">
        <input type="text" id="username" name="username" required>
        <label for="username">Enter Username</label>
      </div>
      <div class="input-field">
        <input type="password" name="password" id="password" required>
        <label for="password">Enter Password</label>
      </div>
      
      <button type="submit" name="button" id="loginButton">Login</button>
    </form>
  </div>
  <script>
    function validateForm() {
      const username = document.getElementById('username').value;
      const email = document.getElementById('email').value;
      if (username === '' || email === '') {
        alert('Please fill in all fields');
        return false;
      }
      return true;
    }
    const loginButton = document.getElementById('loginButton');
    const inputs = document.querySelectorAll('.login-form input');
    inputs.forEach(input => {
      input.addEventListener('input', () => {
        loginButton.disabled = Array.from(inputs).some(input => input.value === '');
      });
    });
  </script>

</body>
</html>
