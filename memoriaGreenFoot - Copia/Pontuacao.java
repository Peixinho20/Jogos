import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Pontuacao extends Actor{
    private Mundo w;
    GreenfootImage imagem;
    private boolean fimDeRodada=false;
    private int pontuacaoTotal;
    
    public Pontuacao(Mundo w){
        this.w = w;
        pontuacaoTotal = 0;
        imagem = new GreenfootImage("images/quadro.png");
        imagem.clear();
        imagem.setColor(Color.WHITE);
        imagem.setFont(new Font("Comic Sans MS",true,false /*Font.BOLD*/, 44));
        imagem.drawString(pontuacaoTotal + " Scored", 10, 84); //ver se eu consigo colocar isso durante todo o jogo
        setImage(imagem);
    }
    
    public void setPontuacao(int pontuacao){
        pontuacaoTotal += pontuacao;
        imagem.clear();
        imagem.setColor(Color.WHITE);
        imagem.setFont(new Font("Comic Sans MS",true,false /*Font.BOLD*/, 44));
        imagem.drawString(pontuacaoTotal + " Scored", 10, 84); //ver se eu consigo colocar isso durante todo o jogo
        imagem.setFont(new Font("Comic Sans MS", true,false /*Font.PLAIN*/, 14));
        imagem.drawString("< Clique para jogar de novo (Click to Play Again) >", 10, 130);
        fimDeRodada = true;
        
    }
    
    public void act(){
        if(fimDeRodada){
            if(Greenfoot.mousePressed(this)){
                w.comecarNovoJogo();
                fimDeRodada=false;
            }
        }
    }
}
