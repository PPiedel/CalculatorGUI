import javax.swing.*;

/**
 * Created by Pawel on 2015-02-12.
 */
public class CalcTester {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalcView calcView = new CalcView();
            }
        });
    }
}
