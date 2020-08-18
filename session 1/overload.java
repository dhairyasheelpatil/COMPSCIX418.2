public class Addition {
    int operation(int n1, int n2)
    {
        return n1+n2;
    }
    int operation(int n1, int n2, int n3)
    {
        return n1+n2+n3;
    }
    float operation(float n1, float n2, float n3)
    {
        return n1+n2+n3;
    }

    public static void main(String args[]) {
        Addition addition = new Addition();
        System.out.println("Sum of two numbers: "+ addition.operation(1, 2));
        System.out.println("Sum of three numbers: "+ addition.operation(1, 2, 3));
        System.out.println("Sum of float numbers: "+ addition.operation(1.0, 2.0, 3.0));
    }
}