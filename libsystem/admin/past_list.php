<?php
session_start();

// Connect to the saegislibrary database
$sa_conn = new mysqli('localhost', 'root', '', 'saegislibrary');

if ($sa_conn->connect_error) {
    die("Connection failed: " . $sa_conn->connect_error);
}

// Retrieve the form data from past_papers.php
$course_code = $_POST['course_code'] ?? '';
$module = $_POST['module'] ?? '';
$year = $_POST['year'] ?? '';
$semester = $_POST['semester'] ?? '';

// Build the query to fetch past papers based on the user's input
$query = "SELECT * FROM past_papers WHERE 1=1";

if (!empty($course_code)) {
    $query .= " AND code LIKE '%$course_code%'";
}

if (!empty($module)) {
    $query .= " AND title LIKE '%$module%'";
}

if (!empty($year)) {
    $query .= " AND year = '$year'";
}

if (!empty($semester)) {
    $query .= " AND semester = '$semester'";
}

$result = $sa_conn->query($query);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

    <title>Saegis Library</title>
    <link rel="stylesheet" href="past_list-style.css">

    <style>
        .books-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .books-container li {
            list-style: none;
            flex-basis: calc(20% - 40px); /* Allows for 5 books per row with a small margin */
            margin-bottom: 40px;
        }

        .book {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .hardcover_front img {
            width: 180px; /* Adjust based on your preferred size */
            height: 210px; /* Adjust based on your preferred size */
            background-size: cover;
            background-position: center;
            position: relative;
        }
    </style>
</head>
<body>
    <div class="main-content">
        <header>
            <h1>LIBRARY PAST PAPERS</h1>
        </header>

        <ul class="books-container">
            <?php
            if ($result->num_rows == 0) {
                echo "<p>No past papers found for the selected criteria.</p>";
            } else {
                while ($paper = $result->fetch_assoc()):
                    // Extract the PDF filename without the extension
                    $pdf_name = pathinfo($paper['pdf'], PATHINFO_FILENAME);
            ?>
            <li>
                <figure class='book'>

                    <!-- Front -->
                    <ul class='hardcover_front'>
                        <li>
                            <img src="pdf/pdf-file.jpg" >
                        </li>
                        <li></li>
                    </ul>

                    <!-- Pages -->
                    <ul class='page'>
                        <li></li>
                        <li>
                            <a class="btn" href="pdf/<?php echo $paper['pdf']; ?>" target="_blank">View</a>
                            <a class="btn2" href="pdf/<?php echo $paper['pdf']; ?>" download>Download</a>
                        </li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>

                    <!-- Back -->
                    <ul class='hardcover_back'>
                        <li></li>
                        <li></li>
                    </ul>
                    <ul class='book_spine'>
                        <li></li>
                        <li></li>
                    </ul>
                </figure>

                <!-- Display the PDF name without the extension -->
                <p class="pdf-name"><?php echo htmlspecialchars($pdf_name); ?></p>
            </li>
            <?php 
                endwhile;
            }
            ?>
        </ul>
    </div>

    <script src="scripts.js"></script>
</body>
</html>

<?php
$sa_conn->close();
?>
