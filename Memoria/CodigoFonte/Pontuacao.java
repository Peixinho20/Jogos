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
        imagem.setFont(new Font("Comic Sans MS",true,false /*Font.BOLD*/, 34));
        imagem.drawString(pontuacaoTotal + " Pontos", 9, 70);
        setImage(imagem);
    }
    
    public void setPontuacao(int pontuacao){
        pontuacaoTotal += pontuacao;
        imagem.clear();
        imagem.setColor(Color.WHITE);
        //caso os texto voltem a desaparecer, mexa nas suas posições x e y 
        imagem.setFont(new Font("Comic Sans MS",true,false /*Font.BOLD*/, 34));
        imagem.drawString(pontuacaoTotal + " Pontos", 10, 70);
        imagem.setFont(new Font("Comic Sans MS", true,false /*Font.PLAIN*/, 14));
        imagem.drawString("< Clique aqui para continuar >", 9, 100);
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
