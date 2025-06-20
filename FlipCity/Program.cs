using System;
using System.Collections.Generic;

public class Jogo{
    // listas para armazenar as cartas
    public List<string> mao = new List<string>();
    public List<string> mesa = new List<string>();
    public List<string> descarte = new List<string>();
    public List<string> descarteTemp = new List<string>();

    public int ouro = 0;
    public int ouroBonus = 0;
    public int insatisfacao = 0;
    public int cartasMesa = 0;
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
	        cartasMesa += 1;
	        break;
	    
	    case "Apartamento":
	        Console.WriteLine($"Caso possa vire esta carta e coloque-a na pilha de descarte de outro jogador.");
	        ouro += 1;
	        insatisfacao += 1;
	        cartasMesa += 1;
	        break;
	        
	    case "Loja de Conveniencia":
	        Console.WriteLine($"Se você jogar 18 cartas ou mais nesse turno, você vence!");
	        ouro += 1;
	        cartasMesa += 1;
	        break;
	
	    case "Hospital":
	        insatisfacao += 1; // inclui a insatisfação da própria carta
                ouroBonus = insatisfacao;
                ouro += 1+ouroBonus;
                cartasMesa += 1;
                Console.WriteLine("Ganhe +1 de ouro para cada insatisfação que você acumulou até agora neste turno, incluindo o desta carta.");
                break;
        
            case "Fabrica":
                Console.WriteLine($"Se o baralho não estiver vazio, coloque a carta do fundo em sua pilha de descarte.");
                cartasMesa += 1;
	        ouro += 2;
	        break;
                
            case "Parque":
                Console.WriteLine($"Em sua fase de consrução, além da ação escolhida, você também pode comprar 1 carta.");
                cartasMesa += 1;
	        pv += 2;
	        break;
	}
	MostrarEstado();
    }

    public void MostrarEstado(){
    	Console.WriteLine($"Ouro: {ouro}");
        Console.WriteLine($"Insatisfação: {insatisfacao}");
        Console.WriteLine($"Pontos de Vitória: {pv}");
        Console.WriteLine($"Cartas na mesa: {cartasMesa}");
    }

    public void JogarCarta(string carta){
        mao.RemoveAt(0);
        mesa.Add(carta);
        Console.WriteLine($"\nCarta Atual: {carta}");
        AplicarEfeito(carta);
    }
    
    public void ComprarCarta(Dictionary<string,cartaEstoque> estoque){
	var nomesCartas = new List<string>(estoque.Keys);

        Console.WriteLine("\nCartas disponíveis para compra:");
        for(int i=0; i< nomesCartas.Count; i++){
            var c = estoque[nomesCartas[i]];
            Console.WriteLine($"[{i+1}] {nomesCartas[i]} - Quantidade: {c.Quantidade}, Custo: {c.Custo} ouros");
        } 
	Console.WriteLine($"\nVoce tem {ouro} ouros");  
	Console.WriteLine($"Digite o número da carta para comprar (ENTER para cancelar a compra): ");
	string? entrada = Console.ReadLine();

	if(string.IsNullOrWhiteSpace(entrada)){
	    Console.WriteLine($"Compra cancelada");
	}
	if(int.TryParse(entrada, out int iCarta) && iCarta >= 1 && iCarta <= nomesCartas.Count){
	    string nome = nomesCartas[iCarta - 1];
	    var carta = estoque[nome];
	    
	    if(carta.Quantidade <=0 ){
	        Console.WriteLine($"Carta esgotada");
	    }
	    else if(ouro < carta.Custo){
	        Console.WriteLine($"Ouro insuficiente");
	    }
	    else{
	        ouro -= carta.Custo;
	        carta.Quantidade--;
	        descarteTemp.Add(nome);
	        Console.WriteLine($"Você comprou '{nome}' e ela será adicionada ao descarte no final do seu turno.");
	    }
	}else{
	    Console.WriteLine($"Opção inválida");
	}
    }
    
    public void ExecutarTurno(Dictionary<string,cartaEstoque> estoque){
    	while (mao.Count > 0){
    	    string cartaAtual = mao[0];
	    JogarCarta(cartaAtual);
	    
	    if (insatisfacao >= 3){
                 Console.WriteLine("\nVocê atingiu 3 insatisfações. Seu turno termina agora!");
        	break; // encerra o turno
    	    }

	    // Se ainda houver próxima carta
    	    if (mao.Count > 0){
                string proximaCarta = mao[0];
                Console.WriteLine($"Próxima: {proximaCarta}");

                // Se for Área Residencial, joga automaticamente no próximo loop
                if (proximaCarta == "Area Residencial"){
                    Console.WriteLine("\nA próxima carta é uma Área Residencial e será jogada automaticamente.");
                    continue;  // vai para o próximo loop direto
                }

                // Caso contrário, espera o jogador
                Console.WriteLine("\nEscolha uma opção: \n[1] Próxima carta \n[2] Construir");
                string? escolha = Console.ReadLine();
                
                if(escolha == "1"){
                    continue;
                }else if (escolha == "2"){
                    ComprarCarta(estoque);
                    break;
                }else{
                    Console.WriteLine($"Opção inválida");
		    break;
                }
    	    }else{
                Console.WriteLine("Fim das cartas.");
    	    } 
    	}
    	FinalizarTurno(); //adiciona as cartas compradas durante o turno ao descarte
    }

    public void FinalizarTurno(){
        if( descarteTemp.Count > 0){
            descarte.AddRange(descarteTemp);
            descarteTemp.Clear();
        }

	if(mesa.Count > 0){
	    descarte.AddRange(mesa);
	}
	ouroBonus = 0;
	insatisfacao = 0;
	mesa.Clear();
    }
}

public class cartaEstoque{
    public string Nome {get; set;}
    public int Quantidade {get; set;}
    public int Custo {get; set;}
    
    public cartaEstoque(string nome, int quantidade, int custo){
    	Nome = nome;
    	Quantidade = quantidade;
    	Custo = custo;
    }
}

//Programa em execução
public class Program{
    public static void Main(){
	Dictionary<string, cartaEstoque> estoque = new Dictionary<string, cartaEstoque> {
	    ["Loja de Conveniencia"] = new cartaEstoque("Loja de Conveniencia",12,2),
	    ["Hospital"] = new cartaEstoque("Hospital",12,4),
	    ["Fábrica"] = new cartaEstoque("Fábrica",8,5),
	    ["Parque"] = new cartaEstoque("Parque",8,7)
	};
	
        List<string> deck = new List<string> {
            "Area Residencial","Area Residencial","Area Residencial","Area Residencial", "Apartamento", "Loja de Conveniencia","Hospital", "Fabrica", "Parque"
        };

        Jogo jogo = new Jogo(); //instanciação do construtor
        jogo.mao = jogo.Embaralhar(deck);
        jogo.ExecutarTurno(estoque);
    }
}


