<?php


include_once 'dbc.php'; // Ensure connection is established


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
            echo "OTP verified successfully!";
            // You can redirect to another page or perform any other actions
        } else {
            echo "Invalid OTP. Please try again.";
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
