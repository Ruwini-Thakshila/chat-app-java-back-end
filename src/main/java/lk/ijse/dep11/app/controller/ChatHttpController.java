package lk.ijse.dep11.app.controller;

import lk.ijse.dep11.app.to.MessageTo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("api/v2/messages")
@CrossOrigin
public class ChatHttpController {

    private final List<MessageTo> chatMessages = new Vector<>();

    @GetMapping
    public List<MessageTo> retrieveMessages(){
        return chatMessages;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public MessageTo sendMessage(@RequestBody @Valid MessageTo message){
        chatMessages.add(message);
        return message;
    }
}
