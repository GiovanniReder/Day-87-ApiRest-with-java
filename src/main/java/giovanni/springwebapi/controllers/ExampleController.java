package giovanni.springwebapi.controllers;

import giovanni.springwebapi.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Examples")
public class ExampleController {
    @GetMapping("/getExample")
    public String getExample(){
        return "Ciao io rispondo alle get degli utenti";
    }
    @GetMapping("/postExample")
    public String postExample(){
        return "Ciao io rispondo alle post degli utenti";
    }
    @GetMapping("/putExample")
    public String putExample(){
        return "Ciao io rispondo alle put degli utenti";
    }
    @GetMapping("/deleteExample")
    public String deleteExample(){
        return "Ciao io rispondo alle delete degli utenti";
    }

    @GetMapping("/")
    public String get(){
        return "GET";
    }
    @PostMapping("/")
    public String post(){
        return "POST";
    }
    @PutMapping("/")
    public String put(){
        return "PUT";
    }
    @DeleteMapping ("/")
    public String delete(){
        return "DELETE";
    }

    @GetMapping("/pathParamExample/{parametro}")
    public String pathParamExample(@PathVariable String parametro){
        return "il parametro che hai inserito è: " + parametro;
    }
    @GetMapping("/queryParamsExample")
    public String queryParamsExample(@RequestParam(required = false) String name , @RequestParam String surname ){
        return "il parametro che hai inserito è: " + name + " " + surname ;
    }

    @PostMapping("/payloadexample")

    public User payloadexample(@RequestBody User body){
        System.out.println("payload");
        System.out.println(body);
        return body;
    }
}
