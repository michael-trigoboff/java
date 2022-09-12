import java.io.IOException;

public class Wyzant {
    public static int mystMethod(int st, int mv)
    {
        if (mv > st)
        {
            int diff = mv - st;
            mv--;
            return diff + mystMethod(st, mv);
        }
        else if (mv < st)
        {
            int diff = st - mv;
            mv++;
            return diff + mystMethod(st, mv);
        }
        else
            return st;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = a++;
        int c = ++a;
        System.out.printf("b = %d, c = %d\n", b, c);

        try
        {
            System.out.println("Running ..."); // line 3
            if (args.length != 0)
                throw new java.io.IOException("!!!");
            System.out.println("Done!"); // line 54
        }
        catch (IOException e)
        {
            System.out.println("IO Error!");
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }
        finally
        {
            System.out.println("Cleaning up ...");
        }

        for (int x = 0; x < 8; ++x)
        {
            for (int y = 1; y <= 5; ++y)
                System.out.print('%');
            System.out.println();
        }

        for (int height = 4; height >= 0; height--)
        {
            for (int x = height; x >= 0; x--)
                System.out.print('*');
            System.out.println();
        }

        BankAcct ba = new BankAcct("Eric Jones", 471347, 3500);
        ba.deposit(50);
        ba.withdraw(5000);
        System.out.println(ba);

        Point2D pt = new Point2D(4, 8);
        pt.move(-3, 7);
        pt.moveTo(-3, 7);
        pt.move(-3, 7);
        System.out.println(pt);

        VIPInfo vi = new VIPInfo();
        vi.joeMethod();

        int result = mystMethod(3, -1);
        System.out.println(result);

        double d1 = (double)1 / (double)3;
        double d2 = (double)1 / 3;
        double d3 = 1.0 / 3.0;
        double d4 = 1 / 3;
        System.out.printf("%f %f %f %f\n", d1, d2, d3, d4);

        int mod = 29 % 8;
        System.out.println(mod);

        int num = 29;
        int ct = 0;
        while (num != 0)
        {
            ct++;
            num /= 2;
        }
        System.out.println(ct);
    }
}
