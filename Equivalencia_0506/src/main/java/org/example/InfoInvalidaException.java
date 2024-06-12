package org.example;

import java.security.InvalidParameterException;

public class InfoInvalidaException extends InvalidParameterException {
    public InfoInvalidaException (String mensagem){
        super(mensagem);
    }
}
