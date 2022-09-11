import java.lang.reflect.*;

class ReflectApp
{
    private static String       indent = "    ";
    private static boolean		realNames = false;
    private static String[]     defaultArgs = {"TargetClass"};

	// arguments: [className [, realNames]]
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
        throws Throwable
    {
        Class		c;						// the class we're analyzing
        
        if (args == null || args.length == 0)
            args = defaultArgs;

        c = Class.forName(args[0]);         // load class we're analyzing
        if (args.length >= 2)
        	realNames = Boolean.valueOf(args[1]).booleanValue();
        
        printClass(c);
    }

 	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void printClass (Class c)
        throws Throwable
    {
        Class           superClass;         // superclass
        Class[]         interfaces;         // interfaces it implements
        Constructor[]   constructors;       // constructors
        Field[]         fields;             // fields
        Method[]        methods;            // methods
        Class[]         innerClasses;       // inner classes
        String          modifiers;          // modifiers
        Class[]         parmTypes;

        superClass = c.getSuperclass();
        interfaces = c.getInterfaces();
        constructors = c.getDeclaredConstructors();
        innerClasses = c.getDeclaredClasses();
        fields = c.getDeclaredFields();
        methods = c.getDeclaredMethods();
        modifiers = Modifier.toString(c.getModifiers());
        System.out.println("\n" +
                           modifiers +
                           (modifiers.length() == 0 ? "" : " ") +
                           (c.isInterface() ? "" : "class ") +
                           c.getName());
        if (superClass != null)
            System.out.println(indent + "extends: " + superClass.getName());
        if (interfaces != null && interfaces.length > 0) {
            System.out.print(indent + "implements: ");
            for (int i = 0; i < interfaces.length; i++)
                System.out.print((i > 0 ? ", " : "") + interfaces[i].getName());
            System.out.print("\n");
            }
        if (fields != null && fields.length > 0) {
            System.out.println("\nfields:");
            for (int i = 0; i < fields.length; i++)
                printMember(fields[i]);
            }
        if (constructors != null && constructors.length > 0) {
            System.out.println("\nconstructors:");
            for (int i = 0; i < constructors.length; i++)
                printMember(constructors[i]);
            }
        if (methods != null && methods.length > 0) {
            System.out.println("\nmethods:");
            for (int i = 0; i < methods.length; i++)
                printMember(methods[i]);
            }
        if (innerClasses != null && innerClasses.length > 0) {
            System.out.println("\n\ninner classes:\n");
            for (int i = 0; i < innerClasses.length; i++) {
                printClass(innerClasses[i]);
                System.out.print("\n");
                }
            }
        System.out.print("\n");

        // do some special stuff with TargetClass
        if (c.getName().equals(defaultArgs[0])) {
            Constructor     cn;
            TargetClass   rt;
            Method          m;
            Field           f;
            Class[]         argTypes = {Integer.TYPE};      // arg types for publicMethod
            Object[]        args = {new Integer(3)};        // arg values for publicMethod are (3)
            
            System.out.println("Doing some things with " + defaultArgs[0] + "\n");
            cn = c.getDeclaredConstructor();            	// no-arg constructor
            rt = (TargetClass) cn.newInstance();      		// use constructor to create instance
            m = c.getDeclaredMethod("publicMethod", argTypes);
            f = c.getDeclaredField("publicVar");
            m.invoke(rt, args);                             // call publicMethod(3)
            f.setInt(rt, 999);                              // set publicVar to 999
            args[0] = new Integer(4);                       // arg values for publicMethod are (4)
            m.invoke(rt, args);                             // call publicMethod(4)
            m = c.getDeclaredMethod("staticMethod", (Class[]) null);
            m.invoke((Class) null);
            }
    }

    @SuppressWarnings("rawtypes")
	private static void printMember(Member member)
    {
        boolean     field = member instanceof Field;
        boolean     constructor = member instanceof Constructor;
        boolean     method = member instanceof Method;
        String      modifiers;
        String      name;
        Class[]     parmTypes;

        // collect member information
        modifiers = Modifier.toString(member.getModifiers());
        name = member.getName();
        parmTypes = constructor ? ((Constructor) member).getParameterTypes() :
                    method ?      ((Method) member).getParameterTypes() :
                                  null;

        // print indentation
        System.out.print(indent);

        // print access modifiers
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");

        // print return type if method
        if (method)
            System.out.print(typeName(((Method) member).getReturnType()) + " ");
        else if (field)
            System.out.print(typeName(((Field) member).getType()) + " ");

        // print member name
        System.out.print(name);

        // print argument type list if constructor or method
        if (constructor || method) {
            System.out.print("(");
            for (int i = 0; i < parmTypes.length; i++)
                System.out.print((i > 0 ? ", " : "") + typeName(parmTypes[i]));
            System.out.print(")");
            }
        System.out.print("\n");
    }
    
    @SuppressWarnings("rawtypes")
	private static String typeName(Class type)
    {
        Class       arrayComponentType;
        String      arrayBrackets;
        
        if (type.isArray() && ! realNames) {
            arrayBrackets = "";
            arrayComponentType = type;
            do {
                arrayBrackets += "[]";
                arrayComponentType = arrayComponentType.getComponentType();
                }
            while (arrayComponentType.isArray());
            return arrayComponentType.getName() + arrayBrackets;
            }
        else
            return type.getName();
       
    }
}
