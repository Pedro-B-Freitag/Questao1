//PEDRO BOSINI FREITAG
import java.util.ArrayList;
import java.util.List;

import passageiro.Passageiro;
import viagem.Viagem;

public class Empresa {
    
    private List<Viagem> viagens;

    public Empresa() {
        this.viagens = new ArrayList<>();
    }

    public List<Passageiro> getPassageirosMaisIdosos(){
        List<Passageiro> maisIdosos = new ArrayList<>();
        int maiorIdade = 0;

        for (Viagem viagem : viagens) {
            for (Passageiro passageiro : viagem.getPassageiros()) {
                if (passageiro.getIdade() > maiorIdade) {
                    maiorIdade = passageiro.getIdade();
                    maisIdosos.clear();
                    maisIdosos.add(passageiro);
                } else if (passageiro.getIdade() == maiorIdade) {
                    maisIdosos.add(passageiro);
                }
            }
        }

        return maisIdosos;
    }
    public void adicionarViagem(Viagem viagem) {
        viagens.add(viagem);
    }
    public List<Viagem> getViagens(){
        return viagens;
    }
}
