package com.betrybe.museumfinder.solution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeController {
  @MockBean
  CollectionTypeService collectionTypeService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void getcountByCollectionTypes() throws Exception {

    String url = "/collections/count/hist,imag";

    mockMvc.perform(get(url)).andExpect(status().isOk()).andExpect(jsonPath("$.count").value(492));
  }
}
