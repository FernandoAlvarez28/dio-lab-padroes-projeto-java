package alvarez.fernando.padroesprojetojava.handler;

public interface Handler<I, O> {

    void handleNext(HandlerChain<I, O> handlerChain, I input, O output);

}
