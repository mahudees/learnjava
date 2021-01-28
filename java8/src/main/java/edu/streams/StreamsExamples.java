package edu.streams;

import java.util.List;

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
			   .filter(a -> a.getAge()>25)
			   .forEach(Utilities::print);
			  
	}
	
	public void run() {
		m1();
	}


	
}

