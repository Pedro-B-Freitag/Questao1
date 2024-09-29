//PEDRO BOSINI FREITAG
package passageiro;
public class Idoso extends Passageiro {
    private String RG;

    public Idoso(String nome, int idade, String RG) {
        super(nome, idade);
        this.RG = RG;
    }
    @Override
    public float getTarifa() {
        return 0;
    }

    public String getRG() {
        return RG;
    }
    public void setRG(String rg) {
        RG = rg;
    }

    
}