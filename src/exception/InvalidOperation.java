package exception;

public class InvalidOperation extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidOperation() {
	}

	public InvalidOperation(String message) {
		super(message);
	}

	public InvalidOperation(Throwable cause) {
		super(cause);
	}

	public InvalidOperation(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidOperation(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
