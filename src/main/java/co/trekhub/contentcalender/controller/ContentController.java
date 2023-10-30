package co.trekhub.contentcalender.controller;

import co.trekhub.contentcalender.model.Content;
import co.trekhub.contentcalender.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    // make a request and find all the pieces of content in the system
    @GetMapping("")
    public List<Content> findAll() {
        return  repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return  repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not Found!"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public  void create(@RequestBody Content content){
        repository.save(content);
    }
//hello
    @PutMapping("/{id}")
    public  void update(@RequestBody Content content,@PathVariable Integer id){
        if(!repository.existsById(id)){
          throw  new  ResponseStatusException(HttpStatus.NOT_FOUND,"Content not Found!");
        } else {
            repository.save(content);
        }
    }
}
