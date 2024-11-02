<?php
session_start();

include_once 'dbc.php';

// Check if the OTP is set
if (isset($_POST['otp'])) {
    $enteredOtp = $_POST['otp'];
    $username = $_SESSION['username'];

    // Prevent SQL injection
    $username = $conn->real_escape_string($username);
    $enteredOtp = $conn->real_escape_string($enteredOtp);

    // Query to fetch the OTP from the database
    $sql = "SELECT otp FROM users WHERE studentID = '$username'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $storedOtp = $row['otp'];

        // Verify the OTP
        if ($enteredOtp == $storedOtp) {
            // OTP is correct, redirect to Home.html
            header("Location: Home-user.php");
            exit();
        } else {
            echo "<script>alert('Invalid OTP. Please try again.')</script>";
        }
    } else {
        echo "User not found.";
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
  <link href="img1/favicon.png" rel="icon">
  <link href="img1/apple-touch-icon.png" rel="apple-touch-icon">
  <link rel="stylesheet" href="style1.css">
</head>
<body>
  <img class="library_img" src="img1/library.jpg" alt="Library Image">
  <div class="center-container">
    <div id="logo_back"></div>
    <img id="lp_logo" src="img1/saegis logo.png" alt="Saegis Logo">
  </div> 
  <div class="wrapper">
    <h1><?php echo htmlspecialchars($_SESSION['username']); ?></h1> <!-- Display the username -->
    <h2>Verification</h2>
    <p>We sent the verification code to your Saegis email address. <br>Enter verification code:</p>
    <form action="" method="post">
      <div class="input-field">
        <input type="text" name="otp" required>
        <label>Enter verification code</label>
      </div>
      <div class="buttons">
        <button type="submit">Verify</button>
      </div>
    </form>
  </div>
  <a href="Login Page.php"><input id="Back" type="button" value="Back"></a>
</body>
</html>
