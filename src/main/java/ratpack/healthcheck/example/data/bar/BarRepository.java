package ratpack.healthcheck.example.data.bar;

import ratpack.exec.Operation;
import ratpack.exec.Promise;

/**
 * Repository that is keeping track of the health of the bar component that gets set via the api.
 */
public interface BarRepository {

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
