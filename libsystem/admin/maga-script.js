const libraryBooks = [
    { title: "IT", collection: "Collection" },
    { title: "Management", collection: "Collection" },
    { title: "English", collection: "Collection" }
];

const ebookBooks = [
    { title: "IT", collection: "Collection" },
    { title: "Management", collection: "Collection" },
    { title: "English", collection: "Collection" }
];

let currentLibraryBook = 0;
let currentEbookBook = 0;

function updateBook(section, book) {
    const bookElement = document.getElementById(`${section}-book`);
    bookElement.querySelector('.book-title').textContent = book.title;
    bookElement.nextElementSibling.textContent = book.collection;
}

function previousBook(section) {
    if (section === 'library') {
        currentLibraryBook = (currentLibraryBook - 1 + libraryBooks.length) % libraryBooks.length;
        updateBook(section, libraryBooks[currentLibraryBook]);
    } else if (section === 'ebook') {
        currentEbookBook = (currentEbookBook - 1 + ebookBooks.length) % ebookBooks.length;
        updateBook(section, ebookBooks[currentEbookBook]);
    }
}

function nextBook(section) {
    if (section === 'library') {
        currentLibraryBook = (currentLibraryBook + 1) % libraryBooks.length;
        updateBook(section, libraryBooks[currentLibraryBook]);
    } else if (section === 'ebook') {
        currentEbookBook = (currentEbookBook + 1) % ebookBooks.length;
        updateBook(section, ebookBooks[currentEbookBook]);
    }
}

function searchBooks() {
    const query = document.getElementById('search-bar').value.toLowerCase();
    const sections = document.querySelectorAll('.section');

    sections.forEach(section => {
        const bookTitleElements = section.querySelectorAll('.book-title');
        const bookContainers = section.querySelectorAll('.book-container');

        bookTitleElements.forEach((element, index) => {
            const title = element.textContent.toLowerCase();
            if (title.includes(query)) {
                bookContainers[index].style.display = 'flex';
            } else {
                bookContainers[index].style.display = 'none';
            }
        });
    });
}
