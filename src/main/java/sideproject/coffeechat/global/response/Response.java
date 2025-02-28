package sideproject.coffeechat.global.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sideproject.coffeechat.global.response.code.SuccessCode;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "message", "result"})
public class Response<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String message;
    private T result;

    public static Response<Void> success() {
        return new Response<Void>(true, SuccessCode.OK.getMessage(), null);
    }

    public static <T> Response<T> success(T result) {
        return new Response<T>(true, SuccessCode.OK.getMessage(), result);
    }

    public static Response<Void> error(String message) {
        return new Response<Void>(false, message, null);
    }

    public static <T> Response<T> error(String message, T result) {
        return new Response<T>(false, message, result);
    }
}
