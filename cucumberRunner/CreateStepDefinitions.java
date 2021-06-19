package cucumberRunner;

import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import gherkin.formatter.Formatter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;
import gherkin.parser.Parser;
import gherkin.util.FixJava;

public class CreateStepDefinitions implements Formatter {

    List<Feature> features = new ArrayList<>();

    public static void main(String... args) throws Exception {

            OutputStreamWriter out = new OutputStreamWriter(System.out, "UTF-8");

            // Read the feature file into a string.
            File f = new File("/Users/ashdiksh/workspace/autoexsel-cucumber/features/TestFeatures.feature");
            String input = FixJava.readReader(new FileReader(f));

            // Parse the gherkin string with our own formatter.
            CreateStepDefinitions formatter = new CreateStepDefinitions();
            Parser parser = new Parser(formatter);
            parser.parse(input, f.getPath(), 0);

            for (Feature feature: formatter.features) {
                System.out.format("%s: %s%n", feature.getName(), feature.getDescription());
            }
    }

    @Override
    public void feature(Feature feature) {
        features.add(feature);
    }

	public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line) {
		// TODO Auto-generated method stub
		System.out.println("state: "+state);
		System.out.println("event: "+event);
		System.out.println("legalEvents: "+legalEvents);
		System.out.println("line: "+line);
		
	}

	public void uri(String uri) {
		// TODO Auto-generated method stub
		System.out.println("uri: "+uri);
	}

	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		// TODO Auto-generated method stub
		
	}

	public void examples(Examples examples) {
		// TODO Auto-generated method stub
		
	}

	public void startOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		System.out.println("AA"+scenario.getTags());
	}

	public void background(Background background) {
		// TODO Auto-generated method stub
		
	}

	public void scenario(Scenario scenario) {
//		System.out.println(scenario.getKeyword()+": "+scenario.getName());
		System.out.println(scenario.getKeyword()+": "+scenario.toString());
	}

	public void step(Step step) {
		System.out.println(step.getKeyword()+step.getName());
	}

	public void endOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		System.out.println("BB"+scenario.getTags());
	}

	public void done() {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void eof() {
		// TODO Auto-generated method stub
		
	}

    // ...
    // follow all the Formatter methods to implement.
}
