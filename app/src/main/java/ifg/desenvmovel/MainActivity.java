package ifg.desenvmovel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView peso = findViewById(R.id.txtPeso);
        TextView altura = findViewById(R.id.txtAltura);
        TextView imc = findViewById(R.id.lblResultado);

        Button btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peso.setText("");
                altura.setText("");

            }
        });

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result;
                double doubleP=0;
                double doubleA=0;
                String clas = null;
                try {

                    doubleP = Double.parseDouble(peso.getText().toString());
                    doubleA = Double.parseDouble(altura.getText().toString());
                }catch (Exception e){
                }
                result=doubleP/pow(doubleA,2);

                if(result<18.5){
                    clas = "Magreza";
                }
                if(result>18.5 && result <24.9){
                    clas = "Saudavel";
                }
                if(result>25 && result <29.9){
                    clas = "Sobrepeso";
                }
                if(result>30 && result <34.9){
                    clas = "Obesidade Grau 1";
                }
                if(result>35 && result <39.9){
                    clas = "Obesidade Grau 2 (Severa)";
                }
                if(result>40){
                    clas = "Obesidade Grau 3 (Morbida)";
                }
                

                imc.setText("IMC: "+result+"\n"+"Classificação: "+clas);
                }

        });
    }

}