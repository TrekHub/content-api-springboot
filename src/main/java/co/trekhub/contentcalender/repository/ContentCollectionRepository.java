package co.trekhub.contentcalender.repository;

import co.trekhub.contentcalender.model.Content;
import co.trekhub.contentcalender.model.Status;
import co.trekhub.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();
    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return  contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }


    //create an initial content for testing
    @PostConstruct
    private void init() {
        Content c = new Content(
                1,
                "My first Blog",
                "My first blog post on this platform",
                Status.IDEA,
                Type.TEXT,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(c);
    }


    public boolean existsById(Integer id) {
        return  contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }
}



