package com.example.myapplicationv4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sudoku extends AppCompatActivity {

    private TablicaSudoku gameBoard;
    private RozSud gameBoardRozSud;
    private Button odpowiedzBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudoku);
        gameBoard=findViewById(R.id.TablicaSudoku);
        gameBoardRozSud=gameBoard.getRozSud();
        odpowiedzBtn=findViewById(R.id.button11);
    }

    public void BTNJedenPress(View view){
        gameBoardRozSud.setNumberPos(1);
        gameBoard.invalidate();
    }
    public void BTNDwaPress(View view){
        gameBoardRozSud.setNumberPos(2);
        gameBoard.invalidate();
    }
    public void BTNTrzyPress(View view){
        gameBoardRozSud.setNumberPos(3);
        gameBoard.invalidate();
    }
    public void BTNCzteryPress(View view){
        gameBoardRozSud.setNumberPos(4);
        gameBoard.invalidate();
    }
    public void BTNPiecPress(View view){
        gameBoardRozSud.setNumberPos(5);
        gameBoard.invalidate();
    }
    public void BTNSzejscPress(View view){
        gameBoardRozSud.setNumberPos(6);
        gameBoard.invalidate();
    }
    public void BTNSiedemPress(View view){
        gameBoardRozSud.setNumberPos(7);
        gameBoard.invalidate();
    }
    public void BTNOsiemPress(View view){
        gameBoardRozSud.setNumberPos(8);
        gameBoard.invalidate();
    }
    public void BTNDziewiecPress(View view){
        gameBoardRozSud.setNumberPos(9);
        gameBoard.invalidate();
    }
    public void Odp(View view){
        if (odpowiedzBtn.getText().toString().equals(getString(R.string.odpowiedz))){
            odpowiedzBtn.setText(getString(R.string.wyczysc));
            gameBoardRozSud.getEmptyBoxIndexs();
            RozSudTablica rozSudTablica = new RozSudTablica();
            new Thread(rozSudTablica).start();
        } else {
            odpowiedzBtn.setText(getString(R.string.odpowiedz));
            gameBoardRozSud.reset();
        }
        gameBoard.invalidate();
    }
    class RozSudTablica implements Runnable{
        @Override
        public void run(){
            gameBoardRozSud.rozSud(gameBoard);
        }
    }
}
