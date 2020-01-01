package johnny.java.core.enums;

import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class EnumExample {
    public static void main(String[] args) throws IOException {

        usingEnumMethods();

        usingEnumValueOf();

        usingEnumValues();

        usingEnumInSwitch(ThreadStatesEnum.START);
        usingEnumInSwitch(ThreadStatesEnum.DEAD);

        usingEnumMap();

        usingEnumSet();
    }

    private static void usingEnumSet() {
        EnumSet<ThreadStatesEnum> enumSet = EnumSet.allOf(ThreadStatesEnum.class);
        for (ThreadStatesEnum tsenum : enumSet){
            System.out.println("Using EnumSet, priority = " + tsenum.getPriority());
        }
    }

    private static void usingEnumMap() {
        EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<ThreadStatesEnum,String>(ThreadStatesEnum.class);
        enumMap.put(ThreadStatesEnum.START, "Thread is started");
        enumMap.put(ThreadStatesEnum.RUNNING, "Thread is running");
        enumMap.put(ThreadStatesEnum.WAITING, "Thread is waiting");
        enumMap.put(ThreadStatesEnum.DEAD, "Thread is dead");

        Set<ThreadStatesEnum> keySet = enumMap.keySet();
        for(ThreadStatesEnum key : keySet){
            System.out.println("key="+key.toString()+":: value="+enumMap.get(key));
        }

    }

    private static void usingEnumInSwitch(ThreadStatesEnum th) {
        switch (th){
            case START:
                System.out.println("START thread");
                break;
            case WAITING:
                System.out.println("WAITING thread");
                break;
            case RUNNING:
                System.out.println("RUNNING thread");
                break;
            case DEAD:
                System.out.println("DEAD thread");
        }
    }

    private static void usingEnumValues() {
        ThreadStatesEnum[] thArray = ThreadStatesEnum.values();

        for(ThreadStatesEnum th : thArray){
            System.out.println(th.toString() + "::priority="+th.getPriority());
        }
    }

    private static void usingEnumValueOf() {
        ThreadStatesEnum th = Enum.valueOf(ThreadStatesEnum.class, "START");
        System.out.println("th priority="+th.getPriority());
    }

    private static void usingEnumMethods() throws IOException {
        ThreadStatesEnum thc = ThreadStatesEnum.DEAD;
        System.out.println("priority is:"+thc.getPriority());

        thc = ThreadStatesEnum.DEAD;
        System.out.println("Using overriden method."+thc.toString());

        thc = ThreadStatesEnum.START;
        System.out.println("Using overriden method."+thc.toString());
        thc.setPriority(10);
        System.out.println("Enum Constant variable changed priority value="+thc.getPriority());
        thc.close();
    }
}
