package com.abdussatter.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout studentLayout, edInputLayout, tvResultLayout;
    Button btnStudent, btnGetResult, btnBack;
    EditText edName, edClass, edRoll, edID, edBangla, edEnglish, edICT, edPhysics, edChemistry, edBiology, edMathematics;
    TextView tvName, tvClass, tvRoll, tvID,
            tvGBangla, tvGEnglish, tvGICT, tvGPhysics, tvGChemistry, tvGBiology, tvGMathematics,
            tvGPBangla, tvGPEnglish, tvGPICT, tvGPPhysics, tvGPChemistry, tvGPBiology, tvGPMathematics,
            tvTotalGP, tvTotalGPA, tvGrade, tvTotalMark,tvAverageMark ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Layout--------------------------------------------
        studentLayout = findViewById(R.id.studentLayout);
        edInputLayout = findViewById(R.id.edInputLayout);
        tvResultLayout = findViewById(R.id.tvResultLayout);

        //Button--------------------------------------------
        btnStudent = findViewById(R.id.btnStudent);
        btnGetResult = findViewById(R.id.btnGetResult);
        btnBack = findViewById(R.id.btnBack);

        //Edit Text View
        edName = findViewById(R.id.edName);
        edClass = findViewById(R.id.edClass);
        edRoll = findViewById(R.id.edRoll);
        edID = findViewById(R.id.edID);

        edBangla = findViewById(R.id.edBangla);
        edEnglish = findViewById(R.id.edEnglish);
        edICT = findViewById(R.id.edICT);
        edPhysics = findViewById(R.id.edPhysics);
        edChemistry = findViewById(R.id.edChemistry);
        edBiology = findViewById(R.id.edBiology);
        edMathematics = findViewById(R.id.edMathematics);

        // Text View-------------------------------------
        tvName = findViewById(R.id.tvName);
        tvClass = findViewById(R.id.tvClass);
        tvRoll = findViewById(R.id.tvRoll);
        tvID = findViewById(R.id.tvID);

        tvGBangla = findViewById(R.id.tvGBangla);
        tvGEnglish = findViewById(R.id.tvGEnglish);
        tvGICT = findViewById(R.id.tvGICT);
        tvGPhysics = findViewById(R.id.tvGPhysics);
        tvGChemistry = findViewById(R.id.tvGChemistry);
        tvGBiology = findViewById(R.id.tvGBiology);
        tvGMathematics = findViewById(R.id.tvGMathematics);

        tvGPBangla = findViewById(R.id.tvGPBangla);
        tvGPEnglish = findViewById(R.id.tvGPEnglish);
        tvGPICT = findViewById(R.id.tvGPICT);
        tvGPPhysics = findViewById(R.id.tvGPPhysics);
        tvGPChemistry = findViewById(R.id.tvGPChemistry);
        tvGPBiology = findViewById(R.id.tvGPBiology);
        tvGPMathematics = findViewById(R.id.tvGPMathematics);

        tvTotalGP = findViewById(R.id.tvTotalGP);
        tvTotalGPA = findViewById(R.id.tvTotalGPA);
        tvGrade = findViewById(R.id.tvGrade);

        tvTotalMark = findViewById(R.id.tvTotalMark);
        tvAverageMark = findViewById(R.id.tvAverageMark);

        //Student Button----------------------------------------------------
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edName.getText().toString().length()>0 && edClass.getText().toString().length()>0
                && edRoll.getText().toString().length()>0 && edID.getText().toString().length()>0){
                    tvName.setText("Name: "+edName.getText().toString());
                    tvClass.setText("Class: "+edClass.getText().toString());
                    tvRoll.setText("Roll: "+edRoll.getText().toString());
                    tvID.setText("ID No: "+edID.getText().toString());
                    studentLayout.setVisibility(View.GONE);
                    edInputLayout.setVisibility(View.VISIBLE);
                    tvResultLayout.setVisibility(View.GONE);
                }
                else{
                    edName.setError("Please provide your name...");
                    edClass.setError("Please provide your class...");
                    edRoll.setError("Please provide your roll...");
                    edID.setError("Please provide your ID...");
                }
            }
        });

        //Get Result Button Click-----------------------------------------
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bangla------------------------------------------------------------
                if (edBangla.getText().toString().length()>0){
                    float bangla = Float.parseFloat(edBangla.getText().toString());
                    if (bangla<100 && bangla>89){
                        tvGPBangla.setText("5.0");
                        tvGBangla.setText("A+");
                    }
                    else if(bangla<90 && bangla>79){
                        tvGPBangla.setText("4.0");
                        tvGBangla.setText("A");
                    }else if(bangla<80 && bangla>69){
                        tvGPBangla.setText("3.0");
                        tvGBangla.setText("B");
                    }else if(bangla<70 && bangla>59){
                        tvGPBangla.setText("2.0");
                        tvGBangla.setText("C");
                    }else if(bangla<60 && bangla>0){
                        tvGPBangla.setText("0.0");
                        tvGBangla.setText("F");
                    }else if(bangla<0 || bangla>100){
                        tvGPBangla.setText("Invalid");
                        tvGBangla.setText("Invalid");
                    }
                }else{
                    edBangla.setError("Please enter 0-100 number");
                }

                //English------------------------------------------------------------
                if (edEnglish.getText().toString().length()>0){
                    float english = Float.parseFloat(edEnglish.getText().toString());
                    if (english<100 && english>89){
                        tvGPEnglish.setText("5.0");
                        tvGEnglish.setText("A+");
                    }
                    else if(english<90 && english>79){
                        tvGPEnglish.setText("4.0");
                        tvGEnglish.setText("A");
                    }else if(english<80 && english>69){
                        tvGPEnglish.setText("3.0");
                        tvGEnglish.setText("B");
                    }else if(english<70 && english>59){
                        tvGPEnglish.setText("2.0");
                        tvGEnglish.setText("C");
                    }else if(english<60 && english>0){
                        tvGPEnglish.setText("0.0");
                        tvGEnglish.setText("F");
                    }else if(english<0 || english>100){
                        tvGPEnglish.setText("Invalid");
                        tvGEnglish.setText("Invalid");
                    }
                }else{
                    edEnglish.setError("Please enter 0-100 number");
                }

                //ICT----------------------------------------------------------------
                if (edICT.getText().toString().length()>0){
                    float ict = Float.parseFloat(edICT.getText().toString());
                    if (ict<100 && ict>89){
                        tvGPICT.setText("5.0");
                        tvGICT.setText("A+");
                    }
                    else if(ict<90 && ict>79){
                        tvGPICT.setText("4.0");
                        tvGICT.setText("A");
                    }else if(ict<80 && ict>69){
                        tvGPICT.setText("3.0");
                        tvGICT.setText("B");
                    }else if(ict<70 && ict>59){
                        tvGPICT.setText("2.0");
                        tvGICT.setText("C");
                    }else if(ict<60 && ict>0){
                        tvGPICT.setText("0.0");
                        tvGICT.setText("F");
                    }else if(ict<0 || ict>100){
                        tvGPICT.setText("Invalid");
                        tvGICT.setText("Invalid");
                    }
                }else{
                    edICT.setError("Please enter 0-100 number");
                }

                //Physics----------------------------------------------------------------
                if (edPhysics.getText().toString().length()>0){
                    float physics = Float.parseFloat(edPhysics.getText().toString());
                    if (physics<100 && physics>89){
                        tvGPPhysics.setText("5.0");
                        tvGPhysics.setText("A+");
                    }
                    else if(physics<90 && physics>79){
                        tvGPPhysics.setText("4.0");
                        tvGPhysics.setText("A");
                    }else if(physics<80 && physics>69){
                        tvGPPhysics.setText("3.0");
                        tvGPhysics.setText("B");
                    }else if(physics<70 && physics>59){
                        tvGPPhysics.setText("2.0");
                        tvGPhysics.setText("C");
                    }else if(physics<60 && physics>0){
                        tvGPPhysics.setText("0.0");
                        tvGPhysics.setText("F");
                    }else if(physics<0 || physics>100){
                        tvGPPhysics.setText("Invalid");
                        tvGPhysics.setText("Invalid");
                    }
                }else{
                    edPhysics.setError("Please enter 0-100 number");
                }

                //Chemistry----------------------------------------------------------------
                if (edChemistry.getText().toString().length()>0){
                    float chemistry = Float.parseFloat(edChemistry.getText().toString());
                    if (chemistry<100 && chemistry>89){
                        tvGPChemistry.setText("5.0");
                        tvGChemistry.setText("A+");
                    }
                    else if(chemistry<90 && chemistry>79){
                        tvGPChemistry.setText("4.0");
                        tvGChemistry.setText("A");
                    }else if(chemistry<80 && chemistry>69){
                        tvGPChemistry.setText("3.0");
                        tvGChemistry.setText("B");
                    }else if(chemistry<70 && chemistry>59){
                        tvGPChemistry.setText("2.0");
                        tvGChemistry.setText("C");
                    }else if(chemistry<60 && chemistry>0){
                        tvGPChemistry.setText("0.0");
                        tvGChemistry.setText("F");
                    }else if(chemistry<0 || chemistry>100){
                        tvGPChemistry.setText("Invalid");
                        tvGChemistry.setText("Invalid");
                    }
                }else{
                    edChemistry.setError("Please enter 0-100 number");
                }

                //Biology----------------------------------------------------------------
                if (edBiology.getText().toString().length()>0){
                    float biology = Float.parseFloat(edBiology.getText().toString());
                    if (biology<100 && biology>89){
                        tvGPBiology.setText("5.0");
                        tvGBiology.setText("A+");
                    }
                    else if(biology<90 && biology>79){
                        tvGPBiology.setText("4.0");
                        tvGBiology.setText("A");
                    }else if(biology<80 && biology>69){
                        tvGPBiology.setText("3.0");
                        tvGBiology.setText("B");
                    }else if(biology<70 && biology>59){
                        tvGPBiology.setText("2.0");
                        tvGBiology.setText("C");
                    }else if(biology<60 && biology>0){
                        tvGPBiology.setText("0.0");
                        tvGBiology.setText("F");
                    }else if(biology<0 || biology>100){
                        tvGPBiology.setText("Invalid");
                        tvGBiology.setText("Invalid");
                    }
                }else{
                    edBiology.setError("Please enter 0-100 number");
                }

                //Mathematics----------------------------------------------------------------
                if (edMathematics.getText().toString().length()>0){
                    float mathematics = Float.parseFloat(edMathematics.getText().toString());
                    if (mathematics<100 && mathematics>89){
                        tvGPMathematics.setText("5.0");
                        tvGMathematics.setText("A+");
                    }
                    else if(mathematics<90 && mathematics>79){
                        tvGPMathematics.setText("4.0");
                        tvGMathematics.setText("A");
                    }else if(mathematics<80 && mathematics>69){
                        tvGPMathematics.setText("3.0");
                        tvGMathematics.setText("B");
                    }else if(mathematics<70 && mathematics>59){
                        tvGPMathematics.setText("2.0");
                        tvGMathematics.setText("C");
                    }else if(mathematics<60 && mathematics>0){
                        tvGPMathematics.setText("0.0");
                        tvGMathematics.setText("F");
                    }else if(mathematics<0 || mathematics>100){
                        tvGPMathematics.setText("Invalid");
                        tvGMathematics.setText("Invalid");
                    }
                }else{
                    edMathematics.setError("Please enter 0-100 number");
                }




                //Fixed Portion
                if (tvGPBangla.length()>0 && tvGPEnglish.length()>0 && tvGPICT.length()>0 && tvGPPhysics.length()>0
                        && tvGPChemistry.length()>0 && tvGPBiology.length()>0 && tvGPMathematics.length()>0){
                    //Total Result-------------------------------------------------------------------------
                    float gpBangla= Float.parseFloat(tvGPBangla.getText().toString());
                    float gpEnglish= Float.parseFloat(tvGPEnglish.getText().toString());
                    float gpICT= Float.parseFloat(tvGPICT.getText().toString());
                    float gpPhysics= Float.parseFloat(tvGPPhysics.getText().toString());
                    float gpChemistry= Float.parseFloat(tvGPChemistry.getText().toString());
                    float gpBiology= Float.parseFloat(tvGPBiology.getText().toString());
                    float gpMathematics= Float.parseFloat(tvGPMathematics.getText().toString());
                    float total = gpBangla + gpEnglish + gpICT + gpPhysics + gpChemistry + gpBiology + gpMathematics;
                    float avgGPA = total /7;
                    tvTotalGP.setText(""+total);
                    tvTotalGPA.setText(""+avgGPA);
                    if (avgGPA<6 && avgGPA>4.9){
                        tvGrade.setText("A+");
                    }else if (avgGPA<5 && avgGPA>3.9){
                        tvGrade.setText("A");
                    }else if (avgGPA<4 && avgGPA>2.9){
                        tvGrade.setText("B");
                    }else if (avgGPA<3 && avgGPA>1.9){
                        tvGrade.setText("C");
                    }else if (avgGPA<2 && avgGPA>0.0){
                        tvGrade.setText("F");
                    }
                    float bangla = Float.parseFloat(edBangla.getText().toString());
                    float english = Float.parseFloat(edEnglish.getText().toString());
                    float ict = Float.parseFloat(edICT.getText().toString());
                    float physics = Float.parseFloat(edPhysics.getText().toString());
                    float chemistry = Float.parseFloat(edChemistry.getText().toString());
                    float biology = Float.parseFloat(edBiology.getText().toString());
                    float mathematics = Float.parseFloat(edMathematics.getText().toString());
                    float totalMark = bangla + english + ict + physics + chemistry + biology + mathematics;
                    tvTotalMark.setText(""+totalMark);
                    tvAverageMark.setText(totalMark/7+"%");
                    edInputLayout.setVisibility(View.GONE);
                    tvResultLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        //Back Button Click
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edInputLayout.setVisibility(View.VISIBLE);
                tvResultLayout.setVisibility(View.GONE);
            }
        });
    }
}