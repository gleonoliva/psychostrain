
//Map.java

package PsychoGame;

import PsychoSystem.FileLoader;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Observable;

//  PsySoft Team 2008
//       (Manuel Espinoza, Alberto Zorrilla, Guillermo Leon y Arquimides Diaz)

public class Map extends Observable{
    public int scaleTile, xi, difx, noTilesWidth, noTilesHeight;
    public int mapMatrix[][],escala = 30,mailCounter=0;
    private BufferedImage mapCanvas;
    private HashMap<Integer,BufferedImage> tiles;
    private HashMap<Integer,String> mails;
    private long time=System.currentTimeMillis();
    public static int nxtlvl=1;

 
    //Constructor nuevo, adaptandose a ser modulable
    public Map (String mapName, int escala, int windowWidth, int windowHeight){
        scaleTile=escala;
        noTilesWidth = (windowWidth%scaleTile==0)? windowWidth/scaleTile:(windowWidth+(windowWidth%scaleTile))/scaleTile;
        noTilesHeight = (windowHeight%scaleTile==0)? windowHeight/scaleTile:windowHeight/scaleTile+1;
        noTilesWidth++;
        xi = difx = 0;
        tiles = FileLoader.getTiles("tiles/tileList.cfg");
        mapMatrix=FileLoader.getMap(mapName);
        //enemies.add(new EnemyChainRobot("EnemyChainRobot.txt", "enemy/ChainRobot", 3000, 100, 10));
        //enemies.add(new EnemyClawRobot("EnemyClawRobot.txt", "enemy/ClawRobot", 3000, 100, 10));
        setImage();
    }

    public Map (String mapName, int escala, int windowWidth, int windowHeight, int diffx){
        scaleTile=escala;
        noTilesWidth = (windowWidth%scaleTile==0)? windowWidth/scaleTile:(windowWidth+(windowWidth%scaleTile))/scaleTile;
        noTilesHeight = (windowHeight%scaleTile==0)? windowHeight/scaleTile:windowHeight/scaleTile+1;
        noTilesWidth++;
        difx = diffx;
        xi = (difx/scaleTile);
        tiles = FileLoader.getTiles("tiles/tileList.cfg");
        mapMatrix=FileLoader.getMap(mapName);
        //enemies.add(new EnemyChainRobot("EnemyChainRobot.txt", "enemy/ChainRobot", 1000, 100, 10));
        //enemies.add(new EnemyClawRobot("EnemyClawRobot.txt", "enemy/ClawRobot", 1000, 100, 10));
        setImage();
    }

