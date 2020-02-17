package com.mycompany.A1prj;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form {
	private GameWorld gw;

	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	private void play() {
		Label myLabel = new Label("Enter a Command: ");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();

		myTextField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if (sCommand.length() != 0) {
					switch (sCommand.charAt(0)) {
					case 'a':
						gw.accelerate();
						break;
					case 'b':
						gw.brake();
						break;
					case 'l':
						gw.changeDirection('l');
						break;
					case 'r':
						gw.changeDirection('r');
						break;
					case 'c':
						gw.collision('c');
						break;
					case 'e':
						gw.collisionEnergy();
						break;
					case 'g':
						gw.collision('g');
						break;
					case '1':
						gw.hitBase(1);
						break;
					case '2':
						gw.hitBase(2);
						break;
					case '3':
						gw.hitBase(3);
						break;
					case '4':
						gw.hitBase(4);
						break;
					case '5':
						gw.hitBase(5);
						break;
					case '6':
						gw.hitBase(6);
						break;
					case '7':
						gw.hitBase(7);
						break;
					case '8':
						gw.hitBase(8);
						break;
					case '9':
						gw.hitBase(10);
						break;
					case 't':
						gw.tick();
						break;
					case 'd':
						gw.display();
						break;
					case 'm':
						gw.map();
						break;
					case 'x':
						gw.exit();
						break;
					default:
						System.out.println("Not a valid command");
						break;
					}
				}
			}

		});

	}
}
