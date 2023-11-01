package homework.exceptionAPI.exception;

import homework.exceptionAPI.entity.ErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.AbstractMap;
import java.util.Map;

public class CustomException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    // 타입은 어떤 것이든 상관없음
    @Getter
    private Map.Entry<String, Object> data;

    @Override
    public String getMessage() {
        if(StringUtils.hasLength(this.message)) return this.message; // 현재 메세지가 비어있지 않으면(길이가 있으면..)
        return errorCode.getMessage();
    }

    public CustomException(ErrorCode errorCode, String message, Object object) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(),data);
    }

}
