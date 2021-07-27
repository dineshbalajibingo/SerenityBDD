package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.Thucydides;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class TestRunner {
    private static String[] defaultOptions = {
          "--glue", "steps",
            "--tags", "@Smoke",
            "--plugin", "pretty","classpath:features/",


    };
    public static void main(String[] args) {
        String varPathStr = System.getProperty("user.dir");
        SecurityManager manager = new IgnoreExitCall();
        System.setSecurityManager(manager);

        try {
           Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
            io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
            test(""+varPathStr+"target/site/serenity");

        } catch (SecurityException | IOException e) {
            System.out.println("Ignore exit");
        }

    }


public static void test(String filePath) throws IOException {
File objSourceDirectoryRef = new File("target/site/serenity");
File objTargetDirectoryRef = new File(filePath);
    HtmlAggregateStoryReporter reporter = new HtmlAggregateStoryReporter(Thucydides.getDefaultProjectKey());
    reporter.setOutputDirectory(objSourceDirectoryRef);
    {
        reporter.generateReportsForTestResultsFrom(objSourceDirectoryRef);
    }
}
}
