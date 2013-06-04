package monopoly.web.util;

import java.util.concurrent.LinkedBlockingQueue;

public class MQ<T> {
	
	private final LinkedBlockingQueue<T> q = new LinkedBlockingQueue<>();
	
	public T getNextRequest() {
		try {
			return q.take();
		} catch (InterruptedException e) {
			return null;
		}
	}
	
	public void submitRequest(T req) {
		q.add(req);
	}

}
