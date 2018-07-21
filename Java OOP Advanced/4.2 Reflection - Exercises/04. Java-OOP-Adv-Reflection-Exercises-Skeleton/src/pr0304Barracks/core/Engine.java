package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private static final String COMMAND_PATH = "pr0304Barracks.core.commands.";
	private Repository repository;
	private UnitFactory factory;
	private String[] data;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.factory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpredCommand(String[] data, String commandName){
		this.data = data;
		try {
			String commandClassName = COMMAND_PATH + Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1).toLowerCase() + "Command";
			Class commandClass = Class.forName(commandClassName);
			Constructor declaredConstructor = commandClass.getDeclaredConstructor();
			Executable command = (Executable) declaredConstructor.newInstance();
			injectDependencies(command);
			return command.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			throw new RuntimeException("Invalid command!");
		}
	}

	private void injectDependencies(Executable command) {
		Field[] fields = command.getClass().getDeclaredFields();
		Field[] innerFields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if(field.isAnnotationPresent(Inject.class)){
				for (Field innerField : innerFields) {
					innerField.setAccessible(true);
					if(field.getType().equals(innerField.getType()) && field.getName().equals(innerField.getName())){
						try {
							field.set(command, innerField.get(this));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
