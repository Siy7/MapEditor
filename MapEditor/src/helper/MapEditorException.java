package helper;

public class MapEditorException extends Exception {
	private static final long serialVersionUID = 7718828512143293558L;
	private final ErrorCode code;

	public MapEditorException(final ErrorCode code) {
		super();
		this.code = code;
	}

	public MapEditorException(final String message, final Throwable cause, final ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public MapEditorException(final String message, final ErrorCode code) {
		super(message);
		this.code = code;
	}

	public MapEditorException(final Throwable cause, final ErrorCode code) {
		super(cause);
		this.code = code;
	}

	public ErrorCode getCode() {
		return this.code;
	}
}
