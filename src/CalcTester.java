import javax.swing.*;

/**
 * Created by Pawel on 2015-02-12.
 * MVC Calculator with GUI.
 */
public class CalcTester {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalcView calcView = new CalcView();
                CalcModel calcModel = new CalcModel();
                CalcController calcController =new CalcController(calcView,calcModel);
            }
        });
    }
}
