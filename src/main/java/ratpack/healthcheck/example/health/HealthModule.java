package ratpack.healthcheck.example.health;

import com.google.inject.AbstractModule;

public class HealthModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(FooHealthCheck.class);
        bind(BarHealthCheck.class);
    }
}
