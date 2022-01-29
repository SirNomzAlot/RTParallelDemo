package enginev2;

import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.effect.PerspectiveTransform;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ActorA extends Actor {
	private PerspectiveTransform transform = new PerspectiveTransform();

	private Room r;

	public ActorA() {
	}
	public ActorA(String file) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString()));
	}
	public ActorA(String file,double sx,double sy) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),sx,sy,false,false));
	}
	public ActorA(String file,Vector2 v) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),v.getX(),v.getY(),false,false));
	}
	public ActorA(String file,Vector2 vp,Vector2 vs) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),vs.getX(),vs.getY(),false,false));
		setX(vp.getX());
		setY(vp.getY());
	}
	void setRoom(Room r) {
		this.r=r;
	}
	public Room getRoom() {
		return r;
	}
	public void imageSet(String file,double sx, double sy) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),sx,sy,false,false));
	}
	public void imageSet(String file,Vector2 v) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),v.getX(),v.getY(),false,false));
	}
	public void imageSet(String file) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString()));
	}
	public void move(Vector2 v) {
		setX(getX()+v.getX());
		setY(getY()+v.getY());
	}
	public Vector2 getPos() {
		return new Vector2(getX(), getY());
	}
	public void setPos(Vector2 v) {
		setX(v.getX());
		setY(v.getY());
	}
	@Override
	public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
		for (A a : r.getActors(cls)) {
			if (a!=this&&intersects(a.getX(),a.getY(),a.getWidth(),a.getHeight())) {
				return a;
			}
		}
		return null;
	}
	@Override
	public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
		ArrayList<A> hold = new ArrayList<>();
		for (A a : r.getActors(cls)) {
			if (a!=this&&intersects(a.getX(),a.getY(),a.getWidth(),a.getHeight())) {
				hold.add((A)a);
			}
		}
		return hold;
	}
	public void rotate(double a) {
		setRotate(getRotate() +a);
	}
	public double getRotation() {
		return getRotate();
	}
	public Vector2 getCorner(int p) {
		switch (p) {
		case 0: return new Vector2(getWidth()/-2,getHeight()/-2);
		case 1: return new Vector2(getWidth()/2,getWidth()/-2);
		case 2: return new Vector2(getWidth()/-2,getWidth()/2);
		case 3: return new Vector2(getWidth()/2,getHeight()/2);
		}
		return new Vector2(-1,-1);
	}
	public void distort(double ulx, double uly, double urx, double ury, double llx, double lly, double lrx, double lry) {
		transform.setUlx(ulx+getX());
		transform.setUly(uly+getY());
		transform.setUrx(urx+getX());
		transform.setUry(ury+getY());
		transform.setLlx(llx+getX());
		transform.setLly(lly+getY());
		transform.setLrx(lrx+getX());
		transform.setLry(lry+getY());
		setEffect(transform);
	}
	public void distort(Vector2 ul, Vector2 ur, Vector2 ll, Vector2 lr) {
		distort(ul.getX(),ul.getY(),ur.getX(),ur.getY(),ll.getX(),ll.getY(),lr.getX(),lr.getY());
	}
	public void distort(Vector2 r, Vector2 l) {
		distort(Vector2.matrixMult(getCorner(0),r,l),Vector2.matrixMult(getCorner(1),r,l),Vector2.matrixMult(getCorner(2),r,l),Vector2.matrixMult(getCorner(3),r,l));
	}
	public void resetDistortion() {
		setEffect(null);
	}
	public void remove() {
		r.removeActor(this);
	}
	//view this as update
	public void act(long now) {
		update((double)now);
	}
	public void update(double dt) {

	}
	public void top() {
		toFront();
	}
}