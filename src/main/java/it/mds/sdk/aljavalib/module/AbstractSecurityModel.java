package it.mds.sdk.aljavalib.module;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractSecurityModel {

    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

//    private final void writeObject(ObjectOutputStream out) throws java.io.IOException {
//        throw new java.io.IOException("L’oggetto non può essere serializzato ");
//    }
//
//    private final void readObject(ObjectInputStream in) throws java.io.IOException {
//        throw new java.io.IOException("L’oggetto non può essere deserializzato");
//    }

}
