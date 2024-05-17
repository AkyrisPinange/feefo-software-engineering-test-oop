

import org.feefo.jobtitles.Normalizer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> normalizedJobTitles = Arrays.asList("Architect", "Software engineer", "Quantity surveyor", "Accountant");
        Normalizer normalizer = new Normalizer(normalizedJobTitles);

        String jt = "Java engineer";
        String normalisedTitle = normalizer.normalize(jt);
        System.out.println(jt + " > " + normalisedTitle);

        jt = "C# engineer";
        normalisedTitle = normalizer.normalize(jt);
        System.out.println(jt + " > " + normalisedTitle);

        jt = "Chief Accountant";
        normalisedTitle = normalizer.normalize(jt);
        System.out.println(jt + " > " + normalisedTitle);

        jt = "Accountant";
        normalisedTitle = normalizer.normalize(jt);
        System.out.println(jt + " > " + normalisedTitle);

        jt = "QA";
        normalisedTitle = normalizer.normalize(jt);
        System.out.println(jt + " > " + normalisedTitle);
    }
}