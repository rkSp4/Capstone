package res.Tile;

import Game_Project.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel qp;
    Tile[] tile;

    public TileManager(GamePanel qp) {
        this.qp = qp;

        tile = new Tile[10];
        getTileImage();

    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/stone_tile.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0; int row = 0; int x = 0; int y = 0;

        while(col < qp.maxScreenCol && row < qp.maxScreenRow){
            g2.drawImage(tile[0].image, x, y,qp.tileSize, qp.tileSize, null);
            col++;

            x += qp.tileSize;

            if(col == qp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += qp.tileSize;
            }
        }
    }
}
