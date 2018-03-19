package ratpack.healthcheck.example.data.foo;

import com.google.inject.Singleton;
import ratpack.exec.Operation;
import ratpack.exec.Promise;

@Singleton
public class DefaultFooRepository implements FooRepository {

    @Override
    public Operation setHealthy() {
        return null;
    }

    @Override
    public Operation setUnhealthy() {
        return null;
    }

    @Override
    public Promise<Boolean> isHealthy() {
        return null;
    }
}
