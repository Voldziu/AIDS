import core.SortingAlgorithm;
import testing.MarkedValue;
import testing.MarkedValueComparator;
import testing.Result;
import testing.Tester;
import testing.generation.Generator;
import testing.generation.array.OrderedMarkedIntegerArrayGenerator;
import testing.generation.array.RandomMarkedIntegerArrayGenerator;
import testing.generation.array.ReversedMarkedIntegerArrayGenerator;
import testing.generation.array.ShuffledMarkedIntegerArrayGenerator;
import testing.generation.linked.RandomMarkedIntegerLinkedGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Mejn {
    public static void main(String[] args) throws IOException {
        BufferedWriter out
                = new BufferedWriter(new FileWriter("foo.out"));
        Comparator<Integer> comparator = new NaturalComparator<Integer>();



        Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(comparator);
        Generator<MarkedValue<Integer>> generatorOrdered = new OrderedMarkedIntegerArrayGenerator();
        Generator<MarkedValue<Integer>> generatorRandom = new RandomMarkedIntegerArrayGenerator(10);
        Generator<MarkedValue<Integer>> generatorReversed = new ReversedMarkedIntegerArrayGenerator();
        Generator<MarkedValue<Integer>> generatorShuffle = new ShuffledMarkedIntegerArrayGenerator();

        Generator<MarkedValue<Integer>> generatorRandomLinked = new RandomMarkedIntegerLinkedGenerator(10);




        SortingAlgorithm<MarkedValue<Integer>> BubbleSort = new BubbleSort<MarkedValue<Integer>>(markedComparator);
        SortingAlgorithm<MarkedValue<Integer>> InsertionSort= new InsertionSort<MarkedValue<Integer>>(markedComparator);
        SortingAlgorithm<MarkedValue<Integer>> SelectSort= new SelectSort<MarkedValue<Integer>>(markedComparator);
        SortingAlgorithm<MarkedValue<Integer>> CocktailSort= new CocktailSort<MarkedValue<Integer>>(markedComparator);
        SortingAlgorithm<MarkedValue<Integer>> InsertionSortLinear= new InsertionSortLinear<MarkedValue<Integer>>(markedComparator);
        SortingAlgorithm<MarkedValue<Integer>> InsertionLinked= new InsertionLinked<MarkedValue<Integer>>(markedComparator);

        ArrayList<Integer> listaN= new ArrayList<>(Arrays.asList(10,20,30,40,50,100,200,300,400,500,1000,2000,3000,4000,5000,10000,20000,30000,40000,50000));
        out.write("N;time;timestd;Comparitions;Std Comparitions;Swaps;Stf Swaps;Sorted;Stable;"+"\n");
        for (int liczba: listaN
             ) {
            Result result = Tester.runNTimes(InsertionSortLinear,generatorRandom,liczba, 20);
            System.out.println(result);
            out.write(liczba+";"+result+"\n");

        }
        out.close();

    }
}