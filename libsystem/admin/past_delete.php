<?php
	include 'includes/session.php';

	if(isset($_POST['delete'])){
		$id = $_POST['id'];

		// Delete from past_papers table in libsystem database
		$sql = "DELETE FROM past_papers WHERE id = '$id'";
		if($conn->query($sql)){
			$_SESSION['success'] = 'Past paper deleted successfully from libsystem';

			// Delete from past_papers table in saegislibrary database
			$sql_sa = "DELETE FROM past_papers WHERE id = '$id'";
			if($sa_conn->query($sql_sa)){
				$_SESSION['success'] .= ' and saegislibrary';
			}
			else{
				$_SESSION['error'] = 'Failed to delete Past paper from saegislibrary: ' . $sa_conn->error;
			}
		}
		else{
			$_SESSION['error'] = 'Failed to delete Past paper from libsystem: ' . $conn->error;
		}
	}
	else{
		$_SESSION['error'] = 'Select item to delete first';
	}

	header('location: past_papers_list.php');
?>
