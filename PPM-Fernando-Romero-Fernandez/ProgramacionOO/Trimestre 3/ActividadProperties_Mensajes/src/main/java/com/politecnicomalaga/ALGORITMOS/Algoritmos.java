package com.politecnicomalaga.ALGORITMOS;

public class Algoritmos {
    public final static int MD5 = 1;
    public final static int SHA_512 = 2;
    public final static int B_CRYPT = 3;

    public int getAlgoritmoPorNombre(String nombreAlgoritmo){
        switch (nombreAlgoritmo.toUpperCase()){
            case "MD5": return MD5;
            case "SHA_512": return SHA_512;
            case "B_CRYPT": return B_CRYPT;
            default: return SHA_512;
        }
    }

    public String getAlgoritmoPorNumero(int numeroAlgoritmo){
        switch (numeroAlgoritmo){
            case 1: return "MD5";
            case 2: return "SHA_512";
            case 3: return "B_CRYPT";
        }
        return "?";
    }
}
