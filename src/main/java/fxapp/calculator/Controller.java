
package fxapp.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtResult;
    @FXML
    private Label lblNum1;

    private String op = "";
    private long num1,num2;
    private int result = 0;



    @FXML
    void clear(ActionEvent event) {
        txtResult.setText("");
        lblNum1.setText("");
        op = "";

    }

    public void number(ActionEvent event){
        String num = ((Button) event.getSource()).getText();
        txtResult.setText(txtResult.getText()+num);

    }

    public void setOp(ActionEvent event){
        String operation = ((Button) event.getSource()).getText();
        if(!operation.equals("=")){
            if(!op.equals("")){
                return;
            }

            op = operation;
            num1 = Long.parseLong(txtResult.getText());
            txtResult.setText("");
            lblNum1.setText(num1+"");

        }else{
            if(op.equals("")){
                return;
            }

            num2 = Long.parseLong(txtResult.getText());
            calculate(num1,num2, op);
            lblNum1.setText("");
            op = "";
        }

    }

    public void calculate(long n1, long n2, String op){

        switch (op){
            case "+": txtResult.setText(n1+n2+"");
            break;
            case "-": txtResult.setText(n1-n2+"");
            break;
            case "/":
                if(n2 == 0){
                    txtResult.setText("Syntax error");
                }else{
                    txtResult.setText(n1/n2+"");
                }



            break;
            case "*": txtResult.setText(n1*n2+"");
            break;

        }


    }

    @FXML
    void clicked(ActionEvent event) {
        String content = txtResult.getText();
        if(content.equals("")){

        }else{
            txtResult.setText(txtResult.getText(0, txtResult.getLength()-1));
        }

    }

}
