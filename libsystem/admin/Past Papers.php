<?php
session_start();

// Handle logout
if (isset($_POST['logout'])) {
    session_destroy();
    header("Location: Login Page.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--Favicons-->
    <link href="book-img/favicon.png" rel="icon">
    <link href="book-img/apple-touch-icon.png" rel="apple-touch-icon">

    <!--CSS file link-->
    <link rel="stylesheet" href="past-styles.css">

    <!--Title-->
    <title>Saegis Library</title>
</head>

<body>
    <div class="container">
        <header>
            <h1>Saegis Library</h1>
            <img id="lp_logo" src="book-img/saegis logo.png" alt="Saegis Logo">
            <span class="name-id">
                <p id="name">WELCOME</p>
                <p id="sid"><?php echo htmlspecialchars($_SESSION['username']); ?></p> <!-- Display the username -->
                <form method="post" style="display: inline;">
                    <button class="logout" type="submit" name="logout">Logout</button>
                </form>
            </span>
        </header>
        <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a href="Home-user.php">HOME</a></li>
                <li><a href="Books.php">BOOKS</a></li>
                <li><a href="Magazines.php">MAGAZINES</a></li>
                <li><a class="active" href="#">PAST PAPERS</a></li>
                <li><a href="activity.php">ACTIVITY</a></li>
            </ul>
        </nav>

        <div class="form-container">
            <h1>Browse Here</h1>
            <form method="POST" action="past_list.php">
                <div class="form-group">
                    <label for="course-code">Course code :</label>
                    <input type="text" id="course-code" name="course_code" placeholder="Enter Course Code">
                </div>
                <div class="form-group">
                    <label for="module">Module :</label>
                    <input type="text" id="module" name="module" placeholder="Enter Module">
                </div>
                <div class="form-group">
                    <label for="year">Year :</label>
                    <select id="year" name="year">
                        <option value="">Select Year</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="semester">Semester :</label>
                    <select id="semester" name="semester">
                        <option value="">Select Semester</option>
                        <option value="1">First Semester</option>
                        <option value="2">Second Semester</option>
                    </select>
                </div>
                <button type="submit">GO</button>
            </form>
        </div>

        <footer>
            <p>Saegis Campus</p>
            <p>No.135, S. De S. Jayasinghe Mawatha, Nugegoda, Sri Lanka.</p>
        </footer>
    </div>
</body>
</html>
