package hanoi;

public class HanoiDisplayer {
    public void display(Hanoi h) {
        if (h == null) {
            throw new RuntimeException("hanoi is null.");
        }

        System.out.println("--Turn: " + h.turn());
        System.out.println("One:   [ " + h.getLeftTower() + "]");
        System.out.println("Two:   [ " + h.getMiddleTower() + "]");
        System.out.println("Three: [ " + h.getRightTower() + "]");
    }
}
