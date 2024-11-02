<?php
session_start(); // Start the session

include_once 'dbc.php'; // Ensure connection is established




if (isset($_POST['username']) && isset($_POST['email']) ) {
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

    

    // Close connection
    $conn->close();
} else {
    echo "";
}
?>