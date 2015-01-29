package controller.pieces;

import javax.swing.*;

import controller.Piece;
import controller.Teams;
import view.*;

public class Rook extends Chessman {

	public Rook(Teams color){
		
		super(color, Piece.ROOK);
	}
	
	@Override
	public ImageIcon printImage() {
		
		if(this.getColor() == Teams.BLACK)
			return new ImageIcon("img/Ntorre.png");
		else
			return new ImageIcon("img/Btorre.png");
	}

	public boolean mkMove(Chessman[][] table, int ax, int ay, int bx, int by){
		
		if(ax == bx || ay == by){
			
			int vx = 0, vy = 0;
			int x, y;
			
			//set vx on -1 if the first coordinate comes before the second one
			//set vx on 1 if the first one comes after the second one
			//let vx set to 0 if they are on the same line			
			
			vx = ax > bx ? -1 : 1;
			vy = ay > by ? -1 : 1;	
						
			for(x=ax, y=ay; x!=bx && y!=by; x+=vx, y+=vy){
				if(table[x][y].getName() != Piece.EMPTYMAN){
					
					//if the chessman has the same color throws an error
					if(table[x][y].checkColor(table[ax][ay])) 
						return false;
					else
						jump(table, x, y);
					break;
					}
				}
			
		}else
			return false;
		
		return true;
		
	}

}
