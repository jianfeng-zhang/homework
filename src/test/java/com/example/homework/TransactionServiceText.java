package com.example.homework;

import com.example.homework.domain.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceText {
    @Mock
    RestTemplate restTemplate;

    @Test
    public void trainingNotNull(){
        Page page = new Page();
        when(restTemplate.getForObject("", Page.class)).thenReturn(page);

    }

}
