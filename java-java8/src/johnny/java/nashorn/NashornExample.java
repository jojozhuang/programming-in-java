package johnny.java.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {
    // Call javascript from java with ScriptEngineManager
    public static void main(String args[]) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Johnny";
        Integer result = null;

        try {
            // call eval without return value
            nashorn.eval("print('" + name + "')");
            // call eval with return value
            result = (Integer) nashorn.eval("10 + 2");

        } catch(ScriptException e) {
            System.out.println("Error executing script: "+ e.getMessage());
        }
        System.out.println(result.toString());
    }
}
