package chordCalculatorDataModel;

import java.util.ArrayList;
import java.util.List;

public class TestRuimte {
    public static void main(String[] args) {

        Note note = new Note("c");
        Note note2 = new Note("e");

        Interval interval = new Third(note, note2);

        System.out.println(interval.getClass());


        List<Integer> superLijst = new ArrayList<>();
        superLijst.add(1);
        superLijst.add(2);
        superLijst.add(3);
        superLijst.add(4);
        superLijst.add(5);
        superLijst.add(6);
        superLijst.add(7);
        superLijst.add(8);
        superLijst.add(9);

        List<Integer> subLijst = new ArrayList<>();
        subLijst.add(5);
        subLijst.add(6);
        subLijst.add(7);
        subLijst.add(8);
        subLijst.add(9);

        System.out.println(superLijst);
        System.out.println(subLijst);

        System.out.println(isSubSet(subLijst, superLijst));
    }

    static boolean isSubSet(List<Integer> sublijst, List<Integer> superLijst) {
        boolean flag = false;

            for (int i = 0; i <= superLijst.size() - sublijst.size(); i++) {
                flag = true;
                for (int j = 0; j < sublijst.size(); j++) {
                    if (!sublijst.get(j).equals(superLijst.get(j + i))) {
                        System.out.println("reeks doorbroken");
                        flag = false;
                        break;
                        }
                    System.out.println("einde j loop");
                }
                if (flag) {
                    break;
                }
                System.out.println("einde i loop");
            }

        return flag;
    }

}

