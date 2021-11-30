package hanoi;

import util.*;

import java.security.InvalidParameterException;

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
        if (disks < 1){
            throw new InvalidParameterException("Invalid parameter: disks should be greater than or equal to 1.");
        }

        if (displayer == null){
            throw new InvalidParameterException("Invalid parameter: displayer cannot be null.");
        }

        for (int i = disks; i > 0; --i) {
            leftTower.push(i);
        }

        this.displayer = displayer;
    }

    private void solve(int n, Stack<Integer> start, Stack<Integer> end, Stack<Integer> intermediate) {
        if (n == 0) {
            return;
        }

        solve(n - 1, start, intermediate, end);

        end.push(start.pop());

        ++turn;
        displayer.display(this);

        solve(n - 1, intermediate, end, start);
    }

    public void solve() {
        displayer.display(this);
        solve(leftTower.size(), leftTower, rightTower, middleTower);
    }

    public int[][] status() {
        return new int[][]{
                asIntArray(leftTower.toArray()),
                asIntArray(middleTower.toArray()),
                asIntArray(rightTower.toArray())
        };
    }

    public int turn() {
        return turn;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--Turn: ").append(turn).append("\n");
        sb.append("One:   ").append(leftTower).append("\n");
        sb.append("Two:   ").append(middleTower).append("\n");
        sb.append("Three: ").append(rightTower);
        return sb.toString();
    }
}



