package liab;

import enginev2.Room;
import enginev2.Data;
import enginev2.Vector2;
import java.lang.Math;

public class Block {
	Room r;
	Vector2 p;
	CubeFace n;
	CubeFace s;
	CubeFace e;
	CubeFace w;
	CubeFace t;
	CubeFace b;

	public Block(Vector2 p, Room r) {
		n = new CubeFace(p,new Vector2(1,0),"resources/textures/blue.png");
		s = new CubeFace(p,new Vector2(-1,0),"resources/textures/green.png");
		e = new CubeFace(p,new Vector2(0,1),"resources/textures/red.png");
		w = new CubeFace(p,new Vector2(0,-1),"resources/textures/yellow.png");
		t = new CubeFace(p,new Vector2(1,1),"resources/textures/cross.png");
		b = new CubeFace(p,new Vector2(-1,-1),"resources/textures/brown.png");
		r.addActor(n);
		r.addActor(s);
		r.addActor(e);
		r.addActor(w);
		r.addActor(t);
		r.addActor(b);
	}
	public void update(double dt) {
		Double theta = (Data.mouseX)/100;
		//figure out why 1.57
		//because its 90 degrees.
		//double gamma = Math.max(-1.5708, Math.min(0,(Data.mouseY-Data.tabSY/2)/100));
		double gamma = (Data.mouseY-Data.tabSY/2)/100;

		double cons = w.getHeight()*Math.cos(gamma);
		if (Data.mouseY-Data.tabSY/2>0) {
			t.setVisible(false);
			b.setVisible(true);
		} else {
			t.setVisible(true);
			b.setVisible(false);
		}
		System.out.println((int)(Math.abs((theta%(2*Math.PI))/0.785398)));
		switch ((int)(Math.abs((theta%(2*Math.PI))/0.785398))) {
		case 0:
			System.out.println("Eh");
			n.setVisible(true);
			s.setVisible(false);
			e.setVisible(false);
			w.setVisible(true);
			break;
		case 1:
			System.out.println("AH");
			n.setVisible(false);
			s.setVisible(true);
			e.setVisible(false);
			w.setVisible(true);
			break;
		case 2:
			System.out.println("AH");
			n.setVisible(false);
			s.setVisible(true);
			e.setVisible(false);
			w.setVisible(true);
			break;
		case 3:
			System.out.println("PAH");
			n.setVisible(false);
			s.setVisible(true);
			e.setVisible(true);
			w.setVisible(false);
			break;
		case 4:
			System.out.println("PAH");
			n.setVisible(false);
			s.setVisible(true);
			e.setVisible(true);
			w.setVisible(false);
			break;
		case 5:
			System.out.println("PEH");
			n.setVisible(true);
			s.setVisible(false);
			e.setVisible(true);
			w.setVisible(false);
			break;
		case 6:
			System.out.println("PEH");
			n.setVisible(true);
			s.setVisible(false);
			e.setVisible(true);
			w.setVisible(false);
			break;
		case 7:
			System.out.println("Eh");
			n.setVisible(true);
			s.setVisible(false);
			e.setVisible(false);
			w.setVisible(true);
		}

		Vector2 v1 = new Vector2(Math.cos(theta)-Math.sin(theta), Math.sin(theta)*Math.sin(gamma)+Math.sin(gamma)*Math.cos(theta));
		Vector2 v2 = new Vector2(-Math.sin(theta)-Math.cos(theta),Math.sin(gamma)*Math.cos(theta)-Math.sin(theta)*Math.sin(gamma));

		Vector2 p1 = Vector2.matrixMult(t.getCorner(0),v1,v2);
		Vector2 p2 = Vector2.matrixMult(t.getCorner(1),v1,v2);
		Vector2 p3 = Vector2.matrixMult(t.getCorner(2),v1,v2);
		Vector2 p4 = Vector2.matrixMult(t.getCorner(3),v1,v2);

		//I dont know why it does a sqrt(2) scaling on em.
		p1.scalar(1/Math.sqrt(2));
		p2.scalar(1/Math.sqrt(2));
		p3.scalar(1/Math.sqrt(2));
		p4.scalar(1/Math.sqrt(2));

		n.distort(p1,p2,new Vector2(p1.getX(),p1.getY()+cons),new Vector2(p2.getX(),p2.getY()+cons));
		w.distort(p1,p3,new Vector2(p1.getX(),p1.getY()+cons),new Vector2(p3.getX(),p3.getY()+cons));
		e.distort(p2,p4,new Vector2(p2.getX(),p2.getY()+cons),new Vector2(p4.getX(),p4.getY()+cons));
		s.distort(p3,p4,new Vector2(p3.getX(),p3.getY()+cons),new Vector2(p4.getX(),p4.getY()+cons));
		b.distort(new Vector2(p1.getX(),p1.getY()+cons),new Vector2(p2.getX(),p2.getY()+cons),new Vector2(p3.getX(),p3.getY()+cons),new Vector2(p4.getX(),p4.getY()+cons));
		t.distort(p1,p2,p3,p4);
	}
}