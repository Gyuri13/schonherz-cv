
package lottó;

import java.net.URL;
import java.util.ArrayList;
import static java.util.Arrays.fill;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class LottónézetController implements Initializable {
    
    private final int MIN=1;
    private final int MAX=90; 
    
    private int[] GenNums = new int[5];
   
    private int[] SelNums=new int[5];
    
   
    
     @FXML
    private Pane BasePane;
     
    @FXML
    private Pane AlertPane;
    
    @FXML
    private Label Label1;
   
     @FXML
    private Label Label2;
     
     @FXML
    private Label Label3;
     
     @FXML
    private Label Label4;
     
     @FXML
    private Label Label5;
     
     @FXML
    private Label eredmeny;
     
     @FXML
    private TextField Input1;
     
     @FXML
    private TextField Input2;
     
     @FXML
    private TextField Input3;
     
     @FXML
    private TextField Input4;
     
     @FXML
    private TextField Input5;
   
    
    @FXML
    private Button button;
    
    @FXML
    private Button valami;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        calculate();
 
        fill(GenNums,0);
        
        for(int a=0;a<GenNums.length;a++)
           {
            GenNums[a] = NumGenerator();
           }
 
      
        Label1.setText(String.valueOf(GenNums[0]));
        Label2.setText(String.valueOf(GenNums[1]));
        Label3.setText(String.valueOf(GenNums[2]));
        Label4.setText(String.valueOf(GenNums[3]));
        Label5.setText(String.valueOf(GenNums[4]));
        
        
        switch(Talalat()){
            case 0: eredmeny.setText("Sajnos nem nyert");
            break;
            case 1:eredmeny.setText("1 találat");
            break;
            case 2:eredmeny.setText("2 találat");
            break;
            case 3:eredmeny.setText("3 találat");
            break;
            case 4:eredmeny.setText("4 találat");
            break;
            case 5:eredmeny.setText(" U win this game");
            break;
            default:eredmeny.setText("switch");break;
        }
        
    }
    
    
     
    
    private void calculate()
    {
        try{
         SelNums[0]=Integer.parseInt(Input1.getText());
         SelNums[1]=Integer.parseInt(Input2.getText());
         SelNums[2]=Integer.parseInt(Input3.getText());
         SelNums[3]=Integer.parseInt(Input4.getText());
         SelNums[4]=Integer.parseInt(Input5.getText());
        }
        catch(Exception e){
        
            AlertPane.setVisible(true);
            BasePane.setOpacity(0.3);
            BasePane.setDisable(true);
            
       
        }
        
      
        

    }
    
    
    public void okButton()
    {
         AlertPane.setVisible(false);
            BasePane.setOpacity(1);
            BasePane.setDisable(false);
    }
    
    private int NumGenerator()
    {
       
       System.out.println("numgenerator lefutott");
        int  rand = (int) (MAX * Math.random()+MIN);
        if(rand==GenNums[0]||rand==GenNums[1]||rand==GenNums[2]||rand==GenNums[3]||rand==GenNums[4])
            return NumGenerator();
        
        return rand;
       
    }
    
    
    private int Talalat()
    {
        
      ArrayList<Integer> result=new ArrayList<Integer>();

       for(int a:SelNums) 
       {
           for(int b:GenNums)
           {    
             
               if(a==b && !result.contains(b)){result.add(b);}

           }
       }
       return result.size() ;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    
}
