package problem4_book_comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    public BookComparator() {
    }

    @Override
    public int compare(Book firstBook, Book secondBook) {
        if(firstBook.getTitle().compareTo(secondBook.getTitle()) == 0){
            if(firstBook.getYear() > secondBook.getYear()){
                return 1;
            } else if(firstBook.getYear() < secondBook.getYear()){
                return -1;
            }
            return 0;
        }
        return firstBook.getTitle().compareTo(secondBook.getTitle());
    }
}
