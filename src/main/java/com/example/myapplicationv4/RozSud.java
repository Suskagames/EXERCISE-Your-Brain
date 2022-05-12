package com.example.myapplicationv4;

import java.util.ArrayList;
import java.util.Random;

public class RozSud {

    int[][] board;
    ArrayList<ArrayList<Object>> emptyBoxIndex;
    int selected_row;
    int selected_column;
    final int min = 1;
    final int max = 9;
    final int a = new Random().nextInt((max - min) + 1) + min;
    final int b = new Random().nextInt((max - min) + 1) + min;

    RozSud(){
        selected_row = -1;
        selected_column = -1;
        //tworzenie planszy
        board=new int [9][9];
        for (int y=0;y<9;y++){
            for (int z=0;z<9;z++){
                board[y][z]=0;
            }
        }

        for (int y=a;y<9 / 3;y++){
            for (int z=b;z<9 / 4;z++){
                final int c = new Random().nextInt((max - min) + 1) + min;
                board[y][z]=c;
            }
        }


        emptyBoxIndex = new ArrayList<>();
    }
    public void getEmptyBoxIndexs(){
        for (int y=0;y<9;y++) {
            for (int z=0; z<9;z++) {
                if (this.board[y][z] == 0) {
                    this.emptyBoxIndex.add(new ArrayList<>());
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size() - 1).add(y);
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size() - 1).add(z);
                }
            }
        }
    }
    private boolean Check(int row, int col){
        if(this.board[row][col]>0){
            for (int i=0; i<9; i++){
                if (this.board[i][col] == this.board[row][col] && row != i){
                    return false;
                }
                if (this.board[row][i] == this.board[row][col] && col != i){
                    return false;
                }
            }
            int boxRow = row/3;
            int boxCol = col/3;

            for (int y=boxRow*3; y<boxRow*3 + 3; y++){
                for (int z=boxCol*3; z<boxCol*3 + 3; z++){
                    if (this.board[y][z] == this.board[row][col] && row != y && col != z){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean rozSud(TablicaSudoku display){
        int row=-1;
        int col=-1;

        for (int y=0;y<9;y++) {
            for (int z=0; z<9; z++) {
                if (this.board[y][z]==0){
                    row=y;
                    col=z;
                    break;
                }
            }
        }
        if(row==-1 || col==-1){
            return true;
        }
        for (int i=1;i<10;i++){
            this.board[row][col]=i;
            display.invalidate();
            if (Check(row,col)){
                if(rozSud(display)){
                    return true;
                }
            }
            this.board[row][col]=0;
        }
        return false;
    }
    public void setNumberPos(int num) {
        if (this.selected_row != -1 && this.selected_column != -1) {
            if (this.board[this.selected_row - 1][this.selected_column - 1] == num) {
                this.board[this.selected_row - 1][this.selected_column - 1] = 0;
            } else {
                this.board[this.selected_row - 1][this.selected_column - 1] = num;

                //extra stuff
                if (!Check(this.selected_row - 1, this.selected_column - 1)) {
                    this.board[this.selected_row - 1][this.selected_column - 1] = -num;
                }
            }
        }
    }
    public void reset(){
        for (int y=0;y<9;y++) {
            for (int z = 0; z < 9; z++) {
                board[y][z]=0;
            }
        }
        this.emptyBoxIndex =new ArrayList<>();
    }

    public int[][] getBoard(){
        return this.board;
    }
    public ArrayList<ArrayList<Object>> getEmptyBoxIndex(){
        return  this.emptyBoxIndex;
    }
    public int getSelectedRow(){
        return selected_row;
    }
    public int getSelectedColumn(){
        return selected_column;
    }
    public void setSelectedRow(int y){
        selected_row=y;
    }
    public void setSelectedColumn(int z){
        selected_column=z;
    }
}
