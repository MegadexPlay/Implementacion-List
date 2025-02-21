import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        NumberSimpleList number = new NumberSimpleList();
        number.insert(1);
        number.insert(2);
        number.insert(4);
        number.insert("asd");
        number.insert(123);
        number.insert(1345);
        number.insert(7);

        System.out.println(number.exist("asd"));

        Iterator listIterator = number.iterator();
        System.out.println(number.Show());
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next() + " impreso usando iterator");
        }


    }
}
