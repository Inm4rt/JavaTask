package com.example.task;

import com.example.task.Controller.WebController;
import com.example.task.model.Person;
import com.example.task.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TaskApplicationTests {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ObjectMapper objectMapper;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    private WebController controller;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void resetDb() {
        personRepository.deleteAll();
    }

    private Person createTestPerson(String firstName, String lastName, int age, double mark, boolean education, char category) {
        Person person = new Person(firstName, lastName, age, mark, education, category);
        return personRepository.save(person);
    }

    @Test
    void checkAllPerson() throws Exception {
        createTestPerson("Alexey", "Nikolaev", 21, 99.9, true, 'b');
        createTestPerson("Vlad", "Loh", 22, 1, false, 'a');
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    void checkOnePerson() throws Exception {
        long id = createTestPerson("Alexey", "Nikolaev", 21, 99.9, true, 'b').getId();
        createTestPerson("Vlad", "Loh", 22, 1, false, 'a');
        this.mockMvc.perform(get("/one?id={id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.firstName").value("Alexey"));
    }

    @Test
    public void givenId_whenGetNotExistingPerson_thenStatus404anExceptionThrown() throws Exception {
        mockMvc.perform(get("/one?id=1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void checkAddPerson() throws Exception {
        Person person = new Person("Alexey", "Nikolaev", 21, 99.9, true, 'b');
        this.mockMvc.perform(post("/")
                        .content(objectMapper.writeValueAsString(person))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    void updateAddPerson() throws Exception {
        Person person = createTestPerson("Alexey", "Nikolaev", 21, 99.9, true, 'b');
        person.setLastName("Koly");
        this.mockMvc.perform(put("/update")
                        .content(objectMapper.writeValueAsString(person))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName").value("Koly"));
    }

    @Test
    void deleteAddPerson() throws Exception {
        Person person = createTestPerson("Alexey", "Nikolaev", 21, 99.9, true, 'b');
        this.mockMvc.perform(delete("/delete?id={id}", person.getId()))
                .andExpect(status().isOk());
    }


}
