package nur.prog3.recursividad;

public class HanoiSimple {
    public static void main(String[] args) {
        HanoiSimple h = new HanoiSimple();

        h.hanoi(2,1,3,4);
    }

    private void hanoi(int de, int a, int pp, int n) {
        if (n == 1) {
            System.out.println(de + " -> " + a);
            return;
        }
        hanoi(de,pp,a,n-1);
        hanoi(de,a,pp,1);
        hanoi(pp,a,de,n-1);
    }
}
