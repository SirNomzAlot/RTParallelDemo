package liab;

import enginev2.ActorA;
import enginev2.Vector2;
import enginev2.Data;

public class CubeFace extends ActorA {
	private Vector2 normal;
	public CubeFace(Vector2 p, Vector2 normal, String texture) {
		super(texture);
		setPos(p);
		this.normal = normal;
	}
	public void dRotate(double t) {
		distort(Vector2.rotate(getCorner(0),t),Vector2.rotate(getCorner(1),t),Vector2.rotate(getCorner(2),t),Vector2.rotate(getCorner(3),t));
	}
	@Override
	public void update(double dt) {

	}
}