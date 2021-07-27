package runner;

import io.cucumber.core.resource.ClassLoaders;
import net.serenitybdd.cucumber.cli.Main;
import net.thucydides.core.Thucydides;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

public class SerenityRunner {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"));
        String tags = "@Smoke";
        ArrayList<String> propList = new ArrayList<>(
                Arrays.asList("--glue", "steps",
                        "--tags", tags,
                        "--plugin", "pretty",
                        "classpath:features"));
        Supplier<ClassLoader> classLoader = ClassLoaders::getDefaultClassLoader;
        String[] varResult = new String[propList.size()];
        varResult = propList.toArray(varResult);
        Main.run(varResult,classLoader);
        System.out.println(path.getParent().toString());
        reports(path.toString()+"/target/site/serenity");
    }

    private static void reports(String s) {
        File source=new File("target/site/serenity");
        File target=new File(s);
        HtmlAggregateStoryReporter reporter = new HtmlAggregateStoryReporter(Thucydides.getDefaultProjectKey());
        reporter.setOutputDirectory(target);
        try{
            reporter.generateReportsForTestResultsFrom(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
