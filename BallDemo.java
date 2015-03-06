import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simula bolas rebotando.
     * La cantidad minima es 1.
     * 
     * @param bolas Cantidad de bolas que se veran rebotar
     */
    public void bounce(int bolas)
    {
        int ground = 400;   // position of the ground line
        int redColor, greenColor, blueColor;
        int posX, posY, diametro;
        Random aleatorio = new Random();
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall[] balls;
        if(bolas < 1){
            balls = new BouncingBall[1];
        }else{
            balls = new BouncingBall[bolas];
        }
        
        for (int i=0; i < balls.length; i++){
            posX = ((aleatorio.nextInt(200)) + 10);
            posY = ((aleatorio.nextInt(170)) + 10);
            diametro = ((aleatorio.nextInt(40)) + 30);
            redColor = aleatorio.nextInt(256);
            greenColor = aleatorio.nextInt(256);
            blueColor = aleatorio.nextInt(256);
            balls[i] = new BouncingBall(posX, posY, diametro, new Color(redColor, greenColor, blueColor), ground, myCanvas);
            balls[i].draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (int indice = 0; indice < balls.length; indice++){
                balls[indice].move();
                // stop once ball has travelled a certain distance on x axis
                if(balls[indice].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    
    /**
     * Simula cajas rebotando.
     * La cantidad minima es 1.
     * 
     * @param cajas Cantidad de cajas que se veran rebotar
     */
    public void boxBounce(int cajas)
    {
        int roof = 100; // position of the roof line
        int ground = 400;   // position of the ground line
        int left = 50;
        int right = 550;
        int redColor, greenColor, blueColor;
        int posX, posY, diametro;
        Random aleatorio = new Random();
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawBox(left, ground, right, ground, left, roof, right, roof);

        // crate and show the balls
        BoxBall[] balls;
        if(cajas < 1){
            balls = new BoxBall[1];
        }else{
            balls = new BoxBall[cajas];
        }
        
        for (int i=0; i < balls.length; i++){
            posX = ((aleatorio.nextInt(200)) + roof);
            posY = ((aleatorio.nextInt(170)) + left);
            diametro = ((aleatorio.nextInt(40)) + 30);
            redColor = aleatorio.nextInt(256);
            greenColor = aleatorio.nextInt(256);
            blueColor = aleatorio.nextInt(256);
            balls[i] = new BoxBall(posX, posY, diametro, new Color(redColor, greenColor, blueColor), roof, ground, left, right, myCanvas);
            balls[i].draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (int indice = 0; indice < balls.length; indice++){
                balls[indice].move();
                // stop once ball has travelled a certain distance on x axis
                if(balls[indice].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
