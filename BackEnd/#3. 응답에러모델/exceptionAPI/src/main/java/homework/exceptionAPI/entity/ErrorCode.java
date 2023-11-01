package homework.exceptionAPI.entity;

import jdk.jshell.Snippet;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // enum 선언!
    OK(2000, "OK", HttpStatus.OK),
    BAD(5000, "BAD REQUEST", HttpStatus.OK),
    ;

    @Getter
    private final int code;
    @Getter
    private final String message;
    @Getter
    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
