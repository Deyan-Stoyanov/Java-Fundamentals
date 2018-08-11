package bg.softuni.interfaces;

public interface Manager {
    String createCore(String[] args);

    String removeCore(String[] args);

    String selectCore(String[] args);

    String attachFragment(String[] args);

    String detachFragment(String[] args);

    String status(String[] args);
}
