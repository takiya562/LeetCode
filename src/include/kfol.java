package include;

public class kfol {
    public static void cal(int level, int character) {
        int point = level * 3;
        double STR = point * (1.0 / 12);
        double DEX = point * (4.0 / 12);
        double INT = point * (3.0 / 12);
        double CON = point * (2.0 / 12);
        double MEN = point * 0;
        double VIT = point * (2.0 / 12);
        System.out.println(STR);
        System.out.println(DEX);
        System.out.println(INT);
        System.out.println(CON);
        System.out.println(MEN);
        System.out.println(VIT);
    }
    public static void main(String args[]) {
        cal(109, 1);
    }
}
