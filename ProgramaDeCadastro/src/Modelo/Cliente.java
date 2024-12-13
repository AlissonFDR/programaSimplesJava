package Modelo;
import java.text.DateFormat;
import java.text.DecimalFormat;

public class Cliente extends Pessoa {
    private double valorDaCompra;
    private double saldo;

    public double getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double calcularCredito(){
        return (this.saldo - this.valorDaCompra);
    }
    

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        DecimalFormat d1 = new DecimalFormat("#,##0.00");
        String dataFormatada = null;
        if(getDataNascimento() != null){
            dataFormatada = df.format(getDataNascimento());
        }
        return "Cliente\n"+
                "------------------------------------------- \n"+
                "Nome: "+ getNome()+"\n"+
                "CPF: "+ getCpf()+"\n"+
                "Data de Nascimento: "+ dataFormatada +"\n"+
                "Valor da Compra: R$ "+ d1.format(getValorDaCompra())+"\n"+
                "Saldo: R$ "+ d1.format(getSaldo())+"\n"+
                "Crédito total: R$ "+ d1.format(calcularCredito())+"\n"+
                "-------------------------------------------"+"\n";
    }
    
}
