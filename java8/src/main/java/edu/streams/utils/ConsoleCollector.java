package edu.streams.utils;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
 
public class ConsoleCollector<T> implements Collector<T, List<T>, String> {
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }
 
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }
 
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (acc, ps) -> {
            acc.addAll(ps);
            return acc;
        };
    }
 
    @Override
    public Function<List<T>, String> finisher() {
        return a -> { print(a); return "";};
        }
    
    private void print(List<T> a) {
		System.out.println("%%%%%%%%%%%%%%%");

    	a.stream()
    	 .forEach(b-> System.out.println("\t"+b));
    	System.out.println("\n\n");
    	
    }
 
    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return EnumSet.of(Collector.Characteristics.UNORDERED);
    }
    
//    public static <T> Collector<T, ?, ?> toConsole() {
    public static <T> ConsoleCollector<T> toConsole() {
    	return new ConsoleCollector<>();
    }
}
