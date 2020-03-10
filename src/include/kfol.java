package include;


public class kfol {
    public static void cal(int level, String character) {
        int point = level * 3;
        double STR;
        double DEX;
        double INT;
        double CON;
        double MEN;
        double VIT;
        switch (character) {
            case "meng" :
                STR = point * (1.0 / 24);
                DEX = point * (13.0 / 24);
                INT = point * (1.0 / 24);
                CON = point * (1.0 / 24);
                MEN = point * (7.0 / 24);
                VIT = point * (1.0 / 24);
                System.out.println(STR);
                System.out.println(DEX);
                System.out.println(INT);
                System.out.println(CON);
                System.out.println(MEN);
                System.out.println(VIT);
                break;
            case "mo" :
                STR = point * (4.0 / 16) + 1;
                DEX = point * (7.0 / 16) + 1;
                INT = point * (0.0 / 16) + 1;
                CON = point * (1.0 / 16) + 1;
                MEN = point * (0.0 / 16) + 1;
                VIT = point * (4.0 / 16) + 1;
                System.out.println(STR);
                System.out.println(DEX);
                System.out.println(INT);
                System.out.println(CON);
                System.out.println(MEN);
                System.out.println(VIT);
                break;
        }
    }
    public static void main(String args[]) {
        cal(200, "mo");
    }
}
