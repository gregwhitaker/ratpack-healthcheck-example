package ratpack.healthcheck.example.data.foo;

import com.google.inject.Singleton;
import ratpack.exec.Blocking;
import ratpack.exec.Operation;
import ratpack.exec.Promise;

/**
 * Repository that is keeping track of the health of the foo component that gets set via the api.
 */
@Singleton
public class DefaultFooRepository implements FooRepository {

    private volatile boolean healthy = true;

    @Override
    public Operation setHealthy() {
        return Operation.of(() -> healthy = true);
    }

    @Override
    public Operation setUnhealthy() {
        return Operation.of(() -> healthy = false);
    }

    @Override
    public Promise<Boolean> isHealthy() {
        return Blocking.get(() -> healthy);
    }
}
