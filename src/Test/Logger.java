package Test;

import java.util.Date;

//TODO
//setLevel es decir, establecer los niveles
//crear las funciones por cada nivel establecido

public class Logger {

	// private static Logger log;
	private Class currentClass;

	public static enum Level {
		INFO, WARNING, SEVERE
	}

	private static int currentLevel = 0;

	private Logger(Class currentClass) {
		this.currentClass = currentClass;
	}

	/*
	 * public static Logger getInstance() { if (log == null) { log = new Logger(); }
	 * return log; }
	 */

	// Con este metodo NO se debe aplicar el patron Singleton
	public static Logger getLogger(Class currentClass) {
		Logger log = new Logger(currentClass);
		return log;
	}

	public static void printLevel() {
		System.out.println("Current level: " + currentLevel);
	}

	public static void setLevel(Level level) {
		currentLevel = level.ordinal();
		printLevel();
	}

	private void printCurrentState() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		System.out.println(
				"" + new Date() + " " + currentClass.getSimpleName() + " " + stackTraceElements[3].getMethodName());
	}

	public void info(String msg) {
		printCurrentState();
		System.out.println("INFO: " + msg);
	}

	public void warning(String msg) {
		printCurrentState();
		System.out.println("WARNING: " + msg);
	}

	public void severe(String msg) {
		printCurrentState();
		System.out.println("SEVERE: " + msg);
	}
}
