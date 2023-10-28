package alvarez.fernando.padroesprojetojava.handler;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HandlerChain<I, O> implements Iterable<Handler<I, O>> {

    private final Iterator<Handler<I, O>> handlers;

    @SafeVarargs
    public HandlerChain(Handler<I, O>... handlers) {
        this(Arrays.asList(handlers));
    }

    public HandlerChain(List<Handler<I, O>> handlers) {
        this.handlers = handlers.iterator();
        System.out.println("Created chain: " + handlers.size() + " handlers");
    }

    public void next(I input, O output) {
        if (!this.handlers.hasNext()) {
            System.out.println("No more handler to invoke");
            return;
        }

        final Handler<I, O> nextHandler = this.handlers.next();
        System.out.println("Invoking next handler: " + nextHandler.getClass().getSimpleName());
        nextHandler.handleNext(this, input, output);
    }

    @Override
    public Iterator<Handler<I, O>> iterator() {
        return this.handlers;
    }

}
