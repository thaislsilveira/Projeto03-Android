package projeto03.com.br.projeto03;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtChuvaPolegada;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtChuvaPolegada = (EditText) findViewById(R.id.edtChuvaPolegada);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtChuvaPolegada.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtChuvaPolegada.requestFocus();
                } else{
                    Double polegada = Double.parseDouble(edtChuvaPolegada.getText().toString());

                    Double TotalMilimitros = (polegada)*(25.4);

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("CHUVA VALOR EM MILÍMETROS");
                    alerta.setMessage("O número em polegadas: "
                            + edtChuvaPolegada.getText().toString()
                            + "\ntem o valor em milímetros de : "
                            + new DecimalFormat("0.00").format(TotalMilimitros));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtChuvaPolegada.setText("");
                edtChuvaPolegada.requestFocus();
            }
        });
    }
}
