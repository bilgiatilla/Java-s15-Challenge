    package entity;
    import enums.Status;
    import java.time.LocalDate;

    public class Book {
        private Long bookId;
        private String title;
        private Author author;
        private Category category;
        private double price;
        private int edition;
        private Status status;
        private LocalDate dateOfPurchase;
        private MemberRecord owner;

        public Book(Long bookId, String title, Author author, Category category, double price, int edition) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.category = category;
            this.price = price;
            this.edition = edition;
            this.status = Status.AVAILABLE;
            this.dateOfPurchase = LocalDate.now();
            this.owner = null;

            author.addBook(this);
            category.addBook(this);
        }

        public Long getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public Author getAuthor() {
            return author;
        }

        public Category getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public int getEdition() {
            return edition;
        }

        public Status getStatus() {
            return status;
        }

        public MemberRecord getOwner() {
            return owner;
        }

        public void borrowBy(MemberRecord member) {
            this.owner = member;
            this.status = Status.NOT_AVAILABLE;
        }

        public void returnToLibrary () {
            this.owner = null;
            this.status = Status.AVAILABLE;
        }

        public void updateInfo (String title, double price, int edition, Category category) {
            this.title = title;
            this.price = price;
            this.edition = edition;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author.getName() + '\'' +
                    ", category=" + category.getCategoryName() +
                    ", status=" + status +
                    '}';
        }
    }
