package Modules;

import java.util.List;

abstract class AbstractModuleSingleton<T> {

    public List<T> myList;

    public List<T> getMyList(){
        return myList;
    }

    public abstract void myAbstractMethod();
}
