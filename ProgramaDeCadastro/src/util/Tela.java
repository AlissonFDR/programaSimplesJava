package util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Tela {
    public static String nextString(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }
    
    public static int nextInt(String mensagem){
        try{
            String valor = nextString(mensagem);
            
            if(valor != null){
                return Integer.parseInt(valor.trim());
            }
            return 7;
        } catch(Exception e){
            exibirMensagem("Número Inválido!");
            return nextInt(mensagem);
        }
    }
    
    public static String nextStringCpf(String mensagem){
        try{
            String testeCpf = nextString(mensagem);
            if(testeCpf.length() == 11){
               return testeCpf.substring(0,3)+"."+
                      testeCpf.substring(3,6)+"."+
                      testeCpf.substring(6,9)+"-"+
                      testeCpf.substring(9,11);
            }else{
                exibirMensagem("Número de CPF inválido! (11 digitos)");
                return nextStringCpf(mensagem);
           }
        } catch(Exception e){
            return null;
        }
    }
    
     public static double nextDouble(String mensagem){
        String valor = nextString(mensagem);
        if(valor == null){
            return 0;
        }
        valor = valor.trim().replace(".","").replace(",",".");
        try{
            return Double.parseDouble(valor);
        } catch(Exception e){
            exibirMensagem("Número inválido!");
            return nextDouble(mensagem);
        }
    }
     
     public static Date nextDate(String mensagem){
         String data = nextString(mensagem);
         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         try{
            return df.parse(data);
         } catch (Exception e){
             if(data == null){
                 return null;
             }else{
             exibirMensagem("Formato de data inválido!\n"
                     + "Siga o padrão abaixo:\n"
                     + "(dia/mês/ano separados por barras) \n"
                     + "Exemplo: 01/01/2001");
              return nextDate(mensagem);
             }
            
         }
    }
     
    public static void exibirMensagem(String mensagem){
       JOptionPane.showMessageDialog(null, mensagem);
    }
}
