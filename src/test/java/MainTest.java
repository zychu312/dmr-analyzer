import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {

        final var path = Optional.ofNullable(getClass()
                .getClassLoader()
                .getResource("90_473_1687.csv"))
                .map(URL::getFile)
                .map(Path::of)
                .orElseThrow(() -> new RuntimeException("Wrong path to file"));

        final var data = DataReader.read(path);
        final var results = DataProcessor.process(data, 4);

        System.out.println(results);
    }
}