package ratpack.healthcheck.example.data.bar;

import ratpack.exec.Operation;
import ratpack.exec.Promise;

public interface BarRepository {

    Operation setHealthy();

    Operation setUnhealthy();

    Promise<Boolean> isHealthy();
}
