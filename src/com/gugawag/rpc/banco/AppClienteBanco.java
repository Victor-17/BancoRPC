package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                }
                case 3: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Digite o número da conta:");
                    String numero = entrada.next();
                    Conta conta = new Conta(numero, 0.0);
                    banco.adicionarConta(conta);
                    System.out.println("Conta criada com sucesso");
                }
                case 4: {
                    System.out.println("Digite o número para pesquisar a conta:");
                    String numero = entrada.next();
                    boolean retorno = banco.pesquisarConta(numero);
                    if (retorno == true){
                        System.out.println("A conta foi encontrada");
                    }else{
                        System.out.println("A conta não foi encontrada");
                    }
                }

                case 5: {
                    System.out.println("Digite o número da conta a ser removida:");
                    String numero = entrada.next();
                    Boolean remover = banco.removerConta(numero);
                    if (remover == true){
                        System.out.println("A conta foi removida");
                    }else{
                        System.out.println("A conta não foi removida por não existir");
                    }
                }
                case 6: {
                    System.out.println("Listagem de contas:");
                    System.out.println(banco.listarContas());
                }

            } 

            }
            menu();
            opcao = entrada.nextInt();
        }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("Victor Eduardo Japyassu Nobrega");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar Conta");
        System.out.println("4 - Pesquisar Conta");
        System.out.println("5 - Remover Conta");
        System.out.println("6 - Listar Contas");
        System.out.println("9 - Sair");
    }

}
