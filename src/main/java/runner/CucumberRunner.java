package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class CucumberRunner {
    private static ArrayList<String> defaultOptions = new ArrayList<String>(Arrays.asList(
            "--glue", "steps",
            "--tags", "@Smoke",
            "--plugin","pretty",
            "classpath:features"));
    public static void main(String[] args) throws IOException {
        SecurityManager manager = new IgnoreExitCall();
        Path path = Paths.get(System.getProperty("user.dir"));
        defaultOptions.add("--plugin");
        defaultOptions.add("html:" + path.toString()+"/report.html");
        Object[] x = defaultOptions.toArray();
        String[] y= Arrays.copyOf(x,x.length,String[].class);
        System.setSecurityManager(manager);
        try {
            Stream<String> cucumberOptions = Stream.concat(Stream.of(y), Stream.of(args));
            io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
        } catch (SecurityException e) {
            System.out.println("Ignore exit");
        }
    }
}