    private void setImage(){
        mapCanvas = new BufferedImage(mapMatrix[0].length*scaleTile, mapMatrix.length*scaleTile, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = mapCanvas.createGraphics();
        for(int i = 0; i < mapMatrix.length; i++){
            for(int j = 0; j < mapMatrix[0].length; j++){
                    g.drawImage(tiles.get(new Integer(mapMatrix[i][j])), j*escala,i*escala,Engine.window);
            }
        }
        g.dispose();
        g.finalize();
    }
    
     
     
    public BufferedImage getImage(){
        if(difx < 0){
            BufferedImage aux = new BufferedImage(768, 480, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = aux.createGraphics();
            g.drawImage(mapCanvas.getSubimage(0, 0, 768+difx, 480), -difx, 0, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, -difx, 480);
            g.dispose();
            g.finalize();
            return aux;
        }
        if(difx+768 > mapCanvas.getWidth()){
            BufferedImage aux = new BufferedImage(768, 480, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = aux.createGraphics();
            g.drawImage(mapCanvas.getSubimage(difx, 0, mapCanvas.getWidth()-difx, 480), 0, 0, null);
            g.setColor(Color.BLACK);
            g.fillRect(mapCanvas.getWidth()-difx, 0, 768, 480);
            g.dispose();
            g.finalize();
            return aux;
        }
        return mapCanvas.getSubimage(difx, 0, 768, 480);
    }

    public void clearTile(int k, int j){
        Graphics2D g = mapCanvas.createGraphics();
        g.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.CLEAR, 0.0f));
        g.fillRect(j*scaleTile,k*scaleTile, scaleTile, scaleTile);
        g.dispose();
        g.finalize();
    }
    
    public int getDifxModule(){
        return difx%scaleTile;
    }
    
    public void moveVisibleMatrixRight(int dx){ //Cuanto se debe de mover.
        for(int i = 0; i < dx; i++){
            difx++;
            setChanged();
            notifyObservers();
        }
    }
    
    public void moveVisibleMatrixLeft(int dx){ //Cuanto se debe de mover...
        for(int i = 0; i < dx; i++){
            difx--;
            setChanged();
            notifyObservers();
        }
    }

 public boolean specialTiles2(int k,int j,boolean x){
        int i = mapMatrix[k][j];   
        if(i==0 || i==10 || i == 11 ||i==13){
          return true;
        }
        if(i==15){
            Engine.setNanoContainers(Engine.getNanoContainers()+1);
            clearTile(k,j);
              mapMatrix[k][j] = 0;

        }
        if(i==28){
            
            if(Console.challenge){
                return true;
            }else{
                return false;
            }
            
                    
        }
        if(i==29 || i==31 || i==32){
            Engine.nextLevel(nxtlvl);
            Engine.setKeys();
            Console.challenge=false;
            set00Tiles(k,j,29);
            
            return true;
        }
        if(i>=17 && i<=27){
            return true;
        }
        
         if(x){
        if(i==8){
       
            
           
            mails=FileLoader.loadMails("mails.txt");
            Engine.cmd.setEmail("hq@bash.org", mails.get(mailCounter));
            mailCounter++;
            set00Tiles(k,j,8);
            return true;
        }
        
          if(i==14){
            Engine.hpaux-=50;
            clearTile(k,j);
            mapMatrix[k][j]=0;
            return true;
        }
        if(i==9){
            
            while(i==9){
                if(this.lifeMenosMenosTiming(200)){
                Engine.hpaux+=10;
                time=System.currentTimeMillis();
            }
            return true;
            }
            
        }
        }

        if(i==1){
            if (x) {
              Engine.weapon.setGun(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            }else{
              return true;
            }
        } if(i==2){
            if (x) {
              Engine.weapon.setShotgun(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            }else{
              return true;
            }
        } if(i==3){
            if (x) {
              Engine.weapon.setRifle(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            }else{
              return true;
            }
        } if(i==4){
            if (x) {
              Engine.weapon.setGrandelauncher(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            }else{
              return true;
            }
        } if(i==16){
            if (x) {
               switch (Engine.currentWeapon) {
                  case 1: break;
                  case 2: Engine.weapon.setAmmo(true); break;
                  case 3: Engine.weapon.setAmmo(true); break;
                  case 4: Engine.weapon.setAmmo(true); break;
               }
               clearTile(k,j);
               mapMatrix[k][j] = 0;
            }           
            return true;
        }  if(i==5) {
            if(x){
              Engine.cmd.setCd(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            } else {
              return true;
            }
        } if(i==7){
            if(x){
              Engine.cmd.setFloppy(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            } else { 
              return true;
            }
        } if (i==6){
            if(x){
              Engine.cmd.setSd(true);
              clearTile(k,j);
              mapMatrix[k][j] = 0;
            } else {
              return true;
            }
        } 
            return false;
     }
    public int getDifx() {
        return difx;
    }

    public void setDifx(int difx) {
        this.difx = difx;
        xi =(difx/scaleTile);
    }
     
    /*
     * getter y setter para nextlevel
     */
    
    public int getNxtlvl() {
        return nxtlvl;
    }

    public void setNxtlvl(int nxtlvl) {
        this.nxtlvl = nxtlvl;
    }
    
    public int canGoDown(AnimatedObject ao, int dy){ //Recibe como parametro el rectangulo que compone al objeto y cuanto es lo que se quiere mover en el eje y hacia abajo.
        Rectangle r=ao.getBounds();
        int yEnElArreglo, aRegresar = 0;
        int xMinEnElArreglo = (((int)r.getMinX()+difx)/scaleTile)%(mapMatrix[0].length); //La posicion mas a la izquierda en X
        int xMaxEnElArreglo = (((int)r.getMaxX()+difx)/scaleTile)%(mapMatrix[0].length); //La Posicion mas a la derecha en X
        for(aRegresar = 0; aRegresar <= dy; aRegresar++){
            yEnElArreglo = ((int)(r.getMaxY() + aRegresar+1)/scaleTile)%(mapMatrix.length);
            boolean enXMin = specialTiles2(yEnElArreglo,xMinEnElArreglo,(ao instanceof Hacker));/*(mapMatrix[yEnElArreglo][xMinEnElArreglo] == 0);*/
            boolean enXMax = specialTiles2(yEnElArreglo,xMaxEnElArreglo,(ao instanceof Hacker));/*(mapMatrix[yEnElArreglo][xMaxEnElArreglo] == 0);*/
            boolean enXmid= specialTiles2(yEnElArreglo,((xMaxEnElArreglo+xMinEnElArreglo))/2,(ao instanceof Hacker));
            this.setChanged();
            this.notifyObservers();
            if(!(enXMin && enXMax && enXmid)){break;
            }
            if(!(enXMin&& enXmid)){break;
            }
            if(!(enXMax && enXmid)){break;
            }
        }
        return aRegresar;
    }
    
    public int canGoUp(AnimatedObject ao, int dy){
         Rectangle r=ao.getBounds();//Recibe como parametro el rectangulo que compone al objeto y cuanto es lo que se quiere mover en el eje y hacia arriba.
        int yEnElArreglo, wut;
        int xMinEnElArreglo = (((int)r.getMinX()+difx)/scaleTile)%(mapMatrix[0].length); //La posicion mas a la izquierda en X
        int xMaxEnElArreglo = (((int)r.getMaxX()+difx)/scaleTile)%(mapMatrix[0].length); //La Posicion mas a la derecha en X
        for(wut = 0; wut >= dy; wut--){
            yEnElArreglo = ((int)(r.getMinY() + wut -1)/scaleTile)%(mapMatrix.length);
            boolean enXMin = specialTiles2(yEnElArreglo,xMinEnElArreglo,(ao instanceof Hacker));/*(mapMatrix[yEnElArreglo][xMinEnElArreglo] == 0);*/
            boolean enXMax = specialTiles2(yEnElArreglo,xMaxEnElArreglo,(ao instanceof Hacker));
            this.setChanged();
            this.notifyObservers();
            if(!(enXMin && enXMax))break;
        }
        return wut;
    }
    
    public int canGoRight(AnimatedObject ao, int dx){
        Rectangle r=ao.getBounds();
        int xEnElArreglo, wut;
        int yMaxEnElArreglo = ((int)r.getMaxY()/scaleTile)%(mapMatrix.length);
        int yMinEnElArreglo = ((int)r.getMinY()/scaleTile)%(mapMatrix.length);
        for(wut = 0; wut < dx; wut++){
            xEnElArreglo = ((int)(difx + r.getMaxX() + wut + 1)/scaleTile);
            if(xEnElArreglo > mapMatrix[0].length-1)break;
            boolean enYMax = specialTiles2(yMaxEnElArreglo,xEnElArreglo,(ao instanceof Hacker));/*(mapMatrix[yMaxEnElArreglo][xEnElArreglo] == 0);*/
            boolean enYMin = specialTiles2(yMinEnElArreglo,xEnElArreglo,(ao instanceof Hacker));
            this.setChanged();
            this.notifyObservers();
            if(!(enYMax && enYMin))break;
        }
        return wut;
    }
    
    public int canGoLeft(AnimatedObject ao, int dx){
        Rectangle r=ao.getBounds();
        int xEnElArreglo, wut;
        int yMaxEnElArreglo = ((int)r.getMaxY()/scaleTile)%(mapMatrix.length);
        int yMinEnElArreglo = ((int)r.getMinY()/scaleTile)%(mapMatrix.length);
        for(wut = 0; wut >= dx; wut--){
            xEnElArreglo = ((int)(r.getMinX() + difx + wut - 1)/scaleTile);
            if(xEnElArreglo < 0) break;
            boolean enYMax = specialTiles2(yMaxEnElArreglo,xEnElArreglo,(ao instanceof Hacker));/*(mapMatrix[yMaxEnElArreglo][xEnElArreglo] == 0);*/
            boolean enYMin = specialTiles2(yMinEnElArreglo,xEnElArreglo,(ao instanceof Hacker));
            this.setChanged();
            this.notifyObservers();
            if(!(enYMax && enYMin))break;
        }
        
        return wut;
    }
    
      public boolean canGoUpBall(AnimatedObject ao){ //Recibe como parametro el rectangulo que compone al objeto y cuanto es lo que se quiere mover en el eje y hacia abajo.
      if(ao.getBounds().getMaxY()<475){
          Rectangle a=null;
          for(int i=0; i<2;i++){
              switch(i){
                  case 0:
                   a=new Rectangle((int)Engine.hacker.getXposition() + 48, (int)Engine.hacker.getYposition() + 22, 15, 89);    
                   break;
                  case 1:
                   a= new Rectangle((int)Engine.hacker.getXposition()+31, (int)Engine.hacker.getYposition(), 24, 24);   
                   break;
              }
              
        Rectangle r=ao.getBounds();
        
        int yEnElArreglo;
        int xMinEnElArreglo = (((int)a.getMinX()+difx)/scaleTile)%(mapMatrix[0].length); //La posicion mas a la izquierda en X
        int xMaxEnElArreglo = (((int)a.getMaxX()+difx)/scaleTile)%(mapMatrix[0].length); //La Posicion mas a la derecha en X
        yEnElArreglo = ((int)a.getMinY())/scaleTile;
        
        boolean enXMin = specialTiles2(yEnElArreglo,xMinEnElArreglo,(ao instanceof Hacker));/*(matriz[yEnElArreglo][xMinEnElArreglo] == 0);*/
        boolean enXMax = specialTiles2(yEnElArreglo,xMaxEnElArreglo,(ao instanceof Hacker));
        boolean enXMin2 = specialTiles2(yEnElArreglo-1,xMinEnElArreglo,(ao instanceof Hacker));/*(matriz[yEnElArreglo][xMinEnElArreglo] == 0);*/
        boolean enXMax2 = specialTiles2(yEnElArreglo-1,xMaxEnElArreglo,(ao instanceof Hacker));/*(matriz[yEnElArreglo][xMaxEnElArreglo] == 0);*/
           if(!(enXMin && enXMax)){
               return false;
           }
           if(!(enXMin2 && enXMax2)){
              return false;
           }        
         
          
          }
        return true;
      }
      return false;
    }
    
    public void set00Tiles(int k, int j,int tile){
        for(int i=2;i<mapMatrix.length-2;i++){
            if(mapMatrix[i][j]==tile || mapMatrix[i][j]==31 || mapMatrix[i][j]==32){
                mapMatrix[i][j]=0;
            }
        }
    }
     public boolean lifeMenosMenosTiming(int x){
        if(System.currentTimeMillis()-time>x){
            return true;
            
        }else{
            return false;
        }
    }
     
    
     
}