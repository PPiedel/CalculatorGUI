/**
 * Created by Pawel on 2015-02-13.
 */
public class CalcController {
    CalcModel model;
    CalcView view;

    CalcController(CalcView view,CalcModel model){
        this.view=view;
        this.model=model;
    }
}
