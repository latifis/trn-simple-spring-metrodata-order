package com.acc.orderservice.model.mapper;

import com.acc.orderservice.model.APIResponse;

import java.util.List;

public interface APIResponseMapper<M, R, S>{

    // M -> Model
    // R -> Request
    // S -> Response

    M requestDtoToModel (R r);
    S modelToResponseDto (M m);
    List<S> listModelToResponseDtoList (List<M> m);

    default APIResponse<S> mapToApiResponseDto (M m) {
        S target = modelToResponseDto(m);
        return new APIResponse<>(target);
    }

    default APIResponse<List<S>> mapToApiResponseListDto (List<M> m) {
        List<S> target = listModelToResponseDtoList(m);
        return new APIResponse<>(target);
    }

    default APIResponse<S> mapErrorToApiResponseDto (List<String> error) {
        return new APIResponse<>(error);
    }

}