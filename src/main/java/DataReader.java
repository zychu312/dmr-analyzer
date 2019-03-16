import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class DataReader {
    static Stream<Cell> read(Path filePath) {
        try {
            return Files
                    .readAllLines(filePath)
                    .stream()
                    .map(line -> {
                        final var parts = line.split(" ");
                        if(parts.length < 4) throw new RuntimeException("Line doesn't contain all data");
                        final var x = Short.parseShort(parts[0]);
                        final var y = Short.parseShort(parts[2]);
                        final var z = Short.parseShort(parts[1]);
                        final var id = Long.parseLong(parts[3]);

                        return new Cell(x,y,z,id);

                    });
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }
}
