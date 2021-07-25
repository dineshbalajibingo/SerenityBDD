package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        tags = "@Smoke",
        features = "src/main/resources/features",
        glue = {"steps"}
)
public class TestRunner {
   /* private static String[] defaultOptions = {
            "--glue", "steps",
            "--features", "src/test/resources/features",
            "--plugin", "pretty",

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

    }*/
}
