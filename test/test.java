import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(5);
        l.add(1);
        l.add(10);
        l.add(2);

        l.remove(l.size()-1);

        System.out.println(l);
    }
}
