package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;

import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.*;




public class MainActivity extends AppCompatActivity
{

    private EditText display;
    private String strToAdd;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


        display = findViewById(R.id.textView);
        int maxTextLength = 18;
        display.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxTextLength)});
        Toast.makeText(this, "Only accept for 15 numbers", Toast.LENGTH_SHORT).show();





    display = findViewById(R.id.textView);
    display.setShowSoftInputOnFocus(false);

    display.setOnClickListener(new View.OnClickListener()
                               {

                                   public boolean onCreateOptionsMenu(Menu menu) {
                                       getMenuInflater().inflate(R.menu.main_menu, menu);
                                       return true;}


        @Override
        public void onClick(View v) {
            if (getString(R.string.display).equals(display.getText().toString()))
                display.setText("");
                                }

                               }
    );


}
    private void updateText(String strToAdd) {

        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }


         else{

                 display.setText(String.format("%s%s%s", leftStr, strToAdd,rightStr));
                 display.setSelection(cursorPos +1);

        }

    }
    public void zeroBTN(View view) {
        updateText( "0");
    }
    public void oneBTN(View view){
        updateText( "1");
    }
    public void twoBTN(View view){
        updateText( "2");
    }
    public void threeBTN(View view){
        updateText( "3");
    }
    public void fourBTN(View view){
        updateText( "4");
    }
    public void fiveBTN(View view){
        updateText( "5");
    }
    public void sixBTN(View view){
        updateText( "6");
    }
    public void sevenBTN(View view){
        updateText( "7");
    }
    public void eightBTN(View view){
        updateText( "8");
    }
    public void nineBTN(View view){
        updateText( "9");
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void equalBTN(View view){

        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷","/");
        userExp= userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void multiplyBTN(View view){
        updateText( "×");
    }
    public void addBTN(View view){
        updateText( "+");
    }
    public void substractBTN(View view){
        updateText( "-");
    }

    public void pointBTN(View view){
        updateText( ".");
    }
    public void DivideBTN(View view){
        updateText( "÷");
    }

}