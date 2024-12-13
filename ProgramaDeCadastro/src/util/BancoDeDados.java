package util;
import Modelo.Cliente;
import Modelo.Funcionario;
import java.util.ArrayList;

public class BancoDeDados {
    private static final ArrayList<Cliente> clientela = new ArrayList();
    private static final ArrayList<Funcionario> organizacao = new ArrayList();
    
    public static ArrayList<Cliente> getClientela(){
        return clientela;
    }
    
    public static ArrayList<Funcionario> getOrganizacao(){
        return organizacao;
    }
    
    public static void adicionar(Cliente clientes){
        clientela.add(clientes);
    }
    
    public static void adicionar(Funcionario funcionarios){
        organizacao.add(funcionarios);
    }
    
    public static boolean excluirCliente(int indice){
        if(indice<0 || indice>=clientela.size()){
            return false;
    }
        clientela.remove(indice);
        return true;
    }
    
    public static boolean excluirFuncionario(int indice){
        if(indice<0 || indice>=organizacao.size()){
            return false;
    }
        organizacao.remove(indice);
        return true;
    }
}

