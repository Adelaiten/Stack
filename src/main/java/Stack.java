
public class Stack<T> {
    private T[] stack;
    private int maximumCapacity;
    private int index;


    private Stack() {

    }

    public Stack(int size) throws TooLowSizeException{
        if(size <= 0) {
            throw new TooLowSizeException("Size of stack is too low!");
        }
        this.stack = (T[]) new Object[size];
        this.maximumCapacity = size;
        this.index = 0;
    }


    public void push(T item) throws StackOverflowException{
        if(index == maximumCapacity) {
            throw new StackOverflowException("Stack overflow!");
        }

        this.stack[index++] = item;
    }


    public T pop() throws StackUnderflowException{
        if(index == 0) {
            throw new StackUnderflowException("Stack underflow!");
        }
        T poppedItem = this.stack[(index-1)];
        this.stack[(index-1)] = null;
        index--;
        return poppedItem;
    }


    public T peek() {
        return stack[(index-1)];
    }


    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }


    public int getSpaceLeft() {
        return this.maximumCapacity - index;
    }
}
