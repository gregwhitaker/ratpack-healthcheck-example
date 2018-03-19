package ratpack.healthcheck.example.api.foo;

import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.healthcheck.example.data.foo.FooRepository;

public class FooHandler implements Handler {

    @Inject
    private FooRepository fooRepo;

    @Override
    public void handle(Context ctx) throws Exception {

    }
}
