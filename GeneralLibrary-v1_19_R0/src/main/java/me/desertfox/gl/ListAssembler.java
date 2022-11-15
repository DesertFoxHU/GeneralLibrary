package me.desertfox.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * One-line list assembler<br>
 * Don't use unnecessary<br>
 * @param <T>
 */
public class ListAssembler<T> {

    private List<T> assembly;

    public ListAssembler<T> add(T... entry){
        assembly.addAll(Arrays.asList(entry));
        return this;
    }

    public ListAssembler<T> add(List<T> entry){
        assembly.addAll(entry);
        return this;
    }

    public ListAssembler<T> remove(T... entry){
        assembly.remove(entry);
        return this;
    }

    public List<T> toList(){
        return new ArrayList<>(assembly);
    }
}
