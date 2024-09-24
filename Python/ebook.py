class EBookReader:
    def __init__(self):
        self.books = []

    def buy_book(self, book_title):
        self.books.append(book_title)
        print(f"Successfully purchased the book: {book_title}")

    def view_purchased_books(self):
        if self.books:
            print("List of purchased books:")
            for book in self.books:
                print(book)
        else:
            print("No books purchased yet.")

    def read_book(self, book_title):
        if book_title in self.books:
            print(f"Reading book: {book_title}")
            # Here you can add code to read the content of the book from a file or online source
        else:
            print(
                f"You have not purchased the book: {book_title}. Buy it to read.")


# Sample data of publicly available books
available_books = [
    "Pride and Prejudice by Jane Austen",
    "1984 by George Orwell",
    "To Kill a Mockingbird by Harper Lee",
    "The Great Gatsby by F. Scott Fitzgerald",
    "Moby Dick by Herman Melville"
]

# Create an instance of EBookReader
reader = EBookReader()

# Simulate buying and reading books
for book in available_books:
    reader.buy_book(book)

reader.view_purchased_books()

# Simulate reading a purchased book
book_to_read = "1984 by George Orwell"
reader.read_book(book_to_read)
