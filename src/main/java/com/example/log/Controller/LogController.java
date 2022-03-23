package com.example.log.Controller;

import com.example.log.Entity.Log;
import com.example.log.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//configure this class as controller
@RestController
//to map web requests of subscriber to this class
@RequestMapping(path="/logSystem")
public class LogController {

    // link between the Services and controller to allow the implementation of the services base on the web request
    @Autowired
    LogService logService;

    //map the HTTP POST requests with the certain path to the associate method
    @RequestMapping(path="/add/{id}")

    /*@RequestBody: bound the value of the HTTP request body to specified parameter.
     * addNewLog: add new log to the log table
     */
    public Log addNewLog (@PathVariable("id") Long id) {

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("###"+ restTemplate.getForObject("http://localhost:8083/emailIntegration/getUserLog/"+id,Log.class));
        Log log = restTemplate.getForObject("http://localhost:8083/emailIntegration/getUserLog/"+id,Log.class);
        return logService.addLog(log);
    }

    //map the HTTP GET requests with the certain path to the associate method
    @GetMapping(path="/logs")

    // return all the logs in the log table
    public Iterable<Log> getLogs() {
        return logService.getAllLogs();
    }

    @GetMapping(path="log/{id}")

    //indicate that the result would be written straight in the response body
    @ResponseBody

    /*@PathVariable: extract the value from the URI and bind it to parameter.
     * return  log from log table
     */
    public Iterable<Log>  getUser(@PathVariable ("id") Long id) {
        return logService.getLog(id);
    }

}
