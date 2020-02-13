package com.mycompany.A1prj;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.charts.util.ColorUtil;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

public class GameWorld {

	private ArrayList<GameObject> GameObjects;
	Iterator<GameObject> iter;

	private int lives = 3;
	private int clock = 0;

	@SuppressWarnings("unused")
	private int lastBase = 4;

	public GameWorld() {
	}

	Cyborg player = new Cyborg((float) 70.0, (float) 70.0);

	public void init() {

		GameObjects = new ArrayList<>();
		iter = GameObjects.iterator();

		GameObjects.add(new Base((float) 70.0, (float) 70.0, 1));
		GameObjects.add(new Base((float) 180.0, (float) 180.0, 2));
		GameObjects.add(new Base((float) 250.0, (float) 250.0, 3));
		GameObjects.add(new Base((float) 500.0, (float) 500.0, 4));

		GameObjects.add(player);

		GameObjects.add(new EnergyStation());
		GameObjects.add(new EnergyStation());

		GameObjects.add(new Drone());
		GameObjects.add(new Drone());
	}

	public void accelerate() {
		int curr = player.getSpeed();
		curr += 4;
		if (curr > player.getMaxSpeed()) {
			curr = player.getMaxSpeed();
		}
		player.setSpeed(curr);
	}

	public void brake() {
		int curr = player.getSpeed();
		curr -= 4;
		if (curr > player.getMaxSpeed()) {
			curr = player.getMaxSpeed();
		}
		player.setSpeed(curr);
	}

	public void changeDirection(char c) {
		switch (c) {
		case 'l':
			player.left();
		case 'r':
			player.right();
		}
	}

	public void collisionEnergy() {
		for (GameObject obj : GameObjects) {
			if (obj instanceof EnergyStation) {
				player.energyCollision(((EnergyStation) obj).getCapacity());
				((EnergyStation) obj).replace();
				break;
			}
		}
	}

	public void collisionCyborg() {
		return;
	}

	public void collisionDrone() {
		player.droneCollision();
	}

	public void hitBase(int n) {
		player.baseCollision(n);
	}

	public void tick() {
		clock++;
		player.energyLoss();
		for (GameObject obj : GameObjects) {
			if (obj instanceof MoveableObject) {
				if (obj instanceof Cyborg) {
					obj.steer();
				} else {
					obj.changeHeading();
				}
				obj.move();
			}
		}

		if (player.isDead()) {
			lives--;
			if (lives == 0) {
				System.out.println("Game Over");
				this.init();
			} else {
				player.newLife((float) 70.0, (float) 70.0);
			}
		}

		if (player.getLastBase() == lastBase) {
			System.out.println("You win! Runtime: " + clock);
		}
	}

	public void display() {
		System.out.println("Lives: " + lives);
		System.out.println("Clock: " + clock);
		System.out.println("Base number reached: " + player.getLastBase());
		System.out.println("Energy Level: " + player.getEnergyLevel());
		System.out.println("Damage: " + player.getDmgLvl());
		System.out.println(" ");

	}

	public void map() {
		iter = GameObjects.iterator();
		System.out.println();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
		System.out.println(" ");
	}

	public void exit() {
		System.exit(0);
	}

}
