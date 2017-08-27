/*
 * Criar um programa para o gerenciamento de uma lista de nomes. Os nomes devem ser armazenados em um
 * vetor do tipo String de tamanho 50. O programa deve possuir o seguinte menu:
 * 1 - Adicionar um novo nome
 * 2 - Apresentar os nomes
 * 3 - Pesquisar um nome
 * 4 - Remover um nome
 * 0 - Sair
 */

package ap2;

import java.util.Scanner;

/**
 * @author Rodrigo Rinaldi dos Santos TADS 2ºperiodo 2017 turmaB 
 */

public class AP2 {

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        String opcao=null;
        String []nomes = criarVetor();
        
        do{
            imprimiOpcao();
            opcao=input.next();
            verificaOpcao(opcao,nomes);
            
            
        }while(!opcao.equals("0"));
    }
    
    //valor inicial do vetor 50
    public static String[] criarVetor(){
        String []nomes = new String[50];
        for(int i=0;i<nomes.length;i++){
            nomes[i]=null;
        }
        return nomes;
    }
    
    //opcao 1
    public static String[] adicionarNomes(String []nomes, String nomeEntrada){
            boolean jaEstaLista=verificaNomeLista(nomes, nomeEntrada);
            if(!jaEstaLista){
                for(int i=0;i<nomes.length;i++){
                    if(nomes[i]==null){
                        nomes[i]=nomeEntrada;
                        break;
                    }
                }
            }
        
        return nomes;
    }
    public static boolean verificaNomeLista(String []nomes, String nomeEntrada){
        boolean jaEstaLista=false;
        for(int i=0;i<nomes.length;i++){
            if(nomeEntrada.equals(nomes[i])){
                System.err.println(nomeEntrada + " ja esta na lista");
                 return jaEstaLista=true;
            }
        }
        return jaEstaLista;
    }
    public static boolean listaCheia(String []nomes){
        boolean cheio=false;
        if(nomes[nomes.length-1]!=null){
            System.err.println("Lista esta cheia");
            return cheio=true;
        }
        return cheio;
    }
    
    public static void verificaOpcao(String opcao, String nomes[]){
        switch(opcao){
            case "0":
                break;
            case "1":
                boolean cheio = listaCheia(nomes);
                if(!cheio){
                    System.out.print("Nome que deseja adicionar: ");
                    String nomeEntrada = input.next();
                    adicionarNomes(nomes, nomeEntrada);
                }
                break;
            case "2":
                System.out.println("Nomes que estao na lista: ");
                imprimirNomes(nomes);
                break;
            case "3":
                System.out.print("Nome que deseja pesquisar: ");
                String nomePesquisa=input.next();
                pesquisarNome(nomes, nomePesquisa);
                break;
            case "4":
                System.out.print("Nome que deseja remover: ");
                String nomeRemover = input.next();
                nomes=removerNome(nomes, nomeRemover);  
                break;
        }
    }
    
    public static void imprimiOpcao(){
        System.out.println("\n");
        System.out.println("1- Adicionar um novo nome");
        System.out.println("2- Apresentar os nomes");
        System.out.println("3- Pesquisar um nome");
        System.out.println("4- Remover um nome");
        System.out.println("0- Sair");
        System.out.print("Escolha uma opcao: ");
    }
    
    //opcao 2
    public static void imprimirNomes(String []nomes){
        for(int i=0;i<nomes.length;i++){
            if(nomes[0]==null){
                System.err.println("A lista esta vazia");
                break;
            } 
            if(nomes[i]==null){
                break;
            }
            else{
                System.out.println("* "+nomes[i]);
            }
            
        }
    }
    
    //opcao 3
    public static void pesquisarNome(String []nomes, String nomePesquisa){
        for(int i=0;i<nomes.length;i++){
            if(nomePesquisa.equals(nomes[i])){
                System.out.println("Nome encontrado \n"+nomePesquisa + " posicao=["+i+"]");
                break;
            }
            if(i==nomes.length-1){
               if(!nomePesquisa.equals(nomes[i])){
                   System.out.println("nome nao encontrado");
                   break;
               } 
            }
        }
    }
    
    //opcao 4
    public static String[] removerNome(String []nomes, String nomeRemover){
        for(int i=0;i<nomes.length;i++){
            if(nomeRemover.equals(nomes[i])){
                nomes[i]="0";
                nomes=ordenandoDepoisDeRemover(nomes, i);  
            } 
        }
        return nomes;
    } 
    public static String[] ordenandoDepoisDeRemover(String []nomes, int i){
        for(int j=i; j<nomes.length-1;j++){
            nomes[j]= nomes[j+1];
            if(nomes[j]==null){
                return nomes;
            }
        }
        nomes[nomes.length-1]=null;
        return nomes;
    }
    
    
        
}
