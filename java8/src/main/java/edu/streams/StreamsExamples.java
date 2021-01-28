package edu.streams;

import java.util.Comparator;
import java.util.List;

import edu.streams.utils.ConsoleCollector;
import edu.streams.utils.Utilities;
import edu.vo.Language;

public class StreamsExamples<T extends Language> {

	private List<T> dataset = null;

	private StreamsExamples(List<T> dataset) {
		this.dataset =dataset;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> StreamsExamples instance(List<T> dataset) {
		return new StreamsExamples(dataset);
	}
	
	private void m1() {
		dataset.stream()
			   .filter(a -> a.getAge()>24)
			   .collect(ConsoleCollector.toConsole())
//		       .collect(ConsoleCollector::toConsole)
		;
	}
	
	
	private void m2() {
		dataset.stream()
			   .max(Comparator.comparing(Language::getAge))
			   .ifPresent(Utilities::print);
			  
	}
	
	private void m3() {
		dataset.stream()
			   .min(Comparator.comparing(Language::getAge))
			   .ifPresent(Utilities::print);
			  
	}

	public void run() {
		 m1();
		 m2();
		 m3();
	}


	
}

