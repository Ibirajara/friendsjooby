package com.friendsjooby;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Results;
import org.jooby.json.Jackson;


/**
 * @author Ibirajara Barrel Junior
 * Sistema de Agenta com inserção e busca de contato.
 */
public class App extends Jooby {
    ArrayList<Contato> contatos = new ArrayList<>();
    Integer nc;
    ObjectMapper mapper = new ObjectMapper();
  
 
  {
      use(new Jackson() );
    /**
     * @author Ibirajara Barrel Junior
     * Página de boas vindas.
     */
    get("/", () -> "Welcome to your Address book!!");
      
    /**
     * @author Ibirajara Barrel Junior
     * @param id um id,to tipo inteiro.
     * Página de busca de contato por id.
     * O id do usuario é passado como parâmetro.
     * Deve retornar o contato se encontrado, ou uma mensagem de não encontrado
     * quando for o caso.
     */
    get("/contacts:id", (req) -> {
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
        
    }).name("Find a contact by id.");
    /**
     * @author Ibirajara Barrel Junior
     * Retorna todos os contatos da lista.
     */
    get("/contacts", req -> {
            return contatos;
        }).name("list all contacts.");
    
    /**
     * @author Insere um contato. faz a verificaçao dos campos name e phone
     * e conclui a insersao, retornando um json do contato inserido.
     */
    post("/contacts", req -> {
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
  /**
   * Retorna o novo codigo do usuario.
   * @return id do novo usuario
   */
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
