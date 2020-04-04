package com.politecnicomalaga.ALGORITMOS;

import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AlgoritmoSHA_512 implements InterfazAlgoritmoConSalt {

    MessageDigest messageDigest;

    public AlgoritmoSHA_512() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-512");
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

    public boolean verificarSaltedPassword(String password, String salt, String passwordHash) throws NoSuchAlgorithmException {
        String nuevoHash = getSaltedPasswordHash(password,salt);
        return nuevoHash.equals(passwordHash);
    }

}