package generics;

abstract class GenericWithCreator<T> {

    protected T element;

    public GenericWithCreator() {
        element = create();
    }

    protected abstract T create();

}

class X {
}

class Creator extends GenericWithCreator<X> {

    @Override
    protected X create() {
        return new X();
    }

}