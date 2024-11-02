<?php
session_start();
require 'vendor/autoload.php'; // Ensure PHPMailer is autoloaded

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

include_once 'dbc.php';

// Check if form data is set
if (isset($_POST['username']) && isset($_POST['email'])) {
    // Get form data
    $studentID = $_POST['username'];
    $email = $_POST['email'];

    // Store username in session
    $_SESSION['username'] = $studentID;

    // Prevent SQL injection
    $studentID = $conn->real_escape_string($studentID);
    $email = $conn->real_escape_string($email);

    // Generate a 6-digit OTP
    $otp = rand(100000, 999999);

    // Store OTP in the session for later verification
    $_SESSION['otp'] = $otp;

    // Send OTP to the email
    $mail = new PHPMailer(true);
    try {
        // Server settings
        $mail->isSMTP();
        $mail->Host = 'smtp.gmail.com'; // Set the SMTP server to send through
        $mail->SMTPAuth = true;
        $mail->Username = 'saegislibrary35@gmail.com'; // SMTP username
        $mail->Password = 'odvqshjmafyewdrc'; // SMTP password
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;
        $mail->Port = 587;

        // Recipients
        $mail->setFrom('saegislibrary35@gmail.com', 'Saegis Library');
        $mail->addAddress($email, $studentID);

        // Content
        $mail->isHTML(true);
        $mail->Subject = 'Your Verification Code';
        $mail->Body = "Your verification code is <b>$otp</b>";

        // Send email
        if ($mail->send()) {
            // SQL query to insert data and OTP
            $sql = "INSERT INTO users (studentID, email, otp) VALUES ('$studentID', '$email', '$otp')";

            // Execute the query
            if ($conn->query($sql) === TRUE) {
                // Redirect to Verification Page
                header("Location: Verification Page.php");
                exit();
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        } else {
            echo 'Email could not be sent. Error: ' . $mail->ErrorInfo;
        }
    } catch (Exception $e) {
        echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
    }

    // Close connection
    $conn->close();
} else {
    echo "";
}
?>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Saegis Library</title>
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <img class="library_img" src="img/library.jpg" alt="Library Image">
  <div class="center-container">
    <div id="logo_back"></div>
    <img id="lp_logo" src="img/saegis logo.png" alt="Saegis Logo">
  </div> 
  <div class="wrapper">
    <form action="" method="post" class="login-form" onsubmit="return validateForm()">
      <h2>USER LOGIN</h2>
      <div class="input-field">
        <input type="text" id="username" name="username" required>
        <label for="username">Enter Your Student ID / Lecture ID</label>
      </div>
      <div class="input-field">
        <input type="text" name="email" id="email" required>
        <label for="email">Enter Your Saegis Email</label>
      </div>
      <div class="forget">
        <label for="remember">
          <input type="checkbox" id="remember">
          <p>Remember Me</p>
        </label>
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
