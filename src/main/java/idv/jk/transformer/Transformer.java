package idv.jk.transformer;

public interface Transformer<In, Out> {
    Out transform(In in);
}
