package com.gugawag.rpc.banco;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;

public class Conta implements Serializable{

    private String numero;
    private Double saldo;

    public Conta(String numero, Double saldo) throws RemoteException {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero(){
        return this.numero;
    }
    public Double getSaldo(){
        return this.saldo;
    }
  
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

