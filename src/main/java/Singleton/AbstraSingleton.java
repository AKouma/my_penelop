package Singleton;

import java.util.List;

abstract class AbstractSingleton<T> {

    public List<T> myList;

    public List<T> getMyList(){
        return myList;
    }

    public abstract void myAbstractMethod();
}
