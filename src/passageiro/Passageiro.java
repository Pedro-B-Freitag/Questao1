//PEDRO BOSINI FREITAG
package passageiro;
public class Passageiro{
    protected String nome;
    protected int idade;
    private float tarifaInteira = 5;

    public Passageiro(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public float getTarifa(){
        return tarifaInteira;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
