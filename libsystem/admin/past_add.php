<?php
	include 'includes/session.php';

	if(isset($_POST['add'])){
		$code = $_POST['code'];
		$title = $_POST['title'];
		$year = $_POST['year'];
		$semester = $_POST['semester'];
		$filename = $_FILES['pdf']['name'];

		// Connect to libsystem database
		$conn1 = new mysqli('localhost', 'root', '', 'libsystem');
		if ($conn1->connect_error) {
		    $_SESSION['error'] = 'Connection failed to libsystem: ' . $conn1->connect_error;
		    header('location: past_papers_list.php');
		    exit();
		}

		// Connect to saegislibrary database
		$conn2 = new mysqli('localhost', 'root', '', 'saegislibrary');
		if ($conn2->connect_error) {
		    $_SESSION['error'] = 'Connection failed to saegislibrary: ' . $conn2->connect_error;
		    header('location: past_papers_list.php');
		    exit();
		}

		// Insert into libsystem database
		$sql1 = "INSERT INTO past_papers (code, title, year, semester, pdf) VALUES ('$code', '$title', '$year', '$semester', '$filename')";
		// Insert into saegislibrary database
		$sql2 = "INSERT INTO past_papers (code, title, year, semester, pdf) VALUES ('$code', '$title', '$year', '$semester', '$filename')";

		if($conn1->query($sql1) && $conn2->query($sql2)){
			// Move the file to the pdf folder only if both insertions are successful
			if(!empty($filename)){
				if(move_uploaded_file($_FILES['pdf']['tmp_name'], 'pdf/'.$filename)){
					$_SESSION['success'] = 'Past paper added successfully to both databases and file uploaded';
				} else {
					$_SESSION['error'] = 'Past paper added but failed to upload file';
				}
			} else {
				$_SESSION['success'] = 'Past paper added successfully to both databases';
			}
		}
		else{
			$_SESSION['error'] = 'Error: ' . $conn1->error . ' / ' . $conn2->error;
		}

		// Close connections
		$conn1->close();
		$conn2->close();
	}	
	else{
		$_SESSION['error'] = 'Fill up add form first';
	}

	header('location: past_papers_list.php');
?>
