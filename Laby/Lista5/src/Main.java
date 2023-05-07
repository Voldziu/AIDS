
import java.util.Comparator;
import java.util.List;

import core.SortingAlgorithm;
import testing.*;
import testing.generation.*;
import testing.generation.array.*;
import testing.generation.linked.RandomMarkedIntegerLinkedGenerator;

public class Main {

	public static void main(String[] args) {
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

		
		Result result = Tester.runNTimes(InsertionSort,generatorRandom,1000, 20);
		
		System.out.println("time [ms]: " + result.averageTimeInMilliseconds() + " +- " + result.timeStandardDeviation());
		System.out.println("comparisons: " + result.averageComparisons() + " +- " + result.comparisonsStandardDeviation());
		System.out.println("swaps: " + result.averageSwaps() + " +- " + result.swapsStandardDeviation());
		System.out.println("always sorted: " + result.sorted());
		System.out.println("always stable: " + result.stable());
		System.out.println(result);
	}

}
