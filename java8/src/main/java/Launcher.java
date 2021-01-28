import java.util.List;

import edu.streams.StreamsExamples;
import edu.vo.Language;

public class Launcher {

	public static void main(String[] args) {
		List<Language> languages = Language.listOfLanguages();

		StreamsExamples.instance(languages).run();
	}

	
}

