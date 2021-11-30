package hanoi;

public class HanoiDisplayer {
    public void display(Hanoi h) {
        if (h == null) {
            throw new RuntimeException("hanoi is null.");
        }

        System.out.println(h);
    }
}
