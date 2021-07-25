package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import java.util.stream.Stream;


public class TestRunner {
    private static String[] defaultOptions = {
            "--glue", "steps",
            "--tags", "@Smoke",
            "--plugin", "pretty","classpath:features/"

    };
    public static void main(String[] args) {
        SecurityManager manager = new IgnoreExitCall();
        System.setSecurityManager(manager);
        try {
            Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
            io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
        } catch (SecurityException e) {
            System.out.println("Ignore exit");
        }

    }
}
