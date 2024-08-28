package com.acc.orderservice.external.decoder;

import com.acc.orderservice.exception.CustomException;
import com.acc.orderservice.model.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ErrorMessage message = mapper.readValue(
                    response.body()
                            .asReader(), ErrorMessage.class);
            return new CustomException(
                    message.getMessage(),
                    message.getError(),
                    response.status()
            );
        }catch (IOException e){
            throw new CustomException(
                    "Internal Server Error",
                    "INTERNAL_SERVER_ERROR",
                    500
            );
        }
    }
}
