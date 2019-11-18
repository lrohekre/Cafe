package Aufgaben;
import java.util.Arrays;
import java.util.Random;

public class QuickSort
{
    public static Integer[] generateArrayWithoutRandomFigures (Integer size)
    {
        Integer[] IntArray = new Integer[size];
        Random r = new Random();
        for (int i = 0; i < IntArray.length; i++)
            IntArray[i] = r.nextInt(100);
        return IntArray;
    }


    public static void sort (Integer[] ArrayToSort, Integer StartBound, Integer UpperBound)
    {
       Integer PosList = Teilliste(ArrayToSort, StartBound, UpperBound);
        if (PosList - 1 > StartBound)
            sort(ArrayToSort, StartBound, PosList - 1);
        if (PosList + 1 < UpperBound)
            sort(ArrayToSort, PosList + 1, UpperBound);
    }


    public static int Teilliste (Integer[] SubArray, Integer StartBound, Integer UpperBound)
    {
        Integer PivotElement = SubArray[UpperBound];
        for (int i = StartBound; i < UpperBound; i++)
        {
            if (SubArray[i] < PivotElement)
            {
                Integer tmp = SubArray[StartBound];
                SubArray[StartBound] = SubArray[i];
                SubArray[i] = tmp;
                StartBound++;
            }
        }
        Integer tmp = SubArray[StartBound];
        SubArray[StartBound] = PivotElement;
        SubArray[UpperBound] = tmp;
        return StartBound;
    }


    public static void main(String[] args)
    {
        System.out.println("zufällige Zahlen");
        Integer[] array = generateArrayWithoutRandomFigures(20);
        System.out.println(Arrays.toString(array));

        System.out.println("After Sort");
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}
