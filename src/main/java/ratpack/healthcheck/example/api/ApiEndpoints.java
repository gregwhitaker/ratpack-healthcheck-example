package ratpack.healthcheck.example.api;

import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.health.HealthCheckHandler;
import ratpack.healthcheck.example.api.bar.BarHandler;
import ratpack.healthcheck.example.api.foo.FooHandler;

public class ApiEndpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.post("foo", FooHandler.class);
        chain.post("bar", BarHandler.class);

        // Healthcheck
        chain.get("health/:name?", HealthCheckHandler.class);
    }
}
