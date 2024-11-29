package Entity;

import Game_Project.GamePanel;
import Game_Project.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    public GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefValue();
        getPlayerImage();
    }

    public void setDefValue(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/North.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/North.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/res/South.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/South.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/res/East.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/East.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/res/West.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/West.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){

        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }else if(keyH.downPressed == true){
            direction = "down";
            y += speed;
        }else if(keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }else if(keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }

    }

    public void draw(Graphics2D a2){
        // a2.setColor(Color.red);
        // a2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = up1;

        switch(direction){

            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;

        }
        a2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
