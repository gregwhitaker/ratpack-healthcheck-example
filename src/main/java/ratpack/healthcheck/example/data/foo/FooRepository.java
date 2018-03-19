package ratpack.healthcheck.example.data.foo;

import ratpack.exec.Operation;
import ratpack.exec.Promise;

public interface FooRepository {

    Operation setHealthy();

    Operation setUnhealthy();

    Promise<Boolean> isHealthy();
}
