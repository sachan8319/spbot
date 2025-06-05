
package com.sachan.spbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;

@RestController
public class BotController {

    @Autowired
    private ChatGPTService chatGPTService;

    @Autowired
    private PropertySearchService propertySearchService;

    @PostMapping("/webhook")
    public ResponseEntity<String> handleIncomingMessage(@RequestBody Map<String, Object> payload) {
        try {
            String message = "test"; // mock
            String sender = "whatsapp-id"; // mock

            String propertyReply = propertySearchService.search(message);
            String finalReply = chatGPTService.askGPT("User asked: " + message +
                                                       ". Based on our listings: " + propertyReply);

            return ResponseEntity.ok(finalReply);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
