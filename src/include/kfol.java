package include;

public class kfol {
    public static void cal(int level, int character) {
        int point = level * 3;
        double STR = point * (1.0 / 24);
        double DEX = point * (13.0 / 24);
        double INT = point * (1.0 / 24);
        double CON = point * (1.0 / 24);
        double MEN = point * (7.0 / 24);
        double VIT = point * (1.0 / 24);
        System.out.println(STR);
        System.out.println(DEX);
        System.out.println(INT);
        System.out.println(CON);
        System.out.println(MEN);
        System.out.println(VIT);
    }
    public static void main(String args[]) {
        cal(194, 1);
    }
}
