package ratpack.healthcheck.example.health;

import ratpack.exec.Promise;
import ratpack.health.HealthCheck;
import ratpack.registry.Registry;

public class FooHealthCheck implements HealthCheck {

    @Override
    public String getName() {
        return "FooHealthCheck";
    }

    @Override
    public Promise<Result> check(Registry registry) throws Exception {
        return null;
    }
}
