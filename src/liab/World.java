package liab;

import enginev2.Room;
import enginev2.Data;
import enginev2.Vector2;

public class World extends Room {
	private Block test;
	public World() {
		test = new Block(new Vector2(Data.tabSX/2, Data.tabSY/2), this);
	}
	@Override
	public void update(double dt) {
		super.update(dt);
		test.update(dt);
		
	}
}