import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) {

        if(args.length < 2 ) throw new RuntimeException("Pass file path as a first argument, and no. of divisions as second one");

        final var divisions = Integer.parseInt(args[1]);

        final var data = DataReader.read(Path.of(args[0]));

        final var results = DataProcessor.process(data, divisions);

        final var resultsAsCsvLines = results
                .entrySet()
                .stream()
                .map(entry -> {
                    var sb = new StringBuilder();

                    sb
                            .append(entry.getKey())
                            .append(" ");

                    entry
                            .getValue()
                            .forEach(val -> sb
                                    .append(val)
                                    .append(" "));

                    return sb.toString();
                })
                .collect(Collectors.toList());

        try {
            final var resultsPath = Path.of(args[0]).getParent().resolve(Instant.now() + "_results.csv");
            Files.write(resultsPath, resultsAsCsvLines, StandardOpenOption.CREATE);
            System.out.println("Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
