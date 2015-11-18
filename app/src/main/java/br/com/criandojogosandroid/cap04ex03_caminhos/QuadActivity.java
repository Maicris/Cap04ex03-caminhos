package br.com.criandojogosandroid.cap04ex03_caminhos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class QuadActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Path path = new Path();
        private Paint paint = new Paint();

        public Tela(Context context) {
            super(context);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(2);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int nLados = 20;
            float drawAngle = toRadians(90);
            float cx = 240;
            float cy = 300;
            float r = 200;
            float x = cx + (float) (r * Math.cos(drawAngle));
            float y = cy + (float) (r * Math.sin(drawAngle));
            path.moveTo(x, y);
            for (int i = 0; i < nLados; i++) {
                drawAngle += toRadians(360.0f / nLados);
                x = cx + (float) (r * Math.cos(drawAngle));
                y = cy + (float) (r * Math.sin(drawAngle));
                path.quadTo(cx, cy, x, y);
            }
            canvas.drawPath(path, paint);
        }

        private float toRadians(float angle) {
            return (float) (angle * Math.PI / 180.0f);
        }
    }
}
