package Modelo;
import java.text.DateFormat;
import java.text.DecimalFormat;

public class Funcionario extends Pessoa {
    private double salarioBase;
    private double imposto;

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    
    public double calcularSalario(){
        return this.salarioBase - this.salarioBase * this.imposto / 100;
    }

    @Override
    public String toString() {
        DecimalFormat d1 = new DecimalFormat("#,##0.00");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataFormatada = null;
        if(getDataNascimento() != null){
            dataFormatada = df.format(getDataNascimento());
        }
        return "Funcionário \n"+
                "------------------------------------------- \n"+
                "Nome: "+ getNome()+"\n"+
                "CPF: "+ getCpf()+"\n"+
                "Data de Nascimento: "+ dataFormatada +"\n"+
                "Endereço: "+ getEndereco()+"\n"+
                "Salário Base: R$ "+ d1.format(getSalarioBase())+"\n"+
                "Imposto: "+ d1.format(getImposto())+"%\n"+
                "Salário Líquido: R$ "+ d1.format(calcularSalario())+"\n"+
                "-------------------------------------------";
    }
    
}
