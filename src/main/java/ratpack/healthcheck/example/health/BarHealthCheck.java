package ratpack.healthcheck.example.health;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.exec.Promise;
import ratpack.health.HealthCheck;
import ratpack.healthcheck.example.data.bar.BarRepository;
import ratpack.registry.Registry;

@Singleton
public class BarHealthCheck implements HealthCheck {

    @Inject
    private BarRepository barRepo;

    @Override
    public String getName() {
        return "bar";
    }

    @Override
    public Promise<Result> check(Registry registry) throws Exception {
        return barRepo.isHealthy().map(healthy -> {
            if (healthy) {
                return Result.healthy("The bar endpoint is currently healthy");
            } else {
                return Result.unhealthy("The bar endpoint is currently unhealthy");
            }
        });
    }
}
