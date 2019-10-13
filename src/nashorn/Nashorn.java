package nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Nashorn {

	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		String name = "World";
		int result = 0;

		try {
			nashorn.eval("print('Hello " + name + "!')");
			result = (Integer) nashorn.eval("10 + 2");

		} catch(ScriptException e) {
			System.out.println("Error executing script: "+ e.getMessage());
		}
		System.out.println(result);
	}

}
