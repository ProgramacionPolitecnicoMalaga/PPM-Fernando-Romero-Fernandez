package com.politecnicomalaga.ALGORITMOS;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AlgoritmoMD5 implements InterfazAlgoritmoConSalt{

    MessageDigest messageDigest;

    public AlgoritmoMD5() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("MD5");
    }

    public String getSalt(){
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return Hex.encodeHexString(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Salt!";
        }
    }

    public String getSaltedPasswordHash(String password, String salt) throws NoSuchAlgorithmException {
        if (messageDigest == null)
            throw new NoSuchAlgorithmException("No existe el algoritmo de hash");
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        return new String(Hex.encodeHex(bytes));
    }

    public boolean verificarSaltedPassword(String passwordValidacion, String saltCreacion, String hashCreacion) throws NoSuchAlgorithmException {
        String nuevoHash = getSaltedPasswordHash(passwordValidacion,saltCreacion);
        return nuevoHash.equals(hashCreacion);
    }

}