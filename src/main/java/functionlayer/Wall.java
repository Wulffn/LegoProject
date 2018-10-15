/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

import java.util.List;

/**
 *
 * @author mwn
 */
public class Wall {
    
    private String wallName;
    private List<Brick> wallBricks;
    private int smallBricks;
    private int mediumBricks;
    private int largeBricks;

    public Wall(String wallName, List<Brick> wallBricks, int smallBricks, int mediumBricks, int largeBricks) {
        this.wallName = wallName;
        this.wallBricks = wallBricks;
        this.smallBricks = smallBricks;
        this.mediumBricks = mediumBricks;
        this.largeBricks = largeBricks;
    }

    public String getWallName() {
        return wallName;
    }

    public void setWallName(String wallName) {
        this.wallName = wallName;
    }

    public List<Brick> getWallBricks() {
        return wallBricks;
    }

    public void setWallBricks(List<Brick> wallBricks) {
        this.wallBricks = wallBricks;
    }

    public int getSmallBricks() {
        return smallBricks;
    }

    public void setSmallBricks(int smallBricks) {
        this.smallBricks = smallBricks;
    }

    public int getMediumBricks() {
        return mediumBricks;
    }

    public void setMediumBricks(int mediumBricks) {
        this.mediumBricks = mediumBricks;
    }

    public int getLargeBricks() {
        return largeBricks;
    }

    public void setLargeBricks(int largeBricks) {
        this.largeBricks = largeBricks;
    }
    
    
    
    
}
