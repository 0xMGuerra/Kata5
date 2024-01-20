package software.ulpgc;

import spark.Request;
import spark.Response;
import spark.Spark;

public class Main {
    public static void main(String[] args) {

        Spark.port(8080);
        Spark.get("/getFactorial", ((request, response) -> new CommandExecutor(request, response).execute(new FactorialCommand())));
    }

    private record CommandExecutor(Request request, Response response) {
        public Object execute(Command command) {
            Command.Output output = command.execute(input());
            return output.result();
        }

        private Command.Input input() {
            return new Command.Input() {
                @Override
                public String get(String key) {
                    return oneOf(request.params(key), request.queryParams(key));
                }

                private String oneOf(String params, String s) {
                    return params != null ? params : s;
                }
            };
        }
    }
}