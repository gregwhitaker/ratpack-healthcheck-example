package ratpack.healthcheck.example.data.bar;

import com.google.inject.Singleton;
import ratpack.exec.Operation;
import ratpack.exec.Promise;

@Singleton
public class DefaultBarRepository implements BarRepository {

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
