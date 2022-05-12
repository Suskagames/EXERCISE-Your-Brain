package com.example.myapplicationv4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

import java.util.Collections;

public class Memory extends AppCompatActivity {
    ImageView iV11, iV12,iV13,iV14,iV21,iV22,iV23,iV24,iV31,iV32,iV33,iV34,iV41,iV42,iV43,iV44,iV51,iV52,iV53,iV54,iV61,iV62,iV63,iV64;

    //array z zdjec
    Integer[] cardsArray = {1,2,3,4,5,6,7,8,9,10,11,12,101,102,103,104,105,106,107,108,109,110,111,112};

    int z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z1_1,z2_1,z3_1,z4_1,z5_1,z6_1,z7_1,z8_1,z9_1,z10_1,z11_1,z12_1;
    private Button resetBtn;
    int firstCard, secondCard;
    int clickedFirst, clicksSecond;
    int cardNumber=1;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory);
        resetBtn=findViewById(R.id.BTNreset);

        iV11=(ImageView) findViewById(R.id.iV11);
        iV12=(ImageView) findViewById(R.id.iV12);
        iV13=(ImageView) findViewById(R.id.iV13);
        iV14=(ImageView) findViewById(R.id.iV14);
        iV21=(ImageView) findViewById(R.id.iV21);
        iV22=(ImageView) findViewById(R.id.iV22);
        iV23=(ImageView) findViewById(R.id.iV23);
        iV24=(ImageView) findViewById(R.id.iV24);
        iV31=(ImageView) findViewById(R.id.iV31);
        iV32=(ImageView) findViewById(R.id.iV32);
        iV33=(ImageView) findViewById(R.id.iV33);
        iV34=(ImageView) findViewById(R.id.iV34);
        iV41=(ImageView) findViewById(R.id.iV41);
        iV42=(ImageView) findViewById(R.id.iV42);
        iV43=(ImageView) findViewById(R.id.iV43);
        iV44=(ImageView) findViewById(R.id.iV44);
        iV51=(ImageView) findViewById(R.id.iV51);
        iV52=(ImageView) findViewById(R.id.iV52);
        iV53=(ImageView) findViewById(R.id.iV53);
        iV54=(ImageView) findViewById(R.id.iV54);
        iV61=(ImageView) findViewById(R.id.iV61);
        iV62=(ImageView) findViewById(R.id.iV62);
        iV63=(ImageView) findViewById(R.id.iV63);
        iV64=(ImageView) findViewById(R.id.iV64);

        iV11.setTag("0");
        iV12.setTag("1");
        iV13.setTag("2");
        iV14.setTag("3");
        iV21.setTag("4");
        iV22.setTag("5");
        iV23.setTag("6");
        iV24.setTag("7");
        iV31.setTag("8");
        iV32.setTag("9");
        iV33.setTag("10");
        iV34.setTag("11");
        iV41.setTag("12");
        iV42.setTag("13");
        iV43.setTag("14");
        iV44.setTag("15");
        iV51.setTag("16");
        iV52.setTag("17");
        iV53.setTag("18");
        iV54.setTag("19");
        iV61.setTag("20");
        iV62.setTag("21");
        iV63.setTag("22");
        iV64.setTag("23");

        //wczytanie obrazu w karty
        frontOfCardsResources();
        //pomieszanie obrazow
        Collections.shuffle(Arrays.asList(cardsArray));



        iV11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV11, theCard);
            }
        });
        iV12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV12, theCard);
            }
        });
        iV13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV13, theCard);
            }
        });
        iV14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV14, theCard);
            }
        });
        iV21.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV21, theCard);
            }
        });
        iV22.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV22, theCard);
            }
        });
        iV23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV23, theCard);
            }
        });
        iV24.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV24, theCard);
            }
        });
        iV31.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV31, theCard);
            }
        });
        iV32.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV32, theCard);
            }
        });
        iV33.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV33, theCard);
            }
        });
        iV34.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV34, theCard);
            }
        });
        iV41.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV41, theCard);
            }
        });
        iV42.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV42, theCard);
            }
        });
        iV43.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV43, theCard);
            }
        });
        iV44.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV44, theCard);
            }
        });
        iV51.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV51, theCard);
            }
        });
        iV52.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV52, theCard);
            }
        });
        iV53.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV53, theCard);
            }
        });
        iV54.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV54, theCard);
            }
        });
        iV61.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV61, theCard);
            }
        });
        iV62.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV62, theCard);
            }
        });
        iV63.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV63, theCard);
            }
        });
        iV64.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iV64, theCard);
            }
        });
    }
    public void resetMemory(View view){
        if (resetBtn.getText().toString().equals(getString(R.string.NowaGra))){
            resetBtn.setText(getString(R.string.RESET));
            Intent intent = new Intent(getApplicationContext(),Memory.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(getApplicationContext(),Memory.class);
            startActivity(intent);
            finish();
        }
    }
    private void doStuff(ImageView iV,int card){
        //ustawienie odpowiednich obrazow  w imageview
        if(cardsArray[card] == 1){
            iV.setImageResource(z1);
        } else if (cardsArray[card] == 2){
            iV.setImageResource(z2);
        } else if (cardsArray[card] == 3){
            iV.setImageResource(z3);
        } else if (cardsArray[card] == 4){
            iV.setImageResource(z4);
        } else if (cardsArray[card] == 5){
            iV.setImageResource(z5);
        }else if (cardsArray[card] == 6){
            iV.setImageResource(z6);
        } else if (cardsArray[card] == 7){
            iV.setImageResource(z7);
        } else if (cardsArray[card] == 8){
            iV.setImageResource(z8);
        } else if (cardsArray[card] == 9){
            iV.setImageResource(z9);
        } else if (cardsArray[card] == 10){
            iV.setImageResource(z10);
        } else if (cardsArray[card] == 11){
            iV.setImageResource(z11);
        } else if (cardsArray[card] == 12){
            iV.setImageResource(z12);
        } else if (cardsArray[card] == 101){
            iV.setImageResource(z1_1);
        } else if (cardsArray[card] == 102){
            iV.setImageResource(z2_1);
        } else if (cardsArray[card] == 103){
            iV.setImageResource(z3_1);
        } else if (cardsArray[card] == 104){
            iV.setImageResource(z4_1);
        } else if (cardsArray[card] == 105){
            iV.setImageResource(z5_1);
        } else if (cardsArray[card] == 106){
            iV.setImageResource(z6_1);
        } else if (cardsArray[card] == 107){
            iV.setImageResource(z7_1);
        } else if (cardsArray[card] == 108){
            iV.setImageResource(z8_1);
        } else if (cardsArray[card] == 109){
            iV.setImageResource(z9_1);
        } else if (cardsArray[card] == 110){
            iV.setImageResource(z10_1);
        } else if (cardsArray[card] == 111){
            iV.setImageResource(z11_1);
        } else if (cardsArray[card] == 112){
            iV.setImageResource(z12_1);
        }

        //spawdzanie ktory obraz jest wybrany i zapisanie jego warotsci
        if(cardNumber == 1){
           firstCard = cardsArray[card];
           if(firstCard > 100){
               firstCard = firstCard -100;
           }
           cardNumber = 2;
           clickedFirst = card;
           iV.setEnabled(false);
        } else if(cardNumber == 2){
            secondCard = cardsArray[card];
            if(secondCard > 100){
                secondCard = secondCard -100;
            }
            cardNumber = 1;
            clicksSecond = card;
            iV11.setEnabled(false);
            iV12.setEnabled(false);
            iV13.setEnabled(false);
            iV14.setEnabled(false);
            iV21.setEnabled(false);
            iV22.setEnabled(false);
            iV23.setEnabled(false);
            iV24.setEnabled(false);
            iV31.setEnabled(false);
            iV32.setEnabled(false);
            iV33.setEnabled(false);
            iV34.setEnabled(false);
            iV41.setEnabled(false);
            iV42.setEnabled(false);
            iV43.setEnabled(false);
            iV44.setEnabled(false);
            iV51.setEnabled(false);
            iV52.setEnabled(false);
            iV53.setEnabled(false);
            iV54.setEnabled(false);
            iV61.setEnabled(false);
            iV62.setEnabled(false);
            iV63.setEnabled(false);
            iV64.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed((Runnable) this::calculate, 1000 );
        }
    }
    public void calculate(){
        //spawdzanie czy obrazy sa takie same
        if(firstCard == secondCard){
            if(clickedFirst==0){
                iV11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst==1) {
                iV12.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==2) {
                iV13.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==3) {
                iV14.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==4) {
                iV21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst==5) {
                iV22.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==6) {
                iV23.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==7) {
                iV24.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==8) {
                iV31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst==9) {
                iV32.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==10) {
                iV33.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==11) {
                iV34.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==12) {
                iV41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst==13) {
                iV42.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==14) {
                iV43.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==15) {
                iV44.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==16) {
                iV51.setVisibility(View.INVISIBLE);
            } else if (clickedFirst==17) {
                iV52.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==18) {
                iV53.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==19) {
                iV54.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==20) {
                iV61.setVisibility(View.INVISIBLE);
            } else if (clickedFirst==21) {
                iV62.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==22) {
                iV63.setVisibility(View.INVISIBLE);
            } else if(clickedFirst==23) {
                iV64.setVisibility(View.INVISIBLE);
            }

            if(clicksSecond==0){
                iV11.setVisibility(View.INVISIBLE);
            } else if (clicksSecond==1) {
                iV12.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==2) {
                iV13.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==3) {
                iV14.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==4) {
                iV21.setVisibility(View.INVISIBLE);
            } else if (clicksSecond==5) {
                iV22.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==6) {
                iV23.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==7) {
                iV24.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==8) {
                iV31.setVisibility(View.INVISIBLE);
            } else if (clicksSecond==9) {
                iV32.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==10) {
                iV33.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==11) {
                iV34.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==12) {
                iV41.setVisibility(View.INVISIBLE);
            } else if (clicksSecond==13) {
                iV42.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==14) {
                iV43.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==15) {
                iV44.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==16) {
                iV51.setVisibility(View.INVISIBLE);
            } else if (clicksSecond==17) {
                iV52.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==18) {
                iV53.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==19) {
                iV54.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==20) {
                iV61.setVisibility(View.INVISIBLE);
            } else if (clicksSecond==21) {
                iV62.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==22) {
                iV63.setVisibility(View.INVISIBLE);
            } else if(clicksSecond==23) {
                iV64.setVisibility(View.INVISIBLE);
            }
        } else {
           iV11.setImageResource(R.drawable.z0);
           iV12.setImageResource(R.drawable.z0);
           iV13.setImageResource(R.drawable.z0);
           iV14.setImageResource(R.drawable.z0);
           iV21.setImageResource(R.drawable.z0);
           iV22.setImageResource(R.drawable.z0);
           iV23.setImageResource(R.drawable.z0);
           iV24.setImageResource(R.drawable.z0);
           iV31.setImageResource(R.drawable.z0);
           iV32.setImageResource(R.drawable.z0);
           iV33.setImageResource(R.drawable.z0);
           iV34.setImageResource(R.drawable.z0);
           iV41.setImageResource(R.drawable.z0);
           iV42.setImageResource(R.drawable.z0);
           iV43.setImageResource(R.drawable.z0);
           iV44.setImageResource(R.drawable.z0);
           iV51.setImageResource(R.drawable.z0);
           iV52.setImageResource(R.drawable.z0);
           iV53.setImageResource(R.drawable.z0);
           iV54.setImageResource(R.drawable.z0);
           iV61.setImageResource(R.drawable.z0);
           iV62.setImageResource(R.drawable.z0);
           iV63.setImageResource(R.drawable.z0);
           iV64.setImageResource(R.drawable.z0);
        }
        iV11.setEnabled(true);
        iV12.setEnabled(true);
        iV13.setEnabled(true);
        iV14.setEnabled(true);
        iV21.setEnabled(true);
        iV22.setEnabled(true);
        iV23.setEnabled(true);
        iV24.setEnabled(true);
        iV31.setEnabled(true);
        iV32.setEnabled(true);
        iV33.setEnabled(true);
        iV34.setEnabled(true);
        iV41.setEnabled(true);
        iV42.setEnabled(true);
        iV43.setEnabled(true);
        iV44.setEnabled(true);
        iV51.setEnabled(true);
        iV52.setEnabled(true);
        iV53.setEnabled(true);
        iV54.setEnabled(true);
        iV61.setEnabled(true);
        iV62.setEnabled(true);
        iV63.setEnabled(true);
        iV64.setEnabled(true);

        //sprawdzenie czy jest koniec gry
        chcecEnd();
    }
    private void chcecEnd(){
        if(iV11.getVisibility() == View.INVISIBLE &&
                iV12.getVisibility() == View.INVISIBLE &&
                iV13.getVisibility() == View.INVISIBLE &&
                iV14.getVisibility() == View.INVISIBLE &&
                iV21.getVisibility() == View.INVISIBLE &&
                iV22.getVisibility() == View.INVISIBLE &&
                iV23.getVisibility() == View.INVISIBLE &&
                iV24.getVisibility() == View.INVISIBLE &&
                iV31.getVisibility() == View.INVISIBLE &&
                iV32.getVisibility() == View.INVISIBLE &&
                iV33.getVisibility() == View.INVISIBLE &&
                iV34.getVisibility() == View.INVISIBLE &&
                iV41.getVisibility() == View.INVISIBLE &&
                iV42.getVisibility() == View.INVISIBLE &&
                iV43.getVisibility() == View.INVISIBLE &&
                iV44.getVisibility() == View.INVISIBLE &&
                iV51.getVisibility() == View.INVISIBLE &&
                iV52.getVisibility() == View.INVISIBLE &&
                iV53.getVisibility() == View.INVISIBLE &&
                iV54.getVisibility() == View.INVISIBLE &&
                iV61.getVisibility() == View.INVISIBLE &&
                iV62.getVisibility() == View.INVISIBLE &&
                iV63.getVisibility() == View.INVISIBLE &&
                iV64.getVisibility() == View.INVISIBLE){

            resetBtn.setText(getString(R.string.NowaGra));
        }
    }
    private void frontOfCardsResources(){
        z1=R.drawable.z1;
        z2=R.drawable.z2;
        z3=R.drawable.z3;
        z4=R.drawable.z4;
        z5=R.drawable.z5;
        z6=R.drawable.z6;
        z7=R.drawable.z7;
        z8=R.drawable.z8;
        z9=R.drawable.z9;
        z10=R.drawable.z10;
        z11=R.drawable.z11;
        z12=R.drawable.z12;
        z1_1=R.drawable.z1_1;
        z2_1=R.drawable.z2_1;
        z3_1=R.drawable.z3_1;
        z4_1=R.drawable.z4_1;
        z5_1=R.drawable.z5_1;
        z6_1=R.drawable.z6_1;
        z7_1=R.drawable.z7_1;
        z8_1=R.drawable.z8_1;
        z9_1=R.drawable.z9_1;
        z10_1=R.drawable.z10_1;
        z11_1=R.drawable.z11_1;
        z12_1=R.drawable.z12_1;
    }
}

