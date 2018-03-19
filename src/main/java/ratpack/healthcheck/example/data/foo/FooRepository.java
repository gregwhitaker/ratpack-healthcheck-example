package ratpack.healthcheck.example.data.foo;

import ratpack.exec.Operation;
import ratpack.exec.Promise;

/**
 * Repository that is keeping track of the health of the bar component that gets set via the api.
 */
public interface FooRepository {

    /**
     * Sets the component to healthy status
     * @return
     */
    Operation setHealthy();

    /**
     * Sets the component to unhealthy status
     * @return
     */
    Operation setUnhealthy();

    /**
     * @return current health status of the component
     */
    Promise<Boolean> isHealthy();
}
