package hanoi;

import util.*;

public class Hanoi {
    private final Stack<Integer> leftTower = new Stack<>();
    private final Stack<Integer> middleTower = new Stack<>();
    private final Stack<Integer> rightTower = new Stack<>();

    private int turn;
    private final HanoiDisplayer displayer;

    public Hanoi(int disks) {
        this(disks, new HanoiDisplayer());
    }

    public Hanoi(int disks, HanoiDisplayer displayer) {
        for (int i = disks - 1; i >= 0; --i) {
            leftTower.push(i + 1);
        }

        this.displayer = displayer;
    }

    private void solve(int n, Stack<Integer> start, Stack<Integer> end, Stack<Integer> intermediate) {
        if (n != 0) {
            solve(n - 1, start, intermediate, end);

            end.push(start.pop());

            ++this.turn;
            displayer.display(this);

            solve(n - 1, intermediate, end, start);
        }
    }

    public void solve() {
        displayer.display(this);
        int size = leftTower.size();
        solve(size, leftTower, rightTower, middleTower);
    }

    public int[][] status() {
        return new int[][]{
                asIntArray(leftTower.toArray()),
                asIntArray(middleTower.toArray()),
                asIntArray(rightTower.toArray())
        };
    }

    private static int[] asIntArray(Object[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            result[i] = (int) array[i];
        }
        return result;
    }

    public boolean finished() {
        return middleTower.size() == 0 && leftTower.size() == 0;
    }

    public int turn() {
        return turn;
    }

    public Stack<Integer> getLeftTower() {
        return leftTower;
    }

    public Stack<Integer> getMiddleTower() {
        return middleTower;
    }

    public Stack<Integer> getRightTower() {
        return rightTower;
    }
}



