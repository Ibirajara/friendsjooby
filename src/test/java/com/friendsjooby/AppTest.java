package com.friendsjooby;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author jooby generator
 */
public class AppTest extends BaseTest {
    static String CONTACT_IN = "{\"name\":\"Usuário de Teste\","
            +" \"phone\":\"99991234\"}";
    static String CONTAC_OUT = "{\"id\":1,"
            + "\"name\":\"Usuário de Teste\","
            +"\"phone\":\"99991234\"}";
    @Test
    public void insert() throws Exception {
        String json = "{\n" +
            "    \"name\":\"Usuário de Teste\",\n" +
            "    \"phone\":\"99991234\"\n" +
        "}";

        server.post("/contacts")
            .body(json, "application/json") 
            .expect(200);
    }
    @Test
    public void findById() throws Exception{
        server.post("/contacts").body(CONTACT_IN, "application/json");
        server.get("/contacts1").expect(CONTAC_OUT).expect(200);
    }

}
