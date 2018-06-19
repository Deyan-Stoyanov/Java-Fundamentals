package problem2_bookshop;

public class Book {
    private String author;
    private String title;
    private Double price;


    public Book() {
    }

    public Book(String author, String title, Double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.matches("[A-Z][a-z]+\\s[0-9][a-zA-Z]+")) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(String.format("%.1f", this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();

    }
}
