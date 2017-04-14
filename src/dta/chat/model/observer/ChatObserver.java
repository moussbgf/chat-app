package dta.chat.model.observer;

@FunctionalInterface
public interface ChatObserver<T> {
	
	void update(T obj);
	
}
