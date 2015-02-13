import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalcController {
    CalcModel model;
    CalcView view;

    CalcController(CalcView view,CalcModel model){
        this.view=view;
        this.model=model;
        this.view.addActionListener(new CalcListener());
    }

    class CalcListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0;i<view.getNumberButtons().length;i++){
                if (e.getSource().equals(view.getNumberButtons()[i])){
                    view.setResFieldText(view.getResultFieldText()+i);
                }
            }

            if (e.getSource().equals(view.getOppButtons()[0]) && ! (view.getResultField().getText().contains(".")) ){
                view.setResFieldText(view.getResultFieldText() + ".");
            }
            if (e.getSource().equals(view.getOppButtons()[6]) && !(view.getResultFieldText().equals(""))){
                view.setResFieldText("" + -1 * Double.parseDouble(view.getResultFieldText()));
            }
            if (e.getSource().equals(view.getOppButtons()[7])){
                view.setResFieldText("");
            }
            if (e.getSource().equals(view.getOppButtons()[2])&& !(model.getOp()==1)&& !(view.getResultFieldText().equals(""))){
                model.setNum1(Double.parseDouble(view.getResultFieldText()));
                view.setResFieldText("");
                model.setOp(1);
            }
            if (e.getSource().equals(view.getOppButtons()[3])&& !(model.getOp()==2)&& !(view.getResultFieldText().equals(""))){
                model.setNum1(Double.parseDouble(view.getResultFieldText()));
                view.setResFieldText("");
                model.setOp(2);
            }
            if (e.getSource().equals(view.getOppButtons()[4])&& !(model.getOp()==2)&& !(view.getResultFieldText().equals(""))){
                model.setNum1(Double.parseDouble(view.getResultFieldText()));
                view.setResFieldText("");
                model.setOp(3);
            }
            if (e.getSource().equals(view.getOppButtons()[5])&& !(model.getOp()==2)&& !(view.getResultFieldText().equals(""))){
                model.setNum1(Double.parseDouble(view.getResultFieldText()));
                view.setResFieldText("");
                model.setOp(4);
            }
            if (e.getSource().equals(view.getOppButtons()[1]) && !(model.getOp()==0)){
                model.setNum2(Double.parseDouble(view.getResultFieldText()));

                switch (model.getOp()){
                    case 1:
                        model.addTwoNumbers();
                        break;
                    case 2:
                        model.subtractTwoNumbers();
                        break;
                    case 3:
                        model.multipleTwoNumbers();
                        break;
                    case 4:
                        model.divideTwoNumbers();
                        break;
                }
                model.setOp(0);
                view.setResFieldText(""+model.getRes());
            }
        }
    }
}
