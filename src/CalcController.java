import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawel on 2015-02-13.
 */
public class CalcController {
    CalcModel model;
    CalcView view;

    CalcController(CalcView view,CalcModel model){
        this.view=view;
        this.model=model;
        this.view.addActionListener(new CalcListener);
    }

    class CalcListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0;i<view.getNumberButtons().length;i++){
                if (e.getSource().equals(view.getNumberButtons()[i])){
                    view.setResFieldText(view.getResultFieldText()+ i);
                }
            }

            if (e.getSource().equals(view.getOppButtons()[0]) && ! (view.getResultField().getText().contains(".")) ){
                resultField.setText(resultField.getText()+".");
            }
            if (e.getSource().equals(oppButtons[6]) && !(resultField.getText().equals(""))){
                resultField.setText(""+-1* Double.parseDouble(resultField.getText()));
            }
            if (e.getSource().equals(oppButtons[7])){
                resultField.setText("");
            }
            if (e.getSource().equals(oppButtons[2])&& !(op==1)&& !(resultField.getText().equals(""))){
                num1=Double.parseDouble(resultField.getText());
                resultField.setText("");
                op=1;
            }
            if (e.getSource().equals(oppButtons[3])&& !(op==2)&& !(resultField.getText().equals(""))){
                num1=Double.parseDouble(resultField.getText());
                resultField.setText("");
                op=2;
            }
            if (e.getSource().equals(oppButtons[4])&& !(op==3)&& !(resultField.getText().equals(""))){
                num1=Double.parseDouble(resultField.getText());
                resultField.setText("");
                op=3;
            }
            if (e.getSource().equals(oppButtons[5])&& !(op==4)&& !(resultField.getText().equals("")) ){
                num1=Double.parseDouble(resultField.getText());
                resultField.setText("");
                op=4;
            }
            if (e.getSource().equals(oppButtons[1]) && !(op==0)){
                num2=Double.parseDouble(resultField.getText());

                switch (op){
                    case 1:
                        res=num1+num2;
                        break;
                    case 2:
                        res=num1-num2;
                        break;
                    case 3:
                        res=num1*num2;
                        break;
                    case 4:
                        res=num1/num2;
                        break;
                }
                op=0;
                resultField.setText(""+res);
            }
        }
    }
}
