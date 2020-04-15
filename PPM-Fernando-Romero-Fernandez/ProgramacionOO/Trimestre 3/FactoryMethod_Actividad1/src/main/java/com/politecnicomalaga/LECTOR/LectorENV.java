package com.politecnicomalaga.LECTOR;

import io.github.cdimascio.dotenv.Dotenv;

public class LectorENV {

    Dotenv dotenv;

    public LectorENV(){
        dotenv = Dotenv.configure().load();
    }

    public String getDataType(){
        return dotenv.get("viewer");
    }
}
