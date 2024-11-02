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
    <link href="acti-img/favicon.png" rel="icon">
    <link href="acti-img/apple-touch-icon.png" rel="apple-touch-icon">

    <!--CSS file link-->
    <link rel="stylesheet" href="activ-styles.css">

    <!--Title-->
    <title>Saegis Library</title>
</head>

<body>
    <div class="container">
        <header>
            <h1>Saegis Library</h1>
            <img id="lp_logo" src="acti-img/saegis logo.png" alt="Saegis Logo">
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
                <li><a href="Past Papers.php">PAST PAPERS</a></li>
                <li><a a class="active" href="#">ACTIVITY</a></li>
            </ul>
        </nav>
        <main id="main-a">
        <div class="a-container">
            <div class="row">
                <div class="card">
                    <div class="card-header">
                        <img src="acti-img/book (1).png" alt="issued" class="card-icon">
                        <span class="card-title">ISSUED</span>
                        <span class="card-count">5</span>
                    </div>
                    <br><br>
                    <hr>
                    <div class="card-footer">
                        <a href="Activity-Issued/Activity-Issued.php">More info</a><img src="acti-img/right.png" alt="arrow key" class="card-icons">
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="acti-img/return (1).png" alt="return" class="card-icon">
                        <span class="card-title">RETURND</span>
                        <span class="card-count">4</span>
                    </div>
                    <br><br>
                    <hr>
                    <div class="card-footer">
                        <a href="Activity-Returned/Activity-Returned.php">More info</a><img src="acti-img/right.png" alt="arrow key" class="card-icons">
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="acti-img/dislike.png" alt="not returnd" class="card-icon">
                        <span class="card-title">NOT RETURNED</span>
                        <span class="card-count">1</span>
                    </div>
                    <br><br>
                    <hr>
                    <div class="card-footer">
                        <a href="Activity-Not Returned/Activity-Not Returned.php">More info</a><img src="acti-img/right.png" alt="arrow key" class="card-icons">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="card">
                    <div class="card-header">
                        <img src="acti-img/favourite.png" alt="favorit" class="card-icon">
                        <span class="card-title">FAVORITE</span>
                        <span class="card-count">3</span>
                    </div>
                    <br><br>
                    <hr>
                    <div class="card-footer">
                        <a href="Activity-Favourites/Activity-Favourites.php">More info</a><img src="acti-img/right.png" alt="arrow key" class="card-icons">
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="acti-img/bookmark.png" alt="bookmark" class="card-icon">
                        <span class="card-title">BOOK MARKS</span>
                        <span class="card-count">7</span>
                    </div>
                    <br><br>
                    <hr>
                    <div class="card-footer">
                        <a href="Activity-Bookmarks/Activity-Bookmarks.php">More info</a><img src="acti-img/right.png" alt="arrow key" class="card-icons">
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="acti-img/download (1).png" alt="download" class="card-icon">
                        <span class="card-title">DOWNLOADS</span>
                        <span class="card-count">5</span>
                    </div>
                    <br><br>
                    <hr>
                    <div class="card-footer">
                        <a href="Activity-Downloads/Activity-Downloads.php">More info</a><img src="acti-img/right.png" alt="arrow key" class="card-icons">
                    </div>
                </div>
            </div>
        </div>
        </main>
    
    <footer>
            <p>Saegis Campus</p>
            <p>No.135, S. De S. Jayasinghe Mawatha, Nugegoda, Sri Lanka.</p>
        </footer>
    </div>
    
    
</body>
</html>
