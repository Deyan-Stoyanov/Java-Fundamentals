package problem4_book_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        this.authors.addAll(Arrays.asList(authors));
    }

    @Override
    public int compareTo(Book book) {
        if(this.getTitle().compareTo(book.getTitle()) == 0){
            if(this.getYear() > book.getYear()){
                return 1;
            } else if(this.getYear() < book.getYear()){
                return -1;
            }
            return 0;
        }
        return this.getTitle().compareTo(book.getTitle());
    }
}
