//PEDRO BOSINI FREITAG
package viagem;

import java.util.Date;

import passageiro.Passageiro;

public class Municipal extends Viagem {
    private static int capacidadeMaxima = 65;
    
    public Municipal(String placaOnibus, String nomeMotorista, Date dataViagem, String tipoViagem){
        super(placaOnibus, nomeMotorista, dataViagem, capacidadeMaxima, tipoViagem);
    };

    @Override
    public void addPassageiro(Passageiro passageiro) {
        super.addPassageiro(passageiro);
    }
    
}
