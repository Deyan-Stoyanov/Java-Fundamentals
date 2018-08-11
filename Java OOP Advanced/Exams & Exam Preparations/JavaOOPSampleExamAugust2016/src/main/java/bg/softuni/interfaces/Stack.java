package bg.softuni.interfaces;

import bg.softuni.models.models.fragments.BaseFragment;

public interface Stack<T extends Fragment> extends Iterable<T>{
    Integer size();

    T push(T t);

    T pop();

    T peek();

    Boolean isEmpty();
}
