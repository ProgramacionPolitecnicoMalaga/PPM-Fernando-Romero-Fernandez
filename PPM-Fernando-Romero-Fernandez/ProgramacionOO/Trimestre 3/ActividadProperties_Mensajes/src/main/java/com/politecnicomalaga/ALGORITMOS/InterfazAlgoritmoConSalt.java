package com.politecnicomalaga.ALGORITMOS;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface InterfazAlgoritmoConSalt {
    String getSalt() throws NoSuchProviderException, NoSuchAlgorithmException;
    String getSaltedPasswordHash(String password, String salt) throws NoSuchAlgorithmException;
    boolean verificarSaltedPassword(String passwordValidacion, String saltCreacion, String hashCreacion) throws NoSuchAlgorithmException;
}
