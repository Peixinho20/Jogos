import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import greenfoot.Font;

/**
 * Write a description of class JanelaFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JanelaFinal extends Actor
{
   //caracteristicas da mensagem e da sua janela
   public static final float TAM_FONTE = 48.0f;
   public static final int LARGURA = 400;
   public static final int ALTURA = 300;
   
   //construtor da classe para informar ao usuario que o jogo finalizou
   public JanelaFinal(String mensagem){
       makeImage(mensagem);
   }//esse construtor que vai criar a janela da msg
   
   //esse construtor vai dar essas caracteristicas a essa janela
   private void makeImage(String mensagem) {
       GreenfootImage image = new GreenfootImage(LARGURA, ALTURA);
       //repetiçao de sets e fills para dar a sensaçao de retangulo com bord
       image.setColor(new Color(0, 0, 0, 160));
       image.fillRect(0, 0, LARGURA, ALTURA);
       image.setColor(new Color(255,255, 255, 100));
       image.fillRect(5, 5, LARGURA-10, ALTURA-10);
       
       Font font = image.getFont();
       font = font.deriveFont(TAM_FONTE);
       
       image.setFont(font);
       image.setColor(Color.WHITE);
       image.drawString(mensagem, 60, 100);
       setImage(image);
    }
}
