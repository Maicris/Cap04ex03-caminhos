package br.com.criandojogosandroid.cap04ex03_caminhos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String items[] = {
                "Caminhos usando linhas",
                "Caminhos usando outras primitivas",
                "Curvas de Bézier - Definição",
                "Caminhos usando Quadratic Bézier",
                "Caminhos com efeitos"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(new Intent(this, PentagonActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, OtherActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, BezierActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, QuadActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, EffectActivity.class));
                break;
        }
    }
}