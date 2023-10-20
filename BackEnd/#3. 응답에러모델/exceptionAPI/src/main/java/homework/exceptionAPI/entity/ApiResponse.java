package homework.exceptionAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class ApiResponse<T> {
    private final Status status;
    private List<T> results;

    // 생성자 - 정상 응답
    public ApiResponse(List<T> results) {
        this.status = new Status(2000, "OK");
        this.results = results;
    }

    @Getter
    @AllArgsConstructor
    private static class Status{
        private int code;
        private String message;
    }
}
