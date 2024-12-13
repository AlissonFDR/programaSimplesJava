package Tela;
import Modelo.Cliente;
import Modelo.Funcionario;
import util.Tela;
import util.BancoDeDados;

public class Menu {
    
    public static void main(String[] args) {
                String menu = "Escolha uma das opções abaixo \n"
                + "1 - Cadastrar Funcionário \n"
                + "2 - Listar Funcionário \n"
                + "3 - Excluir Funcionário \n"
                + "4 - Cadastrar Cliente \n"
                + "5 - Listar Clientes \n"
                + "6 - Excluir Cliente \n"
                + "7 - Sair \n";
        int opcao;
        
        do{
            opcao = Tela.nextInt(menu);
            switch (opcao){
                case 1 : //Cadastrar Funcionário
                    cadastrarFuncionario();
                    break;
                case 2 : //Listar Funcionário
                    listarFuncionarios();
                    break;
                case 3 : //Excluir Funcionário
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
                        Tela.exibirMensagem("Opção inválida!");
       
            }
        }while(opcao!=7);
        
    }
        public static void cadastrarFuncionario(){
            Funcionario f= new Funcionario();
            f.setNome(Tela.nextString("Digite o nome:"));
            f.setCpf(Tela.nextStringCpf("Digite o CPF:"));
            f.setDataNascimento(Tela.nextDate("Digite a data de nascimento (DD/MM/AAAA):"));
            f.setEndereco(Tela.nextString("Digite o endereço:"));
            f.setSalarioBase(Tela.nextDouble("Digite o salário base:"));
            f.setImposto(Tela.nextDouble("Digite o percentual de imposto:"));
            BancoDeDados.adicionar(f);
            Tela.exibirMensagem("Funcionário cadastrado com sucesso!");
         }
        
        public static void listarFuncionarios(){
            if(BancoDeDados.getOrganizacao().isEmpty()){
                Tela.exibirMensagem("Não há funcionários cadastrados!");
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
                Tela.exibirMensagem("Não há funcionários cadastrados!");
            }else{
                 String lista ="Informe o código do funcionário para excluir: \n";
                 for(int i = 0;i < BancoDeDados.getOrganizacao().size(); i++){
                     lista += (i+1) + " - " + BancoDeDados.getOrganizacao().get(i).getNome() + "\n";
                 }
                 int codigo = Tela.nextInt(lista);
                 if (BancoDeDados.excluirFuncionario(codigo - 1)){
                     Tela.exibirMensagem("Funcionário excluído com sucesso!");
                 }else if (codigo != 0){
                     Tela.exibirMensagem("Código inválido!");
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
                Tela.exibirMensagem("Não há clientes cadastrados!");
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
                Tela.exibirMensagem("Não há clientes cadastrados!");
            }else{
                 String lista ="Informe o código do cliente para excluir: \n";
                 for(int i = 0;i < BancoDeDados.getClientela().size(); i++){
                     lista += (i+1) + " - " + BancoDeDados.getClientela().get(i).getNome() + "\n";
                 }
                 int codigo = Tela.nextInt(lista);
                 if (BancoDeDados.excluirCliente(codigo - 1)){
                     Tela.exibirMensagem("Cliente excluído com sucesso!");
                 }else if (codigo != 0){
                     Tela.exibirMensagem("Código inválido!");
                     excluirCliente();
                 }
             }
    }
}
