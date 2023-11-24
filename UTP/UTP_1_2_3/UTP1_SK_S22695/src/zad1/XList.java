package zad1;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;


public class XList<T> extends ArrayList<T> {

    public XList(T... elements) {
        this(Arrays.asList(elements));
    }

    public XList(Collection<T> elements) {
        super(elements);
    }

    public static <T> XList<T> of(T... elemets) {
        return new XList<T>(elemets);
    }

    public static <T> XList<T> of(Collection<T> elements) {
        return new XList<T>(elements);
    }

    public static XList<String> charsOf(String elements) {
        ArrayList<String> chars = elements.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toCollection(ArrayList::new));

        return new XList<String>(chars);
    }

    public static XList<String> tokensOf(String elements) {
        ArrayList<String> tokens = (ArrayList<String>) Arrays.stream(elements.split(" "))
                .collect(Collectors.toList());

        return new XList<String>(tokens);
    }

    public static XList<String> tokensOf(String elements, String signToDelete) {
        return charsOf(elements.replace(signToDelete, ""));
    }

    public XList<T> union(T ... otherList) {
        XList<T> result = new XList<T>(this);
        result.addAll(Arrays.asList(otherList));
        return result;
    }

    public XList<T> union(Collection<T> otherList) {
        XList<T> result = new XList<T>(this);
        result.addAll(otherList);
        return result;
    }

    public XList<T> diff(Collection<T> otherList) {
        XList<T> result = new XList<T>(this);
        result.removeIf(otherList::contains);
        return result;
    }

    public XList<T> unique() {
        List<T> result = this.stream().distinct().collect(Collectors.toList());
        return new XList<T>(result);
    }

    public XList<XList<T>> combine() {
        XList<XList<T>> combined = new XList<>();
        return combined;
    }

    public void forEachWithIndex(BiConsumer<T, Integer> func) {
        for(int i=0; i<this.size(); i++) {
            func.accept(this.get(i), i);
        }
    }

}