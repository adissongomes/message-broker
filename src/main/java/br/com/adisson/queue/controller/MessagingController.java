package br.com.adisson.queue.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessagingController {

    @PostMapping("simple")
    public void sendToSimpleQueue(@RequestParam("message") String message) {

    }

    @PostMapping("exchange/a")
    public void sendToRouteA(@RequestParam("message") String message) {

    }

    @PostMapping("exchange/b")
    public void sendToRouteB(@RequestParam("message") String message) {

    }

}
