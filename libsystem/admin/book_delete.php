<?php
	include 'includes/session.php';

	if(isset($_POST['delete'])){
		$id = $_POST['id'];

		// Delete from books table in libsystem database
		$sql = "DELETE FROM books WHERE id = '$id'";
		if($conn->query($sql)){
			$_SESSION['success'] = 'Book deleted successfully from libsystem';

			// Delete from books table in saegislibrary database
			$sql_sa = "DELETE FROM books WHERE id = '$id'";
			if($sa_conn->query($sql_sa)){
				$_SESSION['success'] .= ' and saegislibrary';
			}
			else{
				$_SESSION['error'] = 'Failed to delete book from saegislibrary: ' . $sa_conn->error;
			}
		}
		else{
			$_SESSION['error'] = 'Failed to delete book from libsystem: ' . $conn->error;
		}
	}
	else{
		$_SESSION['error'] = 'Select item to delete first';
	}

	header('location: book.php');
?>
