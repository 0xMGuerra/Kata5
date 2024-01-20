package software.ulpgc;

import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;

public class FactorialCommand implements Command {
    @Override
    public Output execute(Input input) {
        return factorial(input.get("number"));
    }

    private Output factorial(String number) {
        return factorial(parseInt(number));
    }

    private static Output factorial(int n) {
        if(n > 20) {
            return Command.output(406, null);
        }
        long reduce = LongStream.range(2, n + 1).reduce(1, (a, i) -> a * i);
        return Command.output(200, String.valueOf(reduce));
    }
}
