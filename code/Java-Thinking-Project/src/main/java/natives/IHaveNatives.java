package natives;

public class IHaveNatives {
    native public void native1(int i);

    native static void native2();

    native synchronized void native3(Object o);

    native void native4(int[] arr) throws Exception;
}
