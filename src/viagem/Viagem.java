//PEDRO BOSINI FREITAG
package viagem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import passageiro.Passageiro;

public class Viagem{
    protected List<Passageiro> passageiros;
    private int capacidadeMaxima;
    private String placaOnibus;
    private String nomeMotorista;
    private Date dataViagem;
    private String tipoViagem;

    public Viagem(String placaOnibus, String nomeMotorista, Date dataViagem, int capacidadeMaxima, String tipoViagem) {
        this.placaOnibus = placaOnibus;
        this.nomeMotorista = nomeMotorista;
        this.dataViagem = dataViagem;
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageiros = new ArrayList<>();
        this.tipoViagem = tipoViagem;
    }

    public void addPassageiro(Passageiro passageiro){
       if(passageiros.size() < capacidadeMaxima){
        passageiros.add(passageiro);
       } else{
        throw new IllegalStateException("Quantidade maxima de passageiros atingida!");
       }
    }

    public float getValorTotal(){
        float total = 0;
        for(Passageiro passageiro : passageiros){
            total += passageiro.getTarifa();
        }
        return total;
    };


    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getPlacaOnibus() {
        return placaOnibus;
    }

    public void setPlacaOnibus(String placaOnibus) {
        this.placaOnibus = placaOnibus;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public Date getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Date dataViagem) {
        this.dataViagem = dataViagem;
    }

    public String getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(String tipoViagem) {
        this.tipoViagem = tipoViagem;
    }
    

}