import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public Snake(Node node) {
		head = node;
		tail = node;
		size = 1;
	}
	
	public void addToTail() {
		Node node = null;
		switch(tail.dir) {
		case L :
			node = new Node(tail.row,tail.col +1,tail.dir);
			break;
		case U :
			node = new Node(tail.row+1,tail.col,tail.dir);
			break;
		case R :
			node = new Node(tail.row,tail.col-1,tail.dir);
			break;
		case D :
			node = new Node(tail.row-1,tail.col,tail.dir);
			break;
		}
		tail.next = node;
		tail = node;
	}
	
 	private class Node {
		int w = Yard.BLOCK_SIZE;
		int h = Yard.BLOCK_SIZE;
		int row , col;
		Dir dir = Dir.L;
		Node next = null;
		
		Node(int row, int col,Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(Yard.BLOCK_SIZE * row, Yard.BLOCK_SIZE * col, w, h);
			g.setColor(c);
		}
	}
}
