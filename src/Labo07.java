import hanoi.Hanoi;
import hanoi.gui.*;

public class Labo07 {
    public static void main(String[] args) {
        if (args.length == 0) {
            new JHanoi();
        } else if (args.length != 1) {
            System.out.println("Invalid usage:" +
                    "\nLabo07      - Start the Hanoi GUI solver." +
                    "\nLabo07 <n>  - Start the Hanoi Console solver with n disks.");
        } else {
            int disks = Integer.parseInt(args[0]);
            Hanoi h = new Hanoi(disks);
            h.solve();
        }
    }
}
