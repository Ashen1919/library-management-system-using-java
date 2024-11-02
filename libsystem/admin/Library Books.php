<?php
// Connect to the saegislibrary database
$sa_conn = new mysqli('localhost', 'root', '', 'saegislibrary');
$table = 'books';

if ($sa_conn->connect_error) {
    die("Connection failed: " . $sa_conn->connect_error);
}

// Fetch all categories
$categories_result = $sa_conn->query("SELECT * FROM category");

if (!$categories_result) {
    die("Query failed: " . $sa_conn->error);
}

// Fetch books based on selected category
$category_filter = isset($_POST['category']) ? $_POST['category'] : '';
$books_query = $category_filter ? "SELECT * FROM books WHERE category_id = '$category_filter'" : "SELECT * FROM books";
$books_result = $sa_conn->query($books_query);

if (!$books_result) {
    die("Query failed: " . $sa_conn->error);
}

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
    <link rel="stylesheet" href="lib-style.css">

    <style>
        .books-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .books-container li {
            list-style: none;
            flex-basis: calc(20% - 40px); /* Allows for 5 books per row with a small margin */
            margin-bottom: 50px;
        }

        .book {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .hardcover_front img {
            width: 170px; /* Adjust based on your preferred size */
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
            <h1 ><a style="color: #4e4eb8;" href="Books.php">LIBRARY BOOKS</a></h1>
            <div class="search-bar">
                <form method="post" action="">
                    <select name="category" onchange="this.form.submit()">
                        <option value="">- ALL -</option>
                        <?php while ($category = $categories_result->fetch_assoc()): ?>
                            <option value="<?php echo $category['id']; ?>" <?php echo $category_filter == $category['id'] ? 'selected' : ''; ?>>
                                <?php echo $category['name']; ?>
                            </option>
                        <?php endwhile; ?>
                    </select>
                    <input type="text" placeholder="find the book you like...">
                    <button type="submit">Search</button>
                </form>
            </div>
        </header>

        <ul class="books-container">
            <?php
            if ($books_result->num_rows == 0) {
                echo "<p>No books found in the saegislibrary database.</p>";
            } else {
                while ($book = $books_result->fetch_assoc()):
            
            ?>
            <li >
                <figure class='book' >

                    <!-- Front -->
                    <ul class='hardcover_front'>
                        <li>
                            <img src="<?php echo $book['cover_page']; ?>" alt="Book Cover">
                        </li>
                        <li></li>
                    </ul>

                    <!-- Pages -->
                    <ul class='page'>
                        <li></li>
                        <li>
                            <a class="btn" href="#">View</a>
                            <a class="btn2" href="#">Download</a>
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
