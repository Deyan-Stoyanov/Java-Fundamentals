package problem2_bookshop;

public class GoldenEditionBook extends Book{
    public GoldenEditionBook(String author, String name, Double price) {
        super(author, name, price);
    }

    @Override
    public void setPrice(Double price) {
        super.setPrice(price * 1.3);
    }
}
