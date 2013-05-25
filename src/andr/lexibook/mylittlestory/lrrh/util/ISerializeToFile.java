package andr.lexibook.mylittlestory.lrrh.util;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 5/9/13
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ISerializeToFile<T> {

    public void save(T cls);

    public T get();
}
