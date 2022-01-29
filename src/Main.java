import enginev2.*;
import liab.*;

public class Main {
	double time=0;
	boolean passSplash = false;
	Room engineSplash = new Room();
	Room main = new Room();
	Block b;
	
	// Modify tab structure here
	public Main() {
		Data.tabName="RTPP";
		Data.resizable=true;
	}

	// Runs one time, basic startup.
	public void start() {
		// Game engine splash
		ActorB bckgrd = new ActorB();
		bckgrd.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(0,0,0,255));
		engineSplash.addActorB(bckgrd);
		ActorA cat = new ActorA("resources/DEADCATGAMEENGINE.png",Data.tabSX/2,Data.tabSY/2);
		cat.setX(Data.tabSX/4);
		cat.setY(Data.tabSY/4);
		engineSplash.addActor(cat);
		engineSplash.setCurRoom();

		Txt title = new Txt("Real Time Parallel Projection",Data.tabSX/5,Data.tabSY/5);
		title.setColor(new ColorRGB(0,0,0,255));

		Room test = new World();

		Bttn start = new Bttn("Start",Data.tabSX/50,Data.tabSY/2.5,() -> {
			test.setCurRoom();
		});
		Bttn quit = new Bttn("Quit",Data.tabSX/50,Data.tabSY/2,() -> {
			System.exit(0);
		});
		main.addButton(quit);
		main.addButton(start);
		main.addText(title);
		Data.states.put("main",main);
	}

	// Runs until game end, dt is change in time. Data is a game state holder sorta thing
	public void update(double dt) {
		//dt is sus
		//System.out.println(dt);
		time+=dt;
		if (time>=1500000000.0&&!passSplash) {
			main.setCurRoom();
			passSplash = true;
		} else {
			Data.curRoom.update(dt);
		}
	}
}