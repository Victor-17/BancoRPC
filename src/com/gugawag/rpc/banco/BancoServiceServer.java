package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;
    private List<Conta> listaContas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);

        listaContas = new ArrayList<>();
        listaContas.add(new Conta("1", 100.0));
        listaContas.add(new Conta("2", 156.0));
        listaContas.add(new Conta("3", 950.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public void adicionarConta(Conta conta) throws RemoteException {
        saldoContas.put(conta.getNumero(), conta.getSaldo());
        listaContas.add(conta);
    }

    @Override
    public boolean pesquisarConta(String numero) throws RemoteException {
       return saldoContas.containsKey(numero);
    }

    @Override
    public boolean removerConta(String numero) throws RemoteException {
        for (Conta conta : listaContas) {
            int index = 0;
            if(conta.getNumero() == numero){
                listaContas.remove(index);
            }
            index += 1;
        }
        return saldoContas.remove(numero) != null;
    }

    @Override
    public List<Conta> listarContas() throws RemoteException {
        return listaContas;
    }
}
