package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

public class PodaExtremos {

    public int podarMasProximo(int numero, List<Integer> listaNumeros){
        int celdaMinimaDiferencia = -1;
        int valorDiferenciaMinimo = 5000;
        int numeroDeLaListaComparado = 100;
        for(int i = 0; i < listaNumeros.size(); i++){
            int diferencia = numero - listaNumeros.get(i);
            diferencia = abs(diferencia);
            if(diferencia < valorDiferenciaMinimo){
                celdaMinimaDiferencia = i;
                valorDiferenciaMinimo = diferencia;
                numeroDeLaListaComparado = listaNumeros.get(i);
            }
            if(diferencia == valorDiferenciaMinimo && numeroDeLaListaComparado > listaNumeros.get(i)){
                numeroDeLaListaComparado = listaNumeros.get(i);
            }
        }
        return listaNumeros.remove(celdaMinimaDiferencia);
    }

    public int podarMasLejano(int numero, List<Integer> listaNumeros){
        int celdaMinimaDiferencia = -1;
        int numeroDeLaListaComparado = 100;
        int valorDiferenciaMaxima = -1;
        for(int i = 0; i < listaNumeros.size(); i++){
            int diferencia = numero - listaNumeros.get(i);
            diferencia = abs(diferencia);
            if(diferencia > valorDiferenciaMaxima){
                celdaMinimaDiferencia = i;
                valorDiferenciaMaxima = diferencia;
                numeroDeLaListaComparado = listaNumeros.get(i);
            }
            if(diferencia == valorDiferenciaMaxima && numeroDeLaListaComparado < listaNumeros.get(i)){
                numeroDeLaListaComparado = listaNumeros.get(i);
            }
        }
        return listaNumeros.remove(celdaMinimaDiferencia);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //{1,21,55,1,5,8,13,3,2,34}
        list.add(1);
        list.add(21);
        list.add(55);
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(13);
        list.add(3);
        list.add(2);
        list.add(34);
        System.out.println(list);

        PodaExtremos podaExtremos = new PodaExtremos();
        int numerito2 = podaExtremos.podarMasLejano(10,list);
    }
}
