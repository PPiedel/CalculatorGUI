/**
 * Created by Pawel on 2015-02-13.
 */
public class CalcModel {
    double num1, num2;
    int op;
    double res;

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public double getRes() {
        return res;
    }

    public double getNum2() {
        return num2;
    }

    public double getNum1() {
        return num1;
    }

    public int getOp() {
        return op;
    }

    public void addTwoNumbers(){
       res=num1+num2;
    }

    public void subtractTwoNumbers(){
        res=num1-num2;
    }

    public void multipleTwoNumbers(){
        res=num1*num2;
    }

    public void divideTwoNumbers(){
        res=num1/num2;
    }





}
