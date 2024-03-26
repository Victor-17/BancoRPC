package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void adicionarConta(Conta conta) throws RemoteException;
    boolean pesquisarConta(String conta) throws RemoteException;
    boolean removerConta(String Conta) throws RemoteException;
    List<Conta> listarContas() throws RemoteException;
}
