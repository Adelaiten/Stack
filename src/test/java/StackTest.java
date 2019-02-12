import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {


    @Test
    public void checkPopMethod() throws StackOverflowException, TooLowSizeException, StackUnderflowException {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        int poppedItem = stack.pop();
        assertEquals(20, poppedItem);
        poppedItem = stack.pop();
        assertEquals(15, poppedItem);
    }

    @Test
    public void checkIfZeroThrowsTooLowSizeException() {
        assertThrows(TooLowSizeException.class, () -> new Stack<Integer>(0));
    }

    @Test
    public void checkIfLowerThanZeroThrowsTooLowSizeException() {
        assertThrows(TooLowSizeException.class, () -> new Stack<Integer>(-5));
    }

    @Test
    public void checkPopMethodThrowsStackUnderflowException() throws TooLowSizeException {
        Stack<Integer> stack = new Stack<>(10);
        assertThrows(StackUnderflowException.class, () -> stack.pop());

    }

    @Test
    public void checkPopMethodThrowsStackOverflowException() throws StackOverflowException, TooLowSizeException {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(1);
        assertThrows(StackOverflowException.class, () -> stack.push(2));
    }

    @Test
    public void checkIfPeekReturnsRightValue() throws TooLowSizeException, StackOverflowException {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertAll(
                () -> assertEquals(3, (int) stack.peek()),
                () -> assertEquals(3, (int) stack.peek())
        );
    }

    @Test
    public void checkMaximumCapacity() throws TooLowSizeException {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(5, stack.getMaximumCapacity());
    }

    @Test
    public void checkSpaceLeft() throws TooLowSizeException, StackOverflowException {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        assertEquals(3, stack.getSpaceLeft());
    }

}


