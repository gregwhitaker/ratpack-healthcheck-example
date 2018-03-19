package ratpack.healthcheck.example.health;

import com.google.inject.Singleton;
import ratpack.exec.Promise;
import ratpack.health.HealthCheck;
import ratpack.healthcheck.example.data.bar.BarRepository;
import ratpack.registry.Registry;

@Singleton
public class BarHealthCheck implements HealthCheck {

    @Override
    public String getName() {
        return "BarHealthCheck";
    }

    @Override
    public Promise<Result> check(Registry registry) throws Exception {
        BarRepository barRepo = registry.get(BarRepository.class);
        return barRepo.isHealthy().map(healthy -> {
            if (healthy) {
                return Result.healthy("The bar endpoint is currently healthy");
            } else {
                return Result.unhealthy("The bar endpoint is currently unhealthy");
            }
        });
    }
}
