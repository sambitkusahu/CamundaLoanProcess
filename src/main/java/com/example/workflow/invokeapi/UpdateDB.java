package com.example.workflow.invokeapi;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

public class UpdateDB implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "http://localhost:8085/api/getMsg";
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("Result from outbound api call: "+ result);
    }
}
