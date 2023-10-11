
package abstracao;


public class Pessoa {

    //atributos
    String nome;
    int idade;
    boolean estaVivo;
    
    //construtores
     Pessoa() {
       
    }
    
     Pessoa(String nomePessoa,int idadePessoa) {
         //atributo da classe
         this.nome = nomePessoa;
         this.idade = idadePessoa;
         
     }
    
     Pessoa(boolean vivoOuMorto) {
         this.estaVivo = vivoOuMorto;
         
     }
    
     Pessoa(boolean vivoMorto,int idadeDoIndividuo) {
         this.estaVivo = vivoMorto;
         this.idade = idadeDoIndividuo;
     }
 
    
    public static void main(String[] args) {
        //primeiro objeto
        Pessoa ind1 = new Pessoa();
        ind1.estaVivo = true;
        ind1.idade = 20;
        ind1.nome = "Abel";
        
        
        //segundo objeto
        Pessoa ind2 = new Pessoa(true);
        
        
        //terceiro objeto
        Pessoa ind3 = new Pessoa("Abel", 20);
        
        
        //quarto objeto
        Pessoa ind4 = new Pessoa(false, 80);
        
        
    }
    
}
