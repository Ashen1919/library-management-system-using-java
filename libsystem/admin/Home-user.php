<?php
session_start();

// Database connection
$host = "localhost";
$username = "root";
$password = "";

// Connect to saegislibrary database
$saegis_db = new mysqli($host, $username, $password, "saegislibrary");
if ($saegis_db->connect_error) {
    die("Connection failed: " . $saegis_db->connect_error);
}

// Connect to libsystem database
$libsystem_db = new mysqli($host, $username, $password, "libsystem");
if ($libsystem_db->connect_error) {
    die("Connection failed: " . $libsystem_db->connect_error);
}

// Get the number of books
$book_count_query = "SELECT COUNT(*) as book_count FROM books";
$book_count_result = $saegis_db->query($book_count_query);
$book_count = $book_count_result->fetch_assoc()['book_count'];

// Get the number of students
$student_count_query = "SELECT COUNT(*) as student_count FROM students";
$student_count_result = $libsystem_db->query($student_count_query);
$student_count = $student_count_result->fetch_assoc()['student_count'];

// Close the database connections
$saegis_db->close();
$libsystem_db->close();

// Handle logout
if (isset($_POST['logout'])) {
    // Destroy the session
    session_destroy();
    // Redirect to Login Page.php
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
    <link href="img2/favicon.png" rel="icon">
    <link href="img2/apple-touch-icon.png" rel="apple-touch-icon">

    <!--CSS file link-->
    <link rel="stylesheet" href="home-styles.css">

    <!--Title-->
    <title>Saegis Library</title>
</head>

<body>
    <div class="container">
        <header>
            <h1>Saegis Library</h1>
            <img id="lp_logo" src="img2/saegis logo.png" alt="Saegis Logo">
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
                <li><a class="active" href="#">HOME</a></li>
                <li><a href="Books.php">BOOKS</a></li>
                <li><a href="Magazines.php">MAGAZINES</a></li>
                <li><a href="Past Papers.php">PAST PAPERS</a></li>
                <li><a href="activity.php">ACTIVITY</a></li>
            </ul>
        </nav>
        <main>
            <div>
                <canvas id="myChart" class="do-chart"></canvas>
            </div>
            <div class="content">
                <div class="slideshow-container">
                    <div class="mySlides fade">
                        <img src="img2/Library/a.jpg" style="width:100%">
                    </div>
                    <div class="mySlides fade">
                        <img src="img2/Library/b.jpg" style="width:100%">
                    </div>
                    <div class="mySlides fade">
                        <img src="img2/Library/c.jpg" style="width:100%">
                    </div>
                    <div class="mySlides fade">
                        <img src="img2/Library/e.jpg" style="width:100%">
                    </div>
                    <div class="mySlides fade">
                        <img src="img2/Library/f.jpg" style="width:100%">
                    </div>
                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                </div>
                <div class="stats">
                    <div id="stat-bk" class="stat">
                        <img id="bk" src="img2/bk.png" alt="Books">
                        <span><?php echo $book_count; ?> + <br>Collection</span> <!-- Dynamic book count -->
                    </div>
                    <div id="stat-users" class="stat">
                        <img id="users" src="img2/users.png" alt="Users">
                        <span><?php echo $student_count; ?> + <br>Active Users</span> <!-- Dynamic student count -->
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <p>Saegis Campus</p>
            <p>No.135, S. De S. Jayasinghe Mawatha, Nugegoda, Sri Lanka.</p>
        </footer>
    </div>
    <script src="script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const ctx = document.getElementById('myChart');
      
        new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ['IT', 'Management', 'English'],
                datasets: [{
                    label: 'Number of percentage',
                    data: [60, 30, 10],
                    borderWidth: 1
                }]
            }
        });
    </script>
</body>
</html>
