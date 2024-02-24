package base_struct;

public class VectorArray<T> implements Array<T> {

    private Object[] array;
    private final int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void add(T item, int index) {
        if (size() == array.length)
            resize();
        System.arraycopy(this.array, index, this.array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        T removeItem = (T) array[index];
        System.arraycopy(this.array, index + 1, this.array, index, size - index - 1);
        size--;
        return removeItem;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + vector];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
