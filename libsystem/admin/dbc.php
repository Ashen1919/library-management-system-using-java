<?php
// Database credentials
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "saegislibrary";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);


// Example query
$sql1 = "SELECT studentID, email FROM users";
$result = $conn->query($sql1);




?>
