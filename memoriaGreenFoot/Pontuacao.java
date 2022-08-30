import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;


public class Pontuacao extends Actor{
    private Mundo w;
    GreenfootImage imagem;
    JLabel imagem;
    //public final static int PLAIN;
    //public final static int BOLD;
    
    public Pontuacao(Mundo w){
        this.w = w;
        imagem = new GreenfootImage("images/quadro.png");
        //imagem.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
       
        setImage(imagem);
    }
    
    public void setPontuacao(int pontuacao){
        imagem.setColor(Color.WHITE);
        imagem.drawString(pontuacao + " Scored", 18, 84);
        //imagem.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        imagem.drawString("< Clique para jogar de novo (Click to Play Again) >", 10, 130);
    }
    
    public void act(){
        if(Greenfoot.mousePressed(this)){
            w.removeObject(this);
            w.comecarNovoJogo();
        }
    }
}
