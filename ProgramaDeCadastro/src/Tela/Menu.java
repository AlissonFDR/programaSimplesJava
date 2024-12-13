package Tela;
import Modelo.Cliente;
import Modelo.Funcionario;
import util.Tela;
import util.BancoDeDados;

public class Menu {
    
    public static void main(String[] args) {
                String menu = "Escolha uma das op��es abaixo \n"
                + "1 - Cadastrar Funcion�rio \n"
                + "2 - Listar Funcion�rio \n"
                + "3 - Excluir Funcion�rio \n"
                + "4 - Cadastrar Cliente \n"
                + "5 - Listar Clientes \n"
                + "6 - Excluir Cliente \n"
                + "7 - Sair \n";
        int opcao;
        
        do{
            opcao = Tela.nextInt(menu);
            switch (opcao){
                case 1 : //Cadastrar Funcion�rio
                    cadastrarFuncionario();
                    break;
                case 2 : //Listar Funcion�rio
                    listarFuncionarios();
                    break;
                case 3 : //Excluir Funcion�rio
                    excluirFuncionario();
                    break;
                case 4 : //Cadastrar Cliente
                    cadastrarCliente();
                    break;
                case 5 : //Listar Cliente
                    listarClientes();
                    break;
                case 6 : //Excluir Cliente
                    excluirCliente();
                    break;
                case 7 : //Sair
                    Tela.exibirMensagem("Volte sempre!!");
                    break;
                
                default:
                        Tela.exibirMensagem("Op��o inv�lida!");
       
            }
        }while(opcao!=7);
        
    }
        public static void cadastrarFuncionario(){
            Funcionario f= new Funcionario();
            f.setNome(Tela.nextString("Digite o nome:"));
            f.setCpf(Tela.nextStringCpf("Digite o CPF:"));
            f.setDataNascimento(Tela.nextDate("Digite a data de nascimento (DD/MM/AAAA):"));
            f.setEndereco(Tela.nextString("Digite o endere�o:"));
            f.setSalarioBase(Tela.nextDouble("Digite o sal�rio base:"));
            f.setImposto(Tela.nextDouble("Digite o percentual de imposto:"));
            BancoDeDados.adicionar(f);
            Tela.exibirMensagem("Funcion�rio cadastrado com sucesso!");
         }
        
        public static void listarFuncionarios(){
            if(BancoDeDados.getOrganizacao().isEmpty()){
                Tela.exibirMensagem("N�o h� funcion�rios cadastrados!");
            }else{
                String funcionarios1 = "";
            for(Funcionario f : BancoDeDados.getOrganizacao()){
                funcionarios1 += f + "\n";
            }
            Tela.exibirMensagem(funcionarios1);
            }
    }
        public static void excluirFuncionario(){
             if(BancoDeDados.getOrganizacao().isEmpty()){
                Tela.exibirMensagem("N�o h� funcion�rios cadastrados!");
            }else{
                 String lista ="Informe o c�digo do funcion�rio para excluir: \n";
                 for(int i = 0;i < BancoDeDados.getOrganizacao().size(); i++){
                     lista += (i+1) + " - " + BancoDeDados.getOrganizacao().get(i).getNome() + "\n";
                 }
                 int codigo = Tela.nextInt(lista);
                 if (BancoDeDados.excluirFuncionario(codigo - 1)){
                     Tela.exibirMensagem("Funcion�rio exclu�do com sucesso!");
                 }else if (codigo != 0){
                     Tela.exibirMensagem("C�digo inv�lido!");
                     excluirFuncionario();
                 }
             }
    }
        public static void cadastrarCliente(){
            Cliente c = new Cliente();
            c.setNome(Tela.nextString("Digite o nome:"));
            c.setCpf(Tela.nextStringCpf("Digite o CPF:"));
            c.setDataNascimento(Tela.nextDate("Digite a data de nascimento (DD/MM/AAAA):"));
            c.setValorDaCompra(Tela.nextDouble("Digite o valor da Compra:"));
            c.setSaldo(Tela.nextDouble("Digite o saldo do cliente:"));
            BancoDeDados.adicionar(c);
            Tela.exibirMensagem("Cliente cadastrado com sucesso!");
    }
        public static void listarClientes(){
            if(BancoDeDados.getClientela().isEmpty()){
                Tela.exibirMensagem("N�o h� clientes cadastrados!");
            }else{
                String clientes1 = " ";
                for(Cliente c1 : BancoDeDados.getClientela()){
                    clientes1 += c1 + "\n";
                }
            Tela.exibirMensagem(clientes1);
            }
    }
        public static void excluirCliente(){
             if(BancoDeDados.getClientela().isEmpty()){
                Tela.exibirMensagem("N�o h� clientes cadastrados!");
            }else{
                 String lista ="Informe o c�digo do cliente para excluir: \n";
                 for(int i = 0;i < BancoDeDados.getClientela().size(); i++){
                     lista += (i+1) + " - " + BancoDeDados.getClientela().get(i).getNome() + "\n";
                 }
                 int codigo = Tela.nextInt(lista);
                 if (BancoDeDados.excluirCliente(codigo - 1)){
                     Tela.exibirMensagem("Cliente exclu�do com sucesso!");
                 }else if (codigo != 0){
                     Tela.exibirMensagem("C�digo inv�lido!");
                     excluirCliente();
                 }
             }
    }
}
