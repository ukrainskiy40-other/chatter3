package ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {
    
    private String errorName;

    private Integer errorCode;

    private String[] errorDetails;

    private T body;

    public Result(T body) {
        this.body = body;
    }

    public static <T> Result<T> success() {
        return new Result<>();
    }

    public static <T> Result<T> error(String errorName, String... errorDetails) {
        Result<T> result = new Result<>();
        result.setErrorName(errorName);
        result.setErrorDetails(errorDetails);
        return result;
    }
}
