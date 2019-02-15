package com.example.caro.calculadoracaro;

import android.util.Log;

import java.util.ArrayList;

public class obtener {
    ArrayList<Float> numeros = new ArrayList<Float>();
    ArrayList<String> signos = new ArrayList<String>();
    String nume = "";
    String resultado = "";
    String numerosf = "0", numerosf2="0";
    String extraf="";

    public String obtenerResultadoExtras(String cadena){
        try{
            int m = cadena.length() - 1;

            String ultimaCifra = String.valueOf(cadena.charAt(m));

            if(ultimaCifra.equals("s") || ultimaCifra.equals("^") || ultimaCifra.equals("n")){
                resultado = "errorSignos";
            }else{
                int bande = 0;

                for (int i = 0; i < cadena.length(); i++) {
                    String j = String.valueOf(cadena.charAt(i));
                    if(j.equals("s")){
                        extraf = extraf + j;
                    }else
                        if(j.equals("^")){
                            extraf = extraf + j;
                            bande = 1;
                        }
                        else
                            if(j.equals("e")){
                                extraf = extraf + j;
                            }else
                                if(j.equals("n")){
                                    extraf = extraf + j;
                                }else
                                    if(j.equals("c")){
                                        extraf = extraf + j;
                                    }else
                                        if(j.equals("o")){
                                            extraf = extraf + j;
                                        }else
                                            if(j.equals("t")){
                                                extraf = extraf + j;
                                            }else
                                                if(j.equals("a")){
                                                    extraf = extraf + j;
                                                }else
                                                    if(bande == 1){
                                                        numerosf2 = numerosf2 + j;
                                                    }else{
                                                        numerosf = numerosf + j;
                                                    }
                }
                Float n = Float.parseFloat(numerosf);
                Float n2 = 0f;
                if(!numerosf2.equals("0")){
                    n2 = Float.parseFloat(numerosf2);
                }
                if(extraf.equals("tan")){
                    resultado = Double.toString(Math.tan((n * Math.PI)/180));
                }else
                    if(extraf.equals("^")){
                        resultado = Double.toString(Math.pow(n,n2));
                    }else
                        if(extraf.equals("cos")){
                            resultado = Double.toString(Math.cos((n * Math.PI)/180));
                        }else
                            if(extraf.equals("sen")){
                                resultado = Double.toString(Math.sin((n * Math.PI)/180));
                            }
            }
        }catch(Exception e){
            resultado = "ERROR";
        }
        return resultado;
    }

    public String obtenerResultado(String cadena){
        try{
            int m = cadena.length() - 1;

            String ultimaCifra = String.valueOf(cadena.charAt(m));
            String primeraCifra = String.valueOf(cadena.charAt(0));

            if(ultimaCifra.equals("+") || primeraCifra.equals("+") || ultimaCifra.equals("-") || primeraCifra.equals("-") || ultimaCifra.equals("x") || primeraCifra.equals("x") || ultimaCifra.equals("/") || primeraCifra.equals("/")){
                resultado = "errorSignos";
            }else {

                for (int i = 0; i < cadena.length(); i++) {

                    String j = String.valueOf(cadena.charAt(i));
                    Log.w("obtener", "n: " + j);

                    if (j.equals("+")) {
                        if (!(nume.equals(""))) {
                            numeros.add(Float.parseFloat(nume));
                            nume = "";
                        }
                        signos.add("+");
                    } else if (j.equals("-")) {
                        if (!(nume.equals(""))) {
                            numeros.add(Float.parseFloat(nume));
                            nume = "";
                        }
                        signos.add("-");
                    } else if (j.equals("x")) {
                        if (!(nume.equals(""))) {
                            numeros.add(Float.parseFloat(nume));
                            nume = "";
                        }
                        signos.add("x");
                    } else if (j.equals("/")) {
                        if (!(nume.equals(""))) {
                            numeros.add(Float.parseFloat(nume));
                            nume = "";
                        }
                        signos.add("/");
                    } else {
                        nume = nume + j;
                    }

                }//Fin del for
                if (!(nume.equals(""))) {
                    numeros.add(Float.parseFloat(nume));
                    nume = "";
                }


                float resu = 0;

                for (int i = 0; i < signos.size(); i++) {
                    String sig = signos.get(i);
                    if (sig.equals("+")) {
                        if (resu == 0) {
                            resu = (float) (numeros.get(i) + numeros.get(i + 1));
                        } else
                            resu = (float) (resu + numeros.get(i + 1));
                    } else if (sig.equals("-")) {
                        if (resu == 0) {
                            resu = (float) (numeros.get(i) - numeros.get(i + 1));
                        } else
                            resu = (float) (resu - numeros.get(i + 1));
                    } else if (sig.equals("x")) {
                        if (resu == 0) {
                            resu = (float) (numeros.get(i) * numeros.get(i + 1));
                        } else
                            resu = (float) (resu * numeros.get(i + 1));
                    } else if (sig.equals("/")) {
                        if (resu == 0) {
                            resu = (float) (numeros.get(i) / numeros.get(i + 1));
                        } else
                            resu = (float) (resu / numeros.get(i + 1));
                    }
                }
                resultado = Float.toString(resu);
            }
        }catch(Exception e){
            resultado = "ERROR";
        }
        return resultado;
    }
}
