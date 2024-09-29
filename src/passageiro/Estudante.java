//PEDRO BOSINI FREITAG
package passageiro;
public class Estudante extends Passageiro {
    private String escola;
    public Estudante (String nome, int idade, String escola){
        super(nome, idade);
        this.escola = escola;
    }
    public String getEscola() {
        return escola;
    }
    public void setEscola(String escola) {
        this.escola = escola;
    }
    @Override
    public float getTarifa() {
        return (float) 2.5;
    }
    
}