import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Pontuacao extends Actor{
    private Mundo w;
    GreenfootImage imagem;
    
    public Pontuacao(Mundo w){
        this.w = w;
        imagem = new GreenfootImage("images/quadro.png");
        imagem.setFont(new Font("Comic Sans MS",true,false /*Font.BOLD*/, 44));
       
        setImage(imagem);
    }
    
    public void setPontuacao(int pontuacao){
        imagem.setColor(Color.WHITE);
        imagem.drawString(pontuacao + " Scored", 18, 84); //ver se eu consigo colocar isso durante todo o jogo
        imagem.setFont(new Font("Comic Sans MS", true,false /*Font.PLAIN*/, 14));
        imagem.drawString("< Clique para jogar de novo (Click to Play Again) >", 10, 130);
    }
    
    public void act(){
        if(Greenfoot.mousePressed(this)){
            w.removeObject(this);
            w.comecarNovoJogo();
        }
    }
}
