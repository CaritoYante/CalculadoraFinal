package com.example.caro.calculadoracaro;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView dato, operacion;
    private Button calcula, suma, resta, multiplicacion, division, punto, exponente, seno, coseno, tangente;
    private obtener obtener;
    private String resultado;
    private Boolean extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcula = (Button) findViewById(R.id.calcula);
        suma = (Button) findViewById(R.id.suma);
        resta = (Button) findViewById(R.id.resta);
        multiplicacion = (Button) findViewById(R.id.multiplicacion);
        division = (Button) findViewById(R.id.division);
        dato = (TextView) findViewById(R.id.dato);
        operacion = (TextView) findViewById(R.id.operacion);
        punto = (Button) findViewById(R.id.punto);
        exponente = (Button) findViewById(R.id.exponente);
        seno = (Button) findViewById(R.id.seno);
        coseno = (Button) findViewById(R.id.coseno);
        tangente = (Button) findViewById(R.id.tangente);

        exponente.setEnabled(false);
        extra = false;
    }

    public void deshabilita(){
        suma.setEnabled(false);
        resta.setEnabled(false);
        multiplicacion.setEnabled(false);
        division.setEnabled(false);
    }
    public void deshabilitaE(){
        coseno.setEnabled(false);
        exponente.setEnabled(false);
        tangente.setEnabled(false);
        seno.setEnabled(false);
    }
    public void habilita(){
        suma.setEnabled(true);
        resta.setEnabled(true);
        multiplicacion.setEnabled(true);
        division.setEnabled(true);
        punto.setEnabled(true);
    }
    public void habilitaE(){
        coseno.setEnabled(true);
        exponente.setEnabled(true);
        tangente.setEnabled(true);
        seno.setEnabled(true);
    }

    public void suma(View view){
        String cadena = dato.getText().toString() + "+";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
    }

    public void resta(View view){
        String cadena = dato.getText().toString() + "-";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
    }
    public void multiplicacion(View view){
        String cadena = dato.getText().toString() + "x";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
    }
    public void division(View view){
        String cadena = dato.getText().toString() + "/";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
    }
    public void coseno(View view){
        String cadena = dato.getText().toString() + "cos";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
        extra = true;
    }

    public void exponente(View view){
        String cadena = dato.getText().toString() + "^";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
        extra = true;
    }

    public void tangente(View view){
        String cadena = dato.getText().toString() + "tan";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
        extra = true;
    }

    public void seno(View view){
        String cadena = dato.getText().toString() + "sen";
        dato.setText(cadena);
        deshabilita();
        deshabilitaE();
        extra = true;
    }

    public void uno(View view){
        String cadena = dato.getText().toString() + "1";
        dato.setText(cadena);
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void dos(View view){
        String cadena = dato.getText().toString() + "2";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void tres(View view){
        String cadena = dato.getText().toString() + "3";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void cuatro(View view){
        String cadena = dato.getText().toString() + "4";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void cinco(View view){
        String cadena = dato.getText().toString() + "5";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void seis(View view){
        String cadena = dato.getText().toString() + "6";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void siete(View view){
        String cadena = dato.getText().toString() + "7";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void ocho(View view){
        String cadena = dato.getText().toString() + "8";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void nueve(View view){
        String cadena = dato.getText().toString() + "9";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void cero(View view){
        String cadena = dato.getText().toString() + "0";
        dato.setText(cadena);
        habilita();
        deshabilitaE();
        exponente.setEnabled(true);
        if(!extra){
            habilita();
        }
    }
    public void borrar(View view){
        dato.setText("");
        habilita();
        habilitaE();
        extra = false;
    }
    public void punto(View view){
        String cadena = dato.getText().toString() + ".";
        dato.setText(cadena);
        punto.setEnabled(false);
        deshabilitaE();
        exponente.setEnabled(true);
    }

    public void hazOperacion(View view){
        String cadena = dato.getText().toString();
        if(cadena.isEmpty()){
            Toast.makeText(this, "Campo vacio", Toast.LENGTH_SHORT).show();
        }else {
            obtener obtener = new obtener();
            if(extra) {
                resultado = obtener.obtenerResultadoExtras(cadena);
            }else {
                resultado = obtener.obtenerResultado(cadena);
            }
            if(resultado.equals("errorSignos")){
                Toast.makeText(this, "Revisa los signos", Toast.LENGTH_SHORT).show();
            }else
            if(resultado.equals("ERROR")){
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            }else
            if(resultado.equals("Infinity")){
                Toast.makeText(this, "El resultado esta fuera del rango", Toast.LENGTH_SHORT).show();
            }else {
                operacion.setText(cadena);
                dato.setText(resultado);
                extra = false;
            }
        }
    }


}

