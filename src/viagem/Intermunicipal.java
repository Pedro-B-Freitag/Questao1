//PEDRO BOSINI FREITAG
package viagem;

import java.util.Date;

import passageiro.Passageiro;

public class Intermunicipal extends Viagem {
    private static int capacidadeMaxima = 45;

    public Intermunicipal(String placaOnibus, String nomeMotorista, Date dataViagem, String tipoViagem){
        super(placaOnibus, nomeMotorista, dataViagem, capacidadeMaxima, tipoViagem);
    };

    @Override
    public void addPassageiro(Passageiro passageiro) {
        super.addPassageiro(passageiro);
    }
    @Override
    public float getValorTotal(){
        float total = 0;
        for(Passageiro passageiro : passageiros){
            total += passageiro.getTarifa() + 3.15;
        }
        return total;
    };
}
