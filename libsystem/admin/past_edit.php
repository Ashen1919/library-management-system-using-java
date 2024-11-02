<?php
include 'includes/session.php';

if(isset($_POST['edit'])){
    $id = $_POST['id'];
    $code = $_POST['code'];
    $title = $_POST['title'];
    $year = $_POST['year'];
    $semester = $_POST['semester'];

    // File upload handling
    $target_dir = "pdf/";
    $target_file = $target_dir . basename($_FILES["pdf"]["name"]);
    $uploadOk = 1;
    $fileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

    // Check if file is a actual PDF or fake
    if($fileType != "pdf") {
        $_SESSION['error'] = "Only PDF files are allowed.";
        $uploadOk = 0;
    }

    if ($uploadOk == 1) {
        if (move_uploaded_file($_FILES["pdf"]["tmp_name"], $target_file)) {
            $pdf = $target_file; // Save file path to be stored in the database
        } else {
            $_SESSION['error'] = "Sorry, there was an error uploading your file.";
            header('location: past_papers_list.php');
            exit();
        }
    }

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

    // Update in libsystem database
    $sql1 = "UPDATE past_papers SET code = '$code', title = '$title', year = '$year', semester = '$semester', pdf = '$pdf' WHERE id = '$id'";
    // Update in saegislibrary database
    $sql2 = "UPDATE past_papers SET code = '$code', title = '$title', year = '$year', semester = '$semester', pdf = '$pdf' WHERE id = '$id'";

    if($conn1->query($sql1) && $conn2->query($sql2)){
        $_SESSION['success'] = 'Past paper updated successfully in both databases';
    } else {
        $_SESSION['error'] = 'Error: ' . $conn1->error . ' / ' . $conn2->error;
    }

    // Close connections
    $conn1->close();
    $conn2->close();
} else {
    $_SESSION['error'] = 'Fill up edit form first';
}

header('location: past_papers_list.php');
?>
