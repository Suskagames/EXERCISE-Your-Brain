package com.example.myapplicationv4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TablicaSudoku extends View{
    private final int boardColor;
    private final int cellFillColor;
    private final int cellHighlightColor;
    private final int letterColor;
    private final int letterColorRozSud;
    private final int letterColorError;
    private final Paint boardColorPaint = new Paint();
    private final Paint cellFillColorPaint = new Paint();
    private final Paint cellHighlightColorPaint = new Paint();
    private int cellSize;
    private final Paint letterPaint=new Paint();
    private final Rect letterPaintBounds=new Rect();
    private final RozSud rozSud = new RozSud();


    public TablicaSudoku(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TablicaSudoku, 0,0 );

        try{
            boardColor=a.getInteger(R.styleable.TablicaSudoku_boardColor,0);
            cellFillColor=a.getInteger(R.styleable.TablicaSudoku_cellFillColor,0);
            cellHighlightColor=a.getInteger(R.styleable.TablicaSudoku_cellHighlightColor,0);
            letterColor=a.getInteger(R.styleable.TablicaSudoku_letterColor,0);
            letterColorRozSud=a.getInteger(R.styleable.TablicaSudoku_letterColorRozSud,0);
            letterColorError = a.getInteger(R.styleable.TablicaSudoku_letterColorError, 0);
        }finally{
            a.recycle();
        }
    }
    //Sworzenie idealnego wymiaru
    @Override
    protected void onMeasure(int width, int height){
        super.onMeasure(width,height);

        int dimension = Math.min(this.getMeasuredWidth(),this.getMeasuredHeight());
        //male kwadraciki
        cellSize = dimension/9;

        setMeasuredDimension(dimension,dimension);
    }

    @Override
    protected void onDraw(Canvas canvas){
        //kolor tablicy
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(16);
        boardColorPaint.setColor(boardColor);
        boardColorPaint.setAntiAlias(true);
        //kolor kwadracikow
        cellFillColorPaint.setStyle(Paint.Style.FILL);
        cellFillColorPaint.setAntiAlias(true);
        cellFillColorPaint.setColor(cellFillColor);
        //kolor klikniecia
        cellHighlightColorPaint.setStyle(Paint.Style.FILL);
        cellHighlightColorPaint.setAntiAlias(true);
        cellHighlightColorPaint.setColor(cellHighlightColor);

        letterPaint.setStyle(Paint.Style.FILL);
        letterPaint.setAntiAlias(true);
        letterPaint.setColor(letterColor);


        colorCell(canvas,rozSud.getSelectedRow(),rozSud.getSelectedColumn());
        canvas.drawRect(0,0,getWidth(),getHeight(),boardColorPaint);
        drawBoard(canvas);
        drawNumbers(canvas);
    }
    private void drawThickLine(){
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(10);
        boardColorPaint.setColor(boardColor);
    }
    private void drawThinLine(){
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(4);
        boardColorPaint.setColor(boardColor);
    }
    private void drawBoard(Canvas canvas){
        //tworzenie wierszy i kolumn lini
        //kolmny
        for (int z=0; z<10;z++){
            if(z%3==0){
                drawThickLine();
            } else{
                drawThinLine();
            }
            canvas.drawLine(cellSize*z,0,cellSize*z,getWidth(),boardColorPaint);
        }
        //wiersze
        for (int y=0;y<10;y++){
            if(y%3==0){
                drawThickLine();
            } else{
                drawThinLine();
            }
            canvas.drawLine(0,cellSize*y,getWidth(),cellSize*y,boardColorPaint);
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){
        boolean isValid;

        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();

        if (action==MotionEvent.ACTION_DOWN){
            rozSud.setSelectedRow((int)Math.ceil(y/cellSize));
            rozSud.setSelectedColumn((int)Math.ceil(x/cellSize));
            isValid=true;
        } else{
            isValid=false;
        }


        return isValid;
    }
    private void colorCell(Canvas canvas, int y,int z){
        if(rozSud.getSelectedColumn()!=-1 && rozSud.getSelectedRow() !=-1){
            canvas.drawRect((z-1)*cellSize,0,z*cellSize,cellSize*9,cellFillColorPaint);
            canvas.drawRect(0,(y-1)*cellSize,cellSize*9,y*cellSize,cellFillColorPaint);
            canvas.drawRect((z-1)*cellSize,(y-1)*cellSize,cellSize*z,y*cellSize,cellHighlightColorPaint);
        }
        //odświerzenie
        invalidate();
    }
    private  void drawNumbers(Canvas canvas){
        letterPaint.setTextSize(cellSize);
        for(int y=0;y<9;y++){
            for(int z=0;z<9;z++){
                if (rozSud.getBoard()[y][z] != 0){
                    String text;

                    if (rozSud.getBoard()[y][z] < 0){
                        text = Integer.toString(rozSud.getBoard()[y][z]*-1);
                        letterPaint.setColor(letterColorError);
                    }
                    else{
                        letterPaint.setColor(letterColor);
                        text = Integer.toString(rozSud.getBoard()[y][z]);
                    }

                    float width, height;

                    letterPaint.getTextBounds(text, 0, text.length(), letterPaintBounds);
                    width = letterPaint.measureText(text);
                    height = letterPaintBounds.height();

                    canvas.drawText(text, (z*cellSize) + ((cellSize - width)/2),
                            (y*cellSize+cellSize) - ((cellSize - height)/2),
                            letterPaint);
                }
            }
        }
        letterPaint.setColor(letterColorRozSud);
        for (ArrayList<Object> letter:rozSud.getEmptyBoxIndex()){
            int y =(int)letter.get(0);
            int z =(int)letter.get(1);
            String text=Integer.toString(rozSud.getBoard()[y][z]);
            float width,height;
            letterPaint.getTextBounds(text,0,text.length(),letterPaintBounds);
            width=letterPaint.measureText(text);
            height=letterPaintBounds.height();
            canvas.drawText(text,(z*cellSize)+((cellSize-width)/2),(y*cellSize+cellSize)-((cellSize-height)/2),letterPaint);
        }
    }
    public RozSud getRozSud(){
        return this.rozSud;
    }
}
