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
    <link href="maga-img/favicon.png" rel="icon">
    <link href="maga-img/apple-touch-icon.png" rel="apple-touch-icon">

    <!--CSS file link-->
    <link rel="stylesheet" href="maga-styles.css">

    <!--Title-->
    <title>Saegis Library</title>
</head>

<body>
    <div class="container">
        <header>
            <h1>Saegis Library</h1>
            <img id="lp_logo" src="maga-img/saegis logo.png" alt="Saegis Logo">
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
                <li><a a class="active" href="#">MAGAZINES</a></li>
                <li><a href="Past Papers.php">PAST PAPERS</a></li>
                <li><a href="activity.php">ACTIVITY</a></li>
            </ul>
        </nav>
        
        <main>
            <div class="section">
                <h2>Library Magazines</h2>
                <div class="book-container">
                    <span class="arrow left-arrow" onclick="previousBook('library')">&#8249;</span>
                    <a href="Library Magazines Page\Library Magazines.php">
                        <div class="book">
                            <div class="paperclip">📎</div>
                            <div class="folder" id="library-book">
                                <span class="book-title">IT</span>
                            </div>
                            <p class="collection">Collection</p>
                        </div>
                    </a>
                    <span class="arrow right-arrow" onclick="nextBook('library')">&#8250;</span>
                </div>
            </div>

            <div class="section">
                <h2>E. Magazines</h2>
                <div class="book-container">
                    <span class="arrow left-arrow" onclick="previousBook('ebook')">&#8249;</span>
                    <a href="E. Magazines Page\E. Magazines.php">
                        <div class="book">
                            <div class="paperclip">📎</div>
                            <div class="folder" id="ebook-book">
                                <span class="book-title">IT</span>
                            </div>
                            <p class="collection">Collection</p>
                        </div>
                    </a>
                    <span class="arrow right-arrow" onclick="nextBook('ebook')">&#8250;</span>
                </div>
            </div>
        </main>
        
        <div class="search-bar-container">
            <input type="text" id="search-bar" placeholder="Search for a magazine..." onkeyup="searchBooks()">
        </div>
        
        <footer>
            <p>Saegis Campus</p>
            <p>No.135, S. De S. Jayasinghe Mawatha, Nugegoda, Sri Lanka.</p>
        </footer>
    </div>
    <script src="maga-script.js"></script>
</body>
</html>
