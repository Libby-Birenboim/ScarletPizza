package Classes;

/**
 * this is the Customizable interface that allows for users to customize their pizza
 * @author Selin Altiparmak, Libby Birenboim
 *
 * @param <E>
 */
public interface Customizable<E> {
	boolean add(Object obj);
	boolean remove(Object obj);
}