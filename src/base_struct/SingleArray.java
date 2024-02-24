package base_struct;

public class SingleArray<T> implements Array<T> {
    private Object[] array;

    public SingleArray() {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void add(T item, int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        System.arraycopy(array, index, newArray, index + 1, size()  - index);
        array = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index >= size() || index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        Object[] newArray = new Object[size() - 1];
        T removeItem = (T) array[index];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);
        array = newArray;
        return removeItem;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}
