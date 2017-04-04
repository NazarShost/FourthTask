package com.example.fourthtask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz extends Activity {
    protected boolean []zaznaczonyId=new boolean[5];
    protected int count =0;

    protected static final String[] Answer={"Jimmy Carr","Leslie Nielsen","Louis C.K.","Mr. Bin","George Carlin"};
    protected static final int[] idButtons={R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5};
    protected static final int[] idRadioGroup = {R.id.radioGroup1,R.id.radioGroup2, R.id.radioGroup3,R.id.radioGroup4,R.id.radioGroup5};
    protected Button [] button = new Button[idButtons.length];
    protected RadioGroup [] RadioGroup=new RadioGroup[idRadioGroup.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.quiz_name);
        Button result = (Button) findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              Toast.makeText(getApplicationContext(), "U HAVE "+ count + " SCORE!!!", Toast.LENGTH_SHORT).show();
            }
        });

        for(int i=0;i<idButtons.length;i++){
            final int b = i;
            button[b]=(Button)findViewById(idButtons[b]);
            button[b].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(zaznaczonyId[b]==true){ Toast.makeText(getApplicationContext(), "YEEAA! U GUESS +1 SCORE", Toast.LENGTH_SHORT).show(); count++;}
                    else Toast.makeText(getApplicationContext(), "OHHH. U WRONG! 0!=(", Toast.LENGTH_SHORT).show();
                    }
            });
        }
        for(int i=0;i<idRadioGroup.length;i++){
            final int b = i;
            RadioGroup[b]=(RadioGroup)findViewById(idRadioGroup[b]);
            RadioGroup[b].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                public void onCheckedChanged(RadioGroup group, int checkedId){
                    Button result = (Button) findViewById(checkedId);
                    if(result.getText().equals(Answer[b])) zaznaczonyId[b]=true;
                    else zaznaczonyId[b]=false;
                }
            });

        }
    }
}
