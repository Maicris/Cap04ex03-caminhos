package br.com.criandojogosandroid.cap04ex03_caminhos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PentagonActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint drawPaint = new Paint();
        Paint textPaint = new Paint();

        public Tela(Context context) {
            super(context);
            drawPaint.setColor(Color.RED);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setAntiAlias(true);
            drawPaint.setStrokeWidth(2);
            textPaint.setColor(Color.BLUE);
            textPaint.setTextSize(14);
            textPaint.setTextAlign(Paint.Align.CENTER);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            Path pentagon = new Path();
            pentagon.moveTo(200, 300);
            pentagon.lineTo(300, 300);
            pentagon.lineTo(340, 210);
            pentagon.lineTo(250, 150);
            pentagon.lineTo(160, 210);
            pentagon.close();
            canvas.drawPath(pentagon, drawPaint);
            canvas.drawText("(200, 300)", 200, 330, textPaint);
            canvas.drawText("(300, 300)", 300, 330, textPaint);
            canvas.drawText("(340, 210)", 385, 215, textPaint);
            canvas.drawText("(250, 150)", 250, 130, textPaint);
            canvas.drawText("(160, 210)", 115, 215, textPaint);
        }
    }
}
