package com.friendsjooby;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Results;
import org.jooby.json.Jackson;

/**
 * @author jooby generator
 */
public class App extends Jooby {
    ArrayList<Contato> contatos = new ArrayList<>();
    Integer nc;
    ObjectMapper mapper = new ObjectMapper();
  {
      use(new Jackson() );
    get("/todos/:id", (req) -> {
        Integer id = null;
        String result = null;
        int statusCode = 404;
        id = Integer.parseInt(req.param("id").value());
        for(Contato c: contatos){
            if(c.getId() == id){
                result = mapper.writeValueAsString(c);
            }
        }
        if(result != null){
            return Results.with(result).status(200).type(MediaType.text);
        }else{
            return Results.with("Contact not found!").status(statusCode).type(MediaType.text);
        }
        
    });
    
    get("/todos/listall", req -> {
            return contatos;
        }).name("list all contacts.");
    
    post("/todos", req -> {
        String message = null;
        String jsonInString = req.body().value();
        Contato c = mapper.readValue(jsonInString, Contato.class);
        c.setId(newFriend());
        message = mapper.writeValueAsString(c);
        int statusCode = 400;
            if (c.getName().equals("")) {
                message = "Name cannot be empty!";
            } else if (c.getPhone().isEmpty()) {
                message = "Phone cannot be empty!";
            } else {
                statusCode = 200;
                c.setId(this.contatos.size()+1);
                this.contatos.add(c);
            }

            return Results.with(message).status(statusCode).type("text/plain");
        }

    )
    .consumes(MediaType.json)
    .name("Insert a contact");

    

  }
  

  public static void main(final String[] args) throws Throwable {
    run(App::new, args);
  }
  
  private Integer newFriend(){
      nc = 0;
      for(Contato c: contatos){
          if(c.getId() > nc){
              nc = c.getId();
          }
      }
      return nc += 1;
  }
  
}
