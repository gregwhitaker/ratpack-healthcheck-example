package ratpack.healthcheck.example;

import ratpack.guice.Guice;
import ratpack.health.HealthCheckHandler;
import ratpack.healthcheck.example.api.ApiEndpoints;
import ratpack.healthcheck.example.api.ApiModule;
import ratpack.healthcheck.example.data.DataModule;
import ratpack.healthcheck.example.health.HealthModule;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

public class Main {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c
                        .env()
                        .baseDir(BaseDir.find())
                        .build()
                )
                .registry(Guice.registry(b -> b
                        .module(ApiModule.class)
                        .module(DataModule.class)
                        .module(HealthModule.class))
                )
                .handlers(chain -> chain
                        .get("health/:name?", HealthCheckHandler.class)
                        .insert(ApiEndpoints.class)
                )
        );
    }
}
