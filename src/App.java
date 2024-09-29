//PEDRO BOSINI FREITAG
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import passageiro.Estudante;
import passageiro.Idoso;
import passageiro.Passageiro;
import viagem.Intermunicipal;
import viagem.Municipal;
import viagem.Viagem;

public class App {
    public static void main(String[] args) {
        
        Empresa empresa = new Empresa();
        Scanner s = new Scanner(System.in);
        boolean executar = true;
        System.out.println("Olá");

        while(executar){
            System.out.println("---------------------------------------------------------------");
            System.out.println("SELECIONE:\n 1. Criar viagem\n" + //
                            " 2. Adicionar passageiro\n" + //
                            " 3. Consultar valor arrecadado\n" + //
                            " 4. Consultar Passageiro mais idoso\n" + //
                            " 5. Sair");
            int opcao = s.nextInt();
            System.out.println("---------------------------------------------------------------");
            switch (opcao) {
                case 1:

                    System.out.println("Tipo de viagem:\n" + //
                                       " 1.Municipal\n" + //
                                       " 2.Intermunicipal");
                    int opcaoViagem = s.nextInt();
                    Viagem viagem = criarViagem(s, opcaoViagem);
                    empresa.adicionarViagem(viagem);
                    break;
                case 2:
                    System.out.println("Selecione a Viagem: ");
                    List<Viagem> viagens = empresa.getViagens();
                    if(viagens.size() == 0){
                        System.out.println("Nenhuma viagem cadastrada.");
                        break;
                    }
                    System.out.println(0 + "- Voltar");
                    int contador = 0;
                    for(Viagem v : viagens){
                        contador = contador + 1;
                        System.out.println(contador + "- " + v.getTipoViagem() + " | Nome do Motorista: " + v.getNomeMotorista() +
                        " | Placa do Onibus: " + v.getPlacaOnibus());
                    }
                    int indexViagem = s.nextInt();
                    if(indexViagem == 0){
                        break;
                    }else{
                        System.out.println("SELECIONE:\n 1. Passagem Inteira\n 2. Passagem Estudante\n 3. Passagem Idoso");
                        int opcaoIdade = s.nextInt();
                        try{
                            Passageiro passageiro = criarPassageiro(s, opcaoIdade);
                            
                            empresa.getViagens().get(indexViagem-1).addPassageiro(passageiro);
                        }catch (Exception e){
                            System.out.println("Erro: "+ e.getMessage());
                        }
                    }
                    
                    break;
                case 3:
                    System.out.println("Selecione a Viagem: ");
                    List<Viagem> valorArrecadado = empresa.getViagens();
                    if(valorArrecadado.size() == 0){
                        System.out.println("Nenhuma viagem cadastrada.");
                        break;
                    }
                    contador = 0;
                    for(Viagem v : valorArrecadado){
                        contador = contador + 1;
                        System.out.println(contador + "- " + v.getTipoViagem() + " | Nome do Motorista: " + v.getNomeMotorista() +
                        " | Placa do Onibus: " + v.getPlacaOnibus());
                    }
                    indexViagem = s.nextInt();
                    Viagem viagemConsulta = empresa.getViagens().get(indexViagem-1);
                    System.out.println("Valor total Arrecadado: R$" + viagemConsulta.getValorTotal());
                    break;
                case 4:
                    List<Passageiro> passageiroMaisIdoso = empresa.getPassageirosMaisIdosos();
                    for(Passageiro p : passageiroMaisIdoso) {
                        System.out.println("Passageiro mais idoso: \n"+" Nome: " + p.getNome() + " | Idade: " + p.getIdade());
                    }
                    
                    break;
                case 5:
                    System.out.println("Saindo...");
                    executar = false;
                    s.close();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
            


        
    }

    private static Passageiro criarPassageiro(Scanner s, int opcaoIdade) {
        System.out.println("Insira o seu Nome: ");
        String nome = s.next();
        System.out.println("Insira a sua Idade: ");
        int idade = s.nextInt();

        switch (opcaoIdade) {
            case 1:
                return new Passageiro(nome, idade); 
            case 2:
                System.out.println("Insira a sua escola: ");
                String escola = s.next();
                return new Estudante(nome, idade, escola);
            case 3:
                if(idade < 60){
                    throw new IllegalArgumentException("Idade do passageiro não pode ser menor que 60!");
                }
                System.out.println("Insira o seu RG: ");
                String RG = s.next();
                return new Idoso(nome, idade, RG);
            default:
                throw new IllegalArgumentException("Opção inválida para tipo de passagem.");
        }
        
    }

    private static Viagem criarViagem(Scanner s, int opcaoViagem) {
        Viagem viagem = null;
        String tipoViagem;

        System.out.println("Insira a placa do ônibus: ");
        String placaOnibus = s.next();
        System.out.println("Insira o nome do motorista: ");
        String nomeMotorista = s.next();
        Date dataViagem = new Date();

        switch (opcaoViagem) {
            case 1:
                tipoViagem = "Municipal";
                viagem = new Municipal(placaOnibus, nomeMotorista, dataViagem, tipoViagem);
                break;
            case 2:
                tipoViagem = "Intermunicipal";
                viagem = new Intermunicipal(placaOnibus, nomeMotorista, dataViagem, tipoViagem);
                break;
            default:
                System.out.println("Opção inválida para tipo de viagem.");
                break;
        }
        
        return viagem;   
    }
    
}