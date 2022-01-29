package enginev2;

public class Vector2 {
	private double x;
	private double y;
	public Vector2() {

	}
	public Vector2(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public static Vector2 multiply(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.getX()*v2.getX(),v1.getY()*v2.getY());
	}
	public void multiply(Vector2 v2) {
		x*=v2.getX();
		y*=v2.getY();
	}
	public static Vector2 divide(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.getX()/v2.getX(),v1.getY()/v2.getY());
	}
	public void divide(Vector2 v2) {
		x/=v2.getX();
		y/=v2.getY();
	}
	public static Vector2 add(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.getX()+v2.getX(),v1.getY()+v2.getY());
	}
	public void add(Vector2 v2) {
		x+=v2.getX();
		y+=v2.getY();
	}
	public static Vector2 sub(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.getX()-v2.getX(),v1.getY()-v2.getY());
	}
	public void sub(Vector2 v2) {
		x-=v2.getX();
		y-=v2.getY();
	}
	public static Vector2 scalar(Vector2 v1, double s) {
		return new Vector2(v1.getX()*s,v1.getY()*s);
	}
	public void scalar(double s) {
		x*=s;
		y*=s;
	}
	public static Vector2 rotate(Vector2 v1, double t) {
		return new Vector2(v1.getX()*Math.cos(t)-v1.getY()*Math.sin(t),v1.getX()*Math.sin(t)+v1.getY()*Math.cos(t));
	}
	public void rotate(double t) {
		double tempx = x;
		x=x*Math.cos(t)-y*Math.sin(t);
		y=tempx*Math.sin(t)+y*Math.cos(t);
	}
	/* jank ass 2x2 matrix multiplication
	[x] * [a] [c]
	[y]   [b] [d]
	*/
	public static Vector2 matrixMult(Vector2 v1, Vector2 p1, Vector2 p2) {
		return new Vector2(v1.getX()*p1.getX()+v1.getY()*p2.getX(),v1.getX()*p1.getY()+v1.getY()*p2.getY());
	}
	public void matrixMult(Vector2 p1, Vector2 p2) {
		double tempx = x;
		x=x*p1.getX()+y*p2.getX();
		y=tempx*p1.getY()+y*p2.getY();
	}
}