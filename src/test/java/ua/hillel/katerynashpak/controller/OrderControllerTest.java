package ua.hillel.katerynashpak.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.hillel.katerynashpak.Hw17Application;
import ua.hillel.katerynashpak.controller.response.ApiResponse;
import ua.hillel.katerynashpak.dto.OrderRecordDto;
import ua.hillel.katerynashpak.dto.ProductDto;

import java.util.Arrays;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Hw17Application.class)
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetOrders() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v6/orders/orders")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ApiResponse response = objectMapper.readValue(contentAsString, ApiResponse.class);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.isSuccess());
    }

    @Transactional
    @Test
    void testGetOrderById() throws Exception {
        Integer orderId = 1;  // Replace with an actual order ID
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v6/orders/" + orderId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        OrderRecordDto order = objectMapper.readValue(contentAsString, OrderRecordDto.class);

        Assertions.assertNotNull(order);
        Assertions.assertEquals(orderId, order.getId());
    }

    @Test
    void testCreateOrder() throws Exception {
        OrderRecordDto order = OrderRecordDto.builder()
                .id(2)
                .date(new Date())
                .cost(100.0)
                .products(Arrays.asList(
                        ProductDto.builder().id(3).name("Product3").cost(150.0).build(),
                        ProductDto.builder().id(4).name("Product4").cost(250.0).build()
                ))
                .build();

        mockMvc.perform(post("/api/v6/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }
}
