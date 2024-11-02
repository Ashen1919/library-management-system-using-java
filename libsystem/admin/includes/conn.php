<?php
	$conn = new mysqli('localhost', 'root', '', 'libsystem');
	$sa_conn = new mysqli('localhost', 'root', '', 'saegislibrary');

	if ($conn->connect_error) {
	    die("Connection failed: " . $conn->connect_error);
	}
	
?>