package com.politecnicomalaga.ALGORITMOS;

import java.security.NoSuchAlgorithmException;

public class GeneradorDeAlgoritmos {

    public InterfazAlgoritmoConSalt getAlgoritmoByNumero(int numeroAlgoritmo) throws NoSuchAlgorithmException {
        switch (numeroAlgoritmo){
            case Algoritmos.MD5:
                return new AlgoritmoMD5();
            case Algoritmos.SHA_512:
                return new AlgoritmoSHA_512();
            case Algoritmos.B_CRYPT:
                return new AlgoritmoB_CRYPT();
        }
        return new AlgoritmoSHA_512();
    }
}
