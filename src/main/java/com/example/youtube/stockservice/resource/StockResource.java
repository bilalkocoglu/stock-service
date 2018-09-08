package com.example.youtube.stockservice.resource;

import com.example.youtube.stockservice.dto.ExampleDto;
import com.example.youtube.stockservice.model.Person;
import com.example.youtube.stockservice.model.School;
import com.example.youtube.stockservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    private static Logger logger = LoggerFactory.getLogger(StockResource.class);

    private static final String dbServiceUri = "http://localhost:8302/api/db-service/rest/db";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestTemplate loadBalanced;

    @GetMapping("/{username}")
    public List<String> getUser(@PathVariable("username") final String username){

        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(dbServiceUri + "/" + username,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {});

        List<String> response = responseEntity.getBody();

        logger.info(String.valueOf(response));

        return response;
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
                    )
    @ResponseBody
    //@CrossOrigin(origins = "*")       CORSFilter sınıfı sayesinde çözüldü !
    public ResponseEntity getUserById(@PathVariable("id") int id){
        logger.info(String.valueOf(id));

        User response = restTemplate.getForObject(dbServiceUri + "/user/" + id, User.class);

        //logger.info(listUser.toString());x

        if(response != null )
            return new ResponseEntity(response, HttpStatus.OK);
        else
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
                    )
    @ResponseBody
    public ResponseEntity getAllUsers(){
        logger.info("Tüm kullanıcılar çağırıldı !");

        List<User> response2 = loadBalanced.getForObject(dbServiceUri + "/user" , List.class);
        if(response2!=null)
            logger.info(response2.toString());

        //List<User> response = restTemplate.getForObject(dbServiceUri + "/user" , List.class);

        if (response2 == null)
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        else if (response2.isEmpty())
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(response2, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user){

        logger.info("Gonderilen user --> name = " + user.getName() + "  / password = " + user.getPassword() );

        User response = restTemplate.postForObject(
                dbServiceUri + "/user/add" ,
                user,
                User.class);

        return new ResponseEntity(response, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/user/delete/{id}",
                    method = RequestMethod.DELETE,
                    produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
                    )
    @ResponseBody
    public ResponseEntity deleteUserById(@PathVariable("id") final int id){
        String uri = dbServiceUri + "/user/delete/{id}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        try {
            restTemplate.delete(uri, params);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.info(e.toString());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<ExampleDto> hello(@RequestParam("name") final String name,
                                            @RequestParam("password") final String password){
        logger.info("Angular'dan Gelen Parametreler => name = " + name + " ||| password => " + password);
        String example = name + " ! " + password;
        ExampleDto exampleDto = new ExampleDto(1 , name);
        return ResponseEntity.ok(exampleDto);
    }

    @GetMapping(value = "/dto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Person> dtoCreate (@RequestParam("name") final String name,
                                             @RequestParam("password") final String password){

        logger.info("dtoCreate Method");
        School school = new School(1, "Süleyman Demirel Üniversitesi", "Isparta");
        Person person = new Person(1, name,password,school);
        return ResponseEntity.ok(person);

    }
}
