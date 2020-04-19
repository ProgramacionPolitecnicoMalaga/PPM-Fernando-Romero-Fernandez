package com.politecnicomalaga.ALGORITMOS;

import org.mindrot.jbcrypt.BCrypt;

public class AlgoritmoB_CRYPT implements InterfazAlgoritmoConSalt {
    @Override
    public String getSalt() {
        return BCrypt.gensalt(12);
    }

    @Override
    public String getSaltedPasswordHash(String password, String salt){
        return BCrypt.hashpw(password,salt);
    }

    @Override
    public boolean verificarSaltedPassword(String passwordValidacion, String saltCreacion, String hashCreacion){
        return BCrypt.checkpw(passwordValidacion,hashCreacion);
    }
}
