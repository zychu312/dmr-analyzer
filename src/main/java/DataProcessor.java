import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DataProcessor {
    static HashMap<Long, List<Long>> process(Stream<Cell> input, int divisions) {

        final var result = new HashMap<Long, List<Long>>();

        final var list = input.collect(Collectors.toList());

        final var height = list
                .stream()
                .map(Cell::getZ)
                .max(Short::compareTo)
                .map(index -> index + 1) // Convert index to height
                .orElseThrow(() -> new RuntimeException("Cannot calculate height"));

        IntStream
                .range(1,divisions)
                .forEach(i -> {

                    final var actualHeight = i * height / divisions;

                    final var cells = list.stream().filter(cell -> cell.getZ() == actualHeight);

                    cells
                            .forEach(cell -> {

                                final Supplier<List<Long>> emptyListSupplier = () -> IntStream
                                        .range(0, divisions-1)
                                        .boxed()
                                        .map(l -> 0L)
                                        .collect(Collectors.toList());

                                result.putIfAbsent(cell.getId(), emptyListSupplier.get());

                                final var value = result.get(cell.getId()).get(i-1);
                                final var newValue = value + 1;

                                result.get(cell.getId()).set(i-1, newValue);


                            });


                });

        return result;
    }
}
