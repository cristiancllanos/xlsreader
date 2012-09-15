package gl.reader;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * MappingIterator
 * 
 * Offer a interface like iterator.
 * 
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 * 
 * @param <T>
 *            same object type.
 */
public class MappingIterator<T> implements Iterator<T> {

	private List<T> entities;
	private Integer position = 0;
	private T lastElementReturned;

	public MappingIterator(List<T> entities) {
		this.entities = entities;
	}

	public boolean hasNext() {
		return position < entities.size();
	}

	public T next() {
		if (position == entities.size()) {
			throw new NoSuchElementException();
		}
		lastElementReturned = entities.get(position++);
		return lastElementReturned;
	}

	public void remove() {
		if (lastElementReturned != null) {
			entities.remove(lastElementReturned);
			lastElementReturned = null;
			position--;
		}
	}

	public void reset() {
		position = 0;
	}

}
