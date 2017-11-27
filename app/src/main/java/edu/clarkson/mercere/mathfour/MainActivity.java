package edu.clarkson.mercere.mathfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton bA,bB,bC,bD;
    private TextView questionBox, userPrompt;
    private MathMaker math;


    private String equation;
    private int[] options;
    private boolean correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GUI Components-----------------------------------
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        bA = (RadioButton) findViewById(R.id.A);
        bB = (RadioButton) findViewById(R.id.B);
        bC = (RadioButton) findViewById(R.id.C);
        bD = (RadioButton) findViewById(R.id.D);


        questionBox = (TextView) findViewById(R.id.QuestionBox);
        userPrompt = (TextView) findViewById(R.id.SolveStatus);

        //-------------------------------------------------

        //Math Components----------------------------------
        math = new MathMaker();
        //-------------------------------------------------



        // Everytime a Question is made and Answered

            //Shown first this when a question is prompted


        equation=math.eqn;// makes an equation "x ? y"
        options = math.options; // makes a 4 long array that is filled with numbers + or minus 2 of the answer as well as the answer. {1,2,X,4} X = 3 is the answer

        userPrompt.setText("Solve");
        questionBox.setText(equation);
        bA.setText(Integer.toString(math.options[0]));
        bB.setText(Integer.toString(math.options[1]));
        bC.setText(Integer.toString(math.options[2]));
        bD.setText(Integer.toString(math.options[3]));


        public void onRadioButtonClicked(View v){


        Log.v("od_ButtonPress",b.getText()+"pressed");

                correctAnswer = false;

                if(b.getText().equals(Integer.toString(math.ans))){
                    userPrompt.setText("Correct! The Answer was "+ math.ans);
                    Log.v("od_Correct","Right");


                    correctAnswer = true;
                }else{
                    userPrompt.setText("Incorrect. The Answer was "+ math.ans);
                    Log.v("od_Wrong","Wrong");
                }
            }
        };

    } // end of onCreate()





}
