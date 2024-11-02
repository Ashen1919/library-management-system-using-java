<?php
include 'includes/session.php';

if(isset($_POST['add'])){
    $isbn = $_POST['isbn'];
    $title = $_POST['title'];
    $category = $_POST['category'];
    $author = $_POST['author'];
    $publisher = $_POST['publisher'];
    $pub_date = $_POST['pub_date'];

    $uploadOk = 1;
    $cover_image = '';

    // Check if file was uploaded
    if(isset($_FILES['cover_page']) && $_FILES['cover_page']['error'] == 0){
        $target_dir = "uploads/"; // Directory to store uploaded images
        $cover_image = $target_dir . basename($_FILES["cover_page"]["name"]);
        $imageFileType = strtolower(pathinfo($cover_image, PATHINFO_EXTENSION));

        // Check if image file is an actual image or fake image
        $check = getimagesize($_FILES["cover_page"]["tmp_name"]);
        if($check !== false) {
            $uploadOk = 1;
        } else {
            $_SESSION['error'] = "File is not an image.";
            $uploadOk = 0;
        }

        // Check file size
        if ($_FILES["cover_page"]["size"] > 500000) { // Limit to 500KB
            $_SESSION['error'] = "Sorry, your file is too large.";
            $uploadOk = 0;
        }

        // Allow certain file formats
        if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif" ) {
            $_SESSION['error'] = "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
            $uploadOk = 0;
        }

        // Check if $uploadOk is set to 0 by an error
        if ($uploadOk == 1) {
            if (!move_uploaded_file($_FILES["cover_page"]["tmp_name"], $cover_image)) {
                $_SESSION['error'] = "Sorry, there was an error uploading your file. Error: " . $_FILES['cover_page']['error'];
                // Log error for debugging
                error_log("File upload error: " . $_FILES['cover_page']['error']);
            }
        }
    } else {
        $uploadOk = 0;
        $_SESSION['error'] = "No file was uploaded or an error occurred.";
    }

    // Only proceed if upload was successful or no image is uploaded
    if ($uploadOk == 1) {
        // Insert into books table in libsystem database
        $sql = "INSERT INTO books (isbn, category_id, title, author, publisher, publish_date, cover_page) VALUES ('$isbn', '$category', '$title', '$author', '$publisher', '$pub_date', '$cover_image')";
        if($conn->query($sql)){
            $_SESSION['success'] = 'Book added successfully in libsystem';

            // Insert into books table in saegislibrary database
            $sql_sa = "INSERT INTO books (isbn, category_id, title, author, publisher, publish_date, cover_page) VALUES ('$isbn', '$category', '$title', '$author', '$publisher', '$pub_date', '$cover_image')";
            if($sa_conn->query($sql_sa)){
                $_SESSION['success'] .= ' and saegislibrary';
            }
            else{
                $_SESSION['error'] = 'Failed to add book in saegislibrary: ' . $sa_conn->error;
            }
        }
        else{
            $_SESSION['error'] = 'Failed to add book in libsystem: ' . $conn->error;
        }
    }
}   
else{
    $_SESSION['error'] = 'Fill up add form first';
}

header('location: book.php');
?>
