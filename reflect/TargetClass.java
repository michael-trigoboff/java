public class TargetClass
    extends TargetClassParent
    implements TargetInterface
{
    static int          staticVar;

    public int          publicVar;
    private int         privateVar;
    boolean             booleanVar;
    
    private int[]       intArray1;
    private int[][]     intArray2;
    private int[][][]   intArray3;
    private byte[]      byteArray;
    private char[]      charArray;
    private double[]    doubleArray;
    private float[]     floatArray;
    private long[]      longArray;
    private short[]     shortArray;
    private boolean[]   booleanArray;
    private Object		object;
    private Object[]    objectArray;

    public TargetClass ()
    {
        publicVar = 12345;
    }

    TargetClass (String str, int i, double d)
    {
    }

    public void interfaceMethod ()
    {
    }

    private void privateMethod ()
    {
    }

    public void publicMethod (int x)
    {
        System.out.println("publicMethod invoked with x = " + x);
        System.out.println("publicVar = " + publicVar);
    }
    
    public static void staticMethod ()
    {
    	System.out.println("static method called");
    }
    
    private class NestedClass
    {
        void nestedClassMethod ()
        {
        }
    }

    public static class StaticClass
    {
        public static void staticClassMethod ()
        {
        }
    }
}
