package monopoly.web.util;

public interface IMQ<T> {

	public abstract void submitRequest(T req);

	public abstract T getNextRequest();
	

}
