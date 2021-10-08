package me.desertfox.gl.response;

public class Response<E extends Enum<ResponseType>, S> {

    private E e;
    private S s = null;

    public Response(E e, S s) {
        this.e = e;
        this.s = s;
    }

    public Response(E e) {
        this.e = e;
    }

    public ResponseType getType() {
        return e.getDeclaringClass().cast(e);
    }

    public S getValue(){
        return s;
    }

}
