package helper;

public enum ErrorCode {
	ERROR_0, ERROR_1, ERROR_404;

	public String getErrorMessage() {
		switch (this) {
		case ERROR_0:
			return "Error 0 - Unknown Error";
		case ERROR_1:
			return "Error 1 - Predicted Error";
		case ERROR_404:
			return "404 - Not found!";
		default:
			return "not specified error";
		}
	}

}
