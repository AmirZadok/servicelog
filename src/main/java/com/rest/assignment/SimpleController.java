package com.rest.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;


@RestController
public class SimpleController {

    static Logger LOG =  LoggerFactory.getLogger(SimpleController.class.getName());

    @GetMapping(path ="/api/time" , produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTime() {
        String now  = String.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
        LOG.info("Time requested at " + now);
        HashMap<String,String> result = new HashMap();
        result.put("time",now);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path="/api/log" , produces=MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<Object> getLog() throws IOException {
        File log = new File("logs\\spring-boot-logger.log");
        BufferedReader reader = new BufferedReader(new FileReader(log));
        StringBuilder result = new StringBuilder();
        while(true) {
            String logLine = reader.readLine();
            if (logLine == null) break;
            result.append(logLine + "\n");
        }

        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(result.toString());
    }
}