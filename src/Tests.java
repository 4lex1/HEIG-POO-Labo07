import hanoi.Hanoi;
import util.Stack;

@SuppressWarnings("ThrowablePrintedToSystemOut")
public class Tests {
    public static void main(String[] args) {
        testStackWithNullElements();
        testStackPopEmpty();
        testHanoiInvalidDisksCount();
        testHanoiWithNullDisplayer();
        testStackToArrayOfObjects();
        testStackToArrayOfTWithSmallerSize();
        testStackToArrayOfTWithValidSize();
    }

    private static void testStackWithNullElements() {
        System.out.println("Testing stack with null elements:");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(null);
        stack.push(2);
        stack.push(null);
        stack.push(3);
        stack.push(null);
        stack.push(4);

        System.out.println(stack);
        System.out.println();
    }

    private static void testStackPopEmpty() {
        System.out.println("Testing pop() on empty stack:");

        Stack<Integer> stack = new Stack<>();
        try {
            stack.pop();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println();
    }

    private static void testHanoiInvalidDisksCount() {
        System.out.println("Testing hanoi(int) with invalid disks count.");

        try {
            new Hanoi(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }

    private static void testHanoiWithNullDisplayer() {
        System.out.println("Testing hanoi(int, HanoiDisplayer) with null displayer.");

        try {
            new Hanoi(2, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }

    private static void testStackToArrayOfObjects() {
        System.out.println("Testing stack.toArray().");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: " + stack);

        Object[] a = stack.toArray();
        for (Object i : a) {
            System.out.println(i);
        }

        System.out.println();
    }

    private static void testStackToArrayOfTWithSmallerSize() {
        System.out.println("Testing stack.toArray(Integer[]). Size = 1");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: " + stack);

        Integer[] tab = new Integer[1];
        tab = stack.toArray(tab);
        for (Integer i : tab) {
            System.out.println(i);
        }

        System.out.println();
    }

    private static void testStackToArrayOfTWithValidSize() {
        System.out.println("Testing stack.toArray(Integer[]). Size = 4");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: " + stack);

        Integer[] tab = new Integer[4];
        tab = stack.toArray(tab);
        for (Integer i : tab) {
            System.out.println(i);
        }

        System.out.println();
    }
}
