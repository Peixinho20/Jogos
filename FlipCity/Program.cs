using System;
using System.Collections.Generic;

public class Jogo{
    // listas para armazenar as jogo.mao[i]s
    public List<string> mao = new List<string>();
    public List<string> descarte = new List<string>();

    public int ouro = 0;
    public int ouroBonus = 0;
    public int insatisfacao = 0;
    public int pv = 0;
    
    public Jogo() {}//construtor

    // Método para embaralhar as cartas
    public List<string> Embaralhar (List<string> deck){
        Random rng = new Random();
        List<string> deckEmbaralhado = new List<string>();
        int size = deck.Count;

        for (int i = 0; i < size; i++)
        {
            int randomIndex = rng.Next(size -i);
            deckEmbaralhado.Add(deck[randomIndex]);
            deck.RemoveAt(randomIndex);
            
        } return deckEmbaralhado;
    }

    public void AplicarEfeito(string carta){
        switch(carta){
            case "Area Residencial":
                ouro += 1;
	        insatisfacao += 1;
	        break;
	    
	    case "Apartamento":
	        Console.WriteLine($"Caso possa vire esta carta e coloque-a na pilha de descarte de outro jogador.");
	        ouro += 1;
	        insatisfacao += 1;
	        break;
	        
	    case "Loja de Conveniencia":
	        Console.WriteLine($"Se você jogar 18 cartas ou mais nesse turno, você vence!");
	        ouro += 1;
	        break;
	
	    case "Hospital":
	        insatisfacao += 1; // inclui a insatisfação da própria carta
                ouroBonus = insatisfacao;
                ouro += ouroBonus;
                Console.WriteLine("Ganhe +1 de ouro para cada insatisfação que você acumulou até agora neste turno, incluindo o desta carta.");
                break;
        
            case "Fabrica":
                Console.WriteLine($"Se o baralho não estiver vazio, coloque a carta do fundo em sua pilha de descarte.");
	        ouro += 2;
	        break;
                
            case "Parque":
                Console.WriteLine($"Em sua fase de consrução, além da ação escolhida, você também pode comprar 1 carta.");
	        pv += 1;
	        break;
	}
	Console.WriteLine($"Ouro: {ouro}");
        Console.WriteLine($"Insatisfação: {insatisfacao}");
        Console.WriteLine($"Pontos de Vitória: {pv}");
    }
}

//Programa em execução
public class Program{
    public static void Main(){
        List<string> deck = new List<string> {
        "Area Residencial","Area Residencial","Area Residencial","Area Residencial", "Apartamento", "Loja de Conveniencia","Hospital", "Fabrica", "Parque"
        };

        Jogo jogo = new Jogo(); //instanciação do construtor
        jogo.mao = jogo.Embaralhar(deck);
        
        for (int i = 0; i < jogo.mao.Count; i++){
    	    string cartaAtual = jogo.mao[i];

	    Console.WriteLine($"Carta Atual: {cartaAtual}");

    	    // Aplica o efeito da carta atual
    	    jogo.AplicarEfeito(cartaAtual);

	    if (jogo.insatisfacao >= 3){
                 Console.WriteLine("\nVocê atingiu 3 insatisfações. Seu turno termina agora!");
        	break; // encerra o turno
    	    }
  	    
	    // Se ainda houver próxima carta
    	    if (i + 1 < jogo.mao.Count){
                string proximaCarta = jogo.mao[i + 1];
                Console.WriteLine($"\nPróxima: {proximaCarta}");

                // Se for Área Residencial, joga automaticamente no próximo loop
                if (proximaCarta == "Area Residencial"){
                Console.WriteLine("A próxima carta é uma Área Residencial e será jogada automaticamente.");
                continue;  // vai para o próximo loop direto
            }

                // Caso contrário, espera o jogador
                Console.WriteLine("Pressione enter para jogar a próxima carta...");
                Console.ReadLine();
    	    }else{
                Console.WriteLine("Fim das cartas.");
    	    } 
    	}
    }
}
