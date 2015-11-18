package br.com.criandojogosandroid.cap04ex03_caminhos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BezierActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Path quad = new Path();
        private Path cubic = new Path();
        private Paint bezierPaint = new Paint();
        private Paint linePaint = new Paint();
        private Paint textPaint = new Paint();

        public Tela(Context context) {
            super(context);
            bezierPaint.setStyle(Paint.Style.STROKE);
            bezierPaint.setColor(Color.RED);
            bezierPaint.setStrokeWidth(2);
            bezierPaint.setAntiAlias(true);
            linePaint.setStyle(Paint.Style.STROKE);
            linePaint.setColor(Color.GRAY);
            linePaint.setStrokeWidth(1);
            linePaint.setAntiAlias(true);
            textPaint.setColor(Color.BLUE);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(30);
            quad.moveTo(100, 300);
            quad.quadTo(240, 100, 380, 300);
            cubic.moveTo(100, 400);
            cubic.cubicTo(330, 400, 150, 600, 380, 600);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            canvas.drawPath(quad, bezierPaint);
            canvas.drawLine(100, 300, 240, 100, linePaint);
            canvas.drawLine(240, 100, 380, 300, linePaint);
            canvas.drawText("Bézier Quadrática", 240, 60, textPaint);
            canvas.drawPath(cubic, bezierPaint);
            canvas.drawLine(100, 400, 330, 400, linePaint);
            canvas.drawLine(330, 400, 150, 600, linePaint);
            canvas.drawLine(150, 600, 380, 600, linePaint);
            canvas.drawText("Bézier Cúbica", 240, 360, textPaint);
        }
    }
}
