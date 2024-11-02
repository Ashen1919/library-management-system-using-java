<?php
session_start();

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
    <link href="book-img/favicon.png" rel="icon">
    <link href="book-img/apple-touch-icon.png" rel="apple-touch-icon">

    <!--CSS file link-->
    <link rel="stylesheet" href="book-styles.css">

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
                <li><a a class="active" href="#">BOOKS</a></li>
                <li><a href="Magazines.php">MAGAZINES</a></li>
                <li><a href="Past Papers.php">PAST PAPERS</a></li>
                <li><a href="activity.php">ACTIVITY</a></li>
            </ul>
        </nav>
        
        <main>
            <div class="section">
                <h2><a href="Library Books.php">Library Books</a></h2>
                <div class="book-container">
                    <span class="arrow left-arrow" onclick="previousBook('library')">&#8249;</span>
                    <a href="Library Books.php">
                        <div class="book">
                            <div class="folder" id="library-book">
                                <div class="corner"></div>
                                <span class="book-title">IT</span>
                            </div>
                            <p class="collection">Book Collection</p>
                        </div>
                    </a>
                    <span class="arrow right-arrow" onclick="nextBook('library')">&#8250;</span>
                </div>
            </div>

            <div class="section">
                <h2><a href="E. Books.php">E. Books</a></h2>
                <div class="book-container">
                    <span class="arrow left-arrow" onclick="previousBook('ebook')">&#8249;</span>
                    <a href="E. Books.php">
                        <div class="book">
                            <div class="folder" id="ebook-book">
                                <div class="corner"></div>
                                <span class="book-title">IT</span>
                            </div>
                            <p class="collection">Book Collection</p>
                        </div>
                    </a>
                    <span class="arrow right-arrow" onclick="nextBook('ebook')">&#8250;</span>
                </div>
            </div>
        </main>
        
        <div class="search-bar-container">
            <input type="text" id="search-bar" placeholder="Search for a book..." onkeyup="searchBooks()">
        </div>
        
        <footer>
            <p>Saegis Campus</p>
            <p>No.135, S. De S. Jayasinghe Mawatha, Nugegoda, Sri Lanka.</p>
        </footer>
    </div>
    <script src="book-script.js"></script>
</body>
</html>
