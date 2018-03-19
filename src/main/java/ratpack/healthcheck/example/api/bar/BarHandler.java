package ratpack.healthcheck.example.api.bar;

import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.healthcheck.example.data.bar.BarRepository;

public class BarHandler implements Handler {

    @Inject
    private BarRepository barRepo;

    @Override
    public void handle(Context ctx) throws Exception {

    }
}
