package br.com.criandojogosandroid.cap04ex03_caminhos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EffectActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {
        private Paint drawPaint = new Paint();
        private Paint textPaint = new Paint();
        private Path path[] = new Path[6];
        private PathEffect effects[] = new PathEffect[6];
        private int[] colors;
        private String[] texts;

        public Tela(Context context) {
            super(context);

            drawPaint.setAntiAlias(true);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setStrokeWidth(15);

            textPaint.setTextSize(25);
            textPaint.setFakeBoldText(true);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setAntiAlias(true);
            textPaint.setColor(Color.BLUE);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    path[i*3 + j] = new Path();
                    path[i*3 + j].moveTo(i*240 + 120, j*200 +  80);
                    path[i*3 + j].lineTo(i*240 + 180, j*200 + 140);
                    path[i*3 + j].lineTo(i*240 + 120, j*200 + 200);
                    path[i*3 + j].lineTo(i*240 +  60, j*200 + 140);
                    path[i*3 + j].close();
                }
            }

            makeEffects();

            colors = new int[] { Color.BLACK, Color.BLUE, Color.GREEN, Color.CYAN, Color.RED, Color.MAGENTA };
            texts = new String[] { "Sem Efeito", "CornerPath", "DashPath", "PathDashPath", "DiscretePath", "ComposePath" };
        }

        @Override protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    drawPaint.setColor(colors[i*3 + j]);
                    drawPaint.setPathEffect(effects[i * 3 + j]);
                    canvas.drawPath(path[i * 3 + j], drawPaint);
                    canvas.drawText(texts[i*3 + j], i*240 + 120, j*200 + 60, textPaint);
                }
            }
        }

        private void makeEffects() {
            effects[0] = null;
            effects[1] = new CornerPathEffect(10);
            effects[2] = new DashPathEffect(new float[] {10, 5, 5, 5}, 3);
            effects[3] = new PathDashPathEffect(makeShape(), 12, 3, PathDashPathEffect.Style.MORPH);
            effects[4] = new DiscretePathEffect(1, 1.3f);
            effects[5] = new ComposePathEffect(effects[3], effects[1]);
        }

        private Path makeShape() {
            Path path = new Path();
            path.moveTo(-6, 4);
            path.lineTo(6, 4);
            path.lineTo(-6, -4);
            path.lineTo(6, -4);
            path.close();
            return path;
        }
    }
}