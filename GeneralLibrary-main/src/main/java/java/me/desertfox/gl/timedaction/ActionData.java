package java.me.desertfox.gl.timedaction;

public class ActionData<T, S, U> {

    public T t;
    public S s;
    public U u;

    public ActionData(T t, S s, U u) {
        this.t = t;
        this.s = s;
        this.u = u;
    }
}
