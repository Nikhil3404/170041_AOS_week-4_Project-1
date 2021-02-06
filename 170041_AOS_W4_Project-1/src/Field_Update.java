

import java.util.concurrent.TimeUnit;



public class Field_Update implements Runnable {
	private Updatable gameField;
	private int pause;
	private Shell_Update shell;
	
	public Field_Update(Updatable gameField, int pause, Shell_Update shell) {
		this.gameField = gameField;
		this.pause = pause;
		this.shell = shell;
	}
	
	public void setPause(int pause) {
		this.pause = pause;
	}
	
	public void run() {
		try {
			long begin = System.currentTimeMillis();
			
			gameField.updateField();
			
			long diff = System.currentTimeMillis() - begin;

			if (diff < pause) 
				TimeUnit.MILLISECONDS.sleep(pause - diff);
			shell.update();
		} catch (InterruptedException iException) {
			Thread.currentThread().interrupt();
		}
	}

}
