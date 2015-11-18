package br.com.criandojogosandroid.cap04ex03_caminhos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OtherActivity extends AppCompatActivity {

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
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLUE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            path.addCircle(240, 120, 80, Path.Direction.CW);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                path.addOval(100, 200, 380, 300, Path.Direction.CW);
                float corners[] = {30, 30, 30, 30, 70, 70, 70, 70};
                path.addRoundRect(100, 300, 380, 400, corners, Path.Direction.CW);
                path.addArc(100, 400, 380, 500, 180, 180);
            }
            path.addRect(100, 455, 380, 600, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }
}
