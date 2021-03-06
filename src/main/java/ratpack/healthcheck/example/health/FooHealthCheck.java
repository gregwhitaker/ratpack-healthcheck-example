package ratpack.healthcheck.example.health;

import com.google.inject.Singleton;
import ratpack.exec.Promise;
import ratpack.health.HealthCheck;
import ratpack.healthcheck.example.data.foo.FooRepository;
import ratpack.registry.Registry;

/**
 * Dummy example healthcheck that checks if foo component is healthy.
 */
@Singleton
public class FooHealthCheck implements HealthCheck {

    @Override
    public String getName() {
        return "foo";
    }

    @Override
    public Promise<Result> check(Registry registry) throws Exception {
        FooRepository fooRepo = registry.get(FooRepository.class);
        return fooRepo.isHealthy().map(healthy -> {
            if (healthy) {
                return Result.healthy("The foo endpoint is currently healthy");
            } else {
                return Result.unhealthy("The foo endpoint is currently unhealthy");
            }
        });
    }
}
