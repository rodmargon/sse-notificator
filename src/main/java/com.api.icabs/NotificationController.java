package com.api.icabs;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final Map<String, SseEmitter> userEmitters = new ConcurrentHashMap<>();

    @GetMapping(path ="/subscribe/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(@PathVariable String userId) {
        SseEmitter emitter = new SseEmitter();
        userEmitters.put(userId, emitter);

        emitter.onCompletion(() -> userEmitters.remove(userId, emitter));


        return emitter;
    }

    @PostMapping("/notify/{userId}")
    public void notifyClient(@PathVariable String userId)  {
        SseEmitter emitter = userEmitters.get(userId);
        if (emitter != null) {
            try {
                Notification notification = new Notification();
                notification.setFile("export");
                notification.setUsername(userId);
                notification.setUrl("http://localhost:8080/export/"+userId);
                notification.setStatus("COMPLETED");

                emitter.send(notification);
            } catch (IOException e) {
                userEmitters.remove(userId, emitter);
            }
        }

    }
}



