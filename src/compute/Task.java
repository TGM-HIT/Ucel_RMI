package compute;

/**
 * Interface zwischen der Compute Engine und der Arbeit, welche erledigt werden muss
 * 
 * @author Johannes Ucel
 * @version 01. Apr. 2016
 *
 * @param <T>
 */
public interface Task<T> {
    T execute();
}