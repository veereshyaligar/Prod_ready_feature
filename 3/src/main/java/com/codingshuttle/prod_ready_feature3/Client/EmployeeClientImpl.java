package com.codingshuttle.prod_ready_feature3.Client;

import com.codingshuttle.prod_ready_feature3.advice.ApiResponse;
import com.codingshuttle.prod_ready_feature3.config.RestClientConfig;
import com.codingshuttle.prod_ready_feature3.dto.EmployeeDTO;
import com.codingshuttle.prod_ready_feature3.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        try{
            ApiResponse<List<EmployeeDTO>> listApiResponse= restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req, res)->{
                        System.out.println("Error Occurred: "+ Arrays.toString(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create Employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });

            return listApiResponse.getData();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
