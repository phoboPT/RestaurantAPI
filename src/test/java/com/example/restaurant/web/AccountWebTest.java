package com.example.restaurant.web;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.model.Account;
import com.example.restaurant.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest (AccountEndpoint.class)

public class AccountWebTest {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountEndpoint accountEndpoint;

    @Test
    public void createShouldSaveAndReturnAccountModel() throws Exception {
        Address address = new Address("street",
                                      "city",
                                      "state",
                                      "zip");

        Account account = new Account("password",
                                      "hugo",
                                      address,
                                      AccountStatus.ACTIVE);

        when(accountEndpoint.create(account)).thenReturn(account);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/account/create")
                                                                          .contentType(MediaType.APPLICATION_JSON)
                                                                          .accept(MediaType.APPLICATION_JSON)
                                                                          .content(this.mapper.writeValueAsString(account));

        mockMvc.perform(mockRequest)
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.password").value("password"))
               .andExpect(jsonPath("$.username").value("hugo"))
               .andExpect(jsonPath("$.address.street").value("street"))
               .andExpect(jsonPath("$.address.city").value("city"))
               .andExpect(jsonPath("$.address.state").value("state"))
               .andExpect(jsonPath("$.address.zip").value("zip"))
               .andExpect(jsonPath("$.status").value(AccountStatus.ACTIVE.toString()));
    }

}
