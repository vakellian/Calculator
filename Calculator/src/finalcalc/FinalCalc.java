package finalcalc;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FinalCalc extends Application {
    static ArrayList<Button> buttons = new ArrayList<>();
    double [] storage = new double[100];
    int activeBuffer = 0;
    String tempStorage = "";
    String operator = "";
    double finalNumber = 0;
    private double x;
    private double y;
      
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 245, 415);
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Lato");
        scene.getStylesheets().add(FinalCalc.class.getResource("calc_css_9.css").toExternalForm());
        pane.setStyle("-fx-background-color: black");
 /*----------------------- Calculator Screen -----------------------------*/

        
        TextField text = new TextField();
        text.setLayoutX(10);
        text.setLayoutY(5);
        text.setPrefWidth(235);
        text.setPrefHeight(50);
        text.setAlignment(Pos.BASELINE_LEFT);
        text.getStyleClass().add("window");
        
 /*-----------------------Buttons-----------------------------------------*/ 
       Button bNegative = new Button("(+/-)");
        buttons.add(bNegative);
       Button b0 = new Button("0");
        buttons.add(b0);
       Button bDecimal = new Button(".");
        buttons.add(bDecimal);
       Button bEquals = new Button("=");
        buttons.add(bEquals);
        bEquals.setId("equals");
       Button b1 = new Button("1");
        buttons.add(b1);
       Button b2 = new Button("2");
        buttons.add(b2);
       Button b3 = new Button("3");
        buttons.add(b3); 
       Button bPlus = new Button("+");
        buttons.add(bPlus); 
        bPlus.getStyleClass().add("operands");
       Button b4 = new Button("4");
        buttons.add(b4);
       Button b5 = new Button("5");
        buttons.add(b5);
       Button b6 = new Button("6");
        buttons.add(b6);
       Button bMinus = new Button("-");
        buttons.add(bMinus);
        bMinus.getStyleClass().add("operands");
       Button b7 = new Button("7");
        buttons.add(b7);
       Button b8 = new Button("8");
        buttons.add(b8);
       Button b9 = new Button("9");
        buttons.add(b9);
       Button bMultiply = new Button("x");
        buttons.add(bMultiply);
        bMultiply.getStyleClass().add("operands");
       Button bSqRt = new Button("sqrt");
        buttons.add(bSqRt);
       Button bLogTwo = new Button("log2");
        buttons.add(bLogTwo);
       Button bLogTen = new Button("log10");
        buttons.add(bLogTen);
       Button bDivide = new Button("/");
        buttons.add(bDivide);
        bDivide.getStyleClass().add("operands");
       Button bSin = new Button("sin");
        buttons.add(bSin);
       Button bCos = new Button("cos");
        buttons.add(bCos);
       Button bExp = new Button("^");
        buttons.add(bExp);
       Button bClear = new Button("AC");
        buttons.add(bClear);
        bClear.setId("clear");
       
        
        placeButtons(buttons); //placing buttons on the calculator
        pane.getChildren().addAll(text,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPlus,bMinus,bEquals,bDivide,bMultiply,bDecimal, bSqRt, bCos,bSin,bExp,bLogTwo,bLogTen, bClear,bNegative);
        primaryStage.setTitle("Calc");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
 /*--------------------Events---------------------------------*/
        b0.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage+= 0;
                text.setText(tempStorage);
                }
        });
        
         b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
               tempStorage += "1";
               text.setText(tempStorage);
                }
        });
       
        b2.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "2";
                text.setText(tempStorage);
                }
        });
        
         
          b3.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "3";
                text.setText(tempStorage);
                }
        });
          
          b4.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "4";
                text.setText(tempStorage);
                }
        });
           
          b5.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "5";
                text.setText(tempStorage);
                }
        });
            
           b6.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "6";
                text.setText(tempStorage);
                }
        });
             
          b7.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "7";
                text.setText(tempStorage);
                }
        });
              
         b8.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "8";
                text.setText(tempStorage);
                }
        });
         
       b9.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                tempStorage += "9";
                text.setText(tempStorage);
                }
        });
       
       bDecimal.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                if(find(tempStorage,'.') != true){
                    tempStorage += ".";
                    text.setText(tempStorage);
                }
            }
             
                 
        });
       
        bPlus.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != ""&& operator==""){   
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                tempStorage = "";
                activeBuffer++;
                operator = "+";
                text.setText("+");
            }
            else if(operator == "+"){
                return;
            }
            else
                text.setText("ERROR");
                }
                
        });
      
      bMinus.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != ""&& operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                tempStorage = "";
                activeBuffer++;
                operator = "-"; 
                text.setText("-");
            }
            else if(operator == "-"){
                return;
            }
            else
                text.setText("ERROR");
                }
        });
      
      bDivide.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != ""&& operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                tempStorage = "";
                activeBuffer++;
                operator = "/"; 
                text.setText("/");
                }
            else if(operator == "/"){
                return;
            }
            else
             text.setText("ERROR");
                }
        });
      
      bMultiply.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != ""&& operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                tempStorage = "";
                activeBuffer++;
                operator = "x"; 
                text.setText("x");
            }
            else if(operator == "x"){
                return;
            }
            else
                text.setText("ERROR");
                }
        });
      
      bSqRt.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != ""&& operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                double square = Math.sqrt(storage[activeBuffer]);
                text.setText(Double.toString(square));
                tempStorage = Double.toString(square);
                activeBuffer++;
            }
            else
                text.setText("ERROR");
                }
        });
      
      
      
      bCos.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != "" && operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                double cos = Math.cos(Math.toRadians(storage[activeBuffer]));
                //System.out.println(cos);
                if(Math.abs(cos) < 0.00000000001)
                {
                   cos = 0.0; 
                } 
                System.out.println(cos);
                text.setText(Double.toString(cos));   
                tempStorage = Double.toString(cos);
                activeBuffer++; 
                }
            else
                text.setText("ERROR");
                }
        });
      
      bSin.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != "" && operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                double sin = Math.sin(Math.toRadians(storage[activeBuffer]));
                if(Math.abs(sin) < 0.00000001)
                {
                   sin = 0.0; 
                } 
                text.setText(Double.toString(sin));
                tempStorage = Double.toString(sin);
                activeBuffer++;
            }
            else
                text.setText("ERROR");
                }
        });
      
      bLogTwo.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != "" && operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                double logTwo = Math.log(storage[activeBuffer])/Math.log(2);
                text.setText(Double.toString(logTwo));
                tempStorage = Double.toString(logTwo);
                activeBuffer++;
                }
            else
                text.setText("ERROR");
                }
        });
      
      bLogTen.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != "" && operator ==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                double logTen = Math.log10(storage[activeBuffer]);
                text.setText(Double.toString(logTen));
                tempStorage = Double.toString(logTen);
                activeBuffer++;
                }
            else
                text.setText("ERROR");
                }
        });
      
      bExp.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != "" && operator==""){
                storage[activeBuffer] = Double.parseDouble(tempStorage);
                tempStorage = "";
                activeBuffer++;
                operator = "^"; 
                text.setText("^");
                }
            else
                text.setText("ERROR");
                }
        });
      
      bClear.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                activeBuffer = 0;
                tempStorage = "";
                operator = "";
                finalNumber = 0;
                text.setText(" ");
                }
        });
      
      bNegative.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            if(tempStorage != ""){
                double tempNum = Double.parseDouble(tempStorage);
                double x = tempNum * -1;
                String tempString = Double.toString(x);
                tempStorage = tempString;
                text.setText(tempStorage);
            }
            else{
                   text.setText("ERROR");     
                        }       
                }
                
        });
      
       bEquals.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                storage[activeBuffer]= Double.parseDouble(tempStorage);
                tempStorage ="";
          
            if(operator == "+"){
                finalNumber = storage[activeBuffer-1]+storage[activeBuffer];
                    text.setText(Double.toString(finalNumber));
                }
            else if(operator == "-"){
                finalNumber = storage[activeBuffer-1] - storage[activeBuffer];
                    text.setText(Double.toString(finalNumber));
                }
            else if(operator == "x"){
                finalNumber = storage[activeBuffer-1] * storage[activeBuffer];
                text.setText(Double.toString(finalNumber));
                }
            else if(operator == "/"){
                if(storage[activeBuffer] != 0){
                    finalNumber = storage[activeBuffer-1] / storage[activeBuffer];
                    text.setText(Double.toString(finalNumber));
                }
                else
                    text.setText("CANNOT DIVIDE BY ZERO");
                }
            else if(operator == "^"){
                finalNumber = Math.pow(storage[activeBuffer-1], storage[activeBuffer]);
                text.setText(Double.toString(finalNumber));
                }
                tempStorage = Double.toString(finalNumber);
                activeBuffer++;
                operator="";
                }
        });
               
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static void modButtons(Button button, int x, int y){
        button.setPrefSize(55.00,55.00);
        button.setLayoutX(x);
        button.setLayoutY(y);
        
    }
    public static void placeButtons(ArrayList<Button> list){
        int count = 0;
        int x = 10;
        int y = 365;
        for(int i=0;i<24;i++){
            if(count < 3){
                modButtons(buttons.get(i),x,y);
                x+=60;
                count++;
            }
            else{
                modButtons(buttons.get(i),x,y);
                x =10;
                y -= 60;
                count=0; 
            }
            
        }
    }
    
    public static boolean find(String list, char a){
        boolean isDec = false;
        for(int i = 0; i<list.length();i++){
            if(list.charAt(i) == a){
                isDec = true;
            } 
    }
        return isDec;
    
}
}