package com.example.log.Controller;

import com.example.log.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//configure this class as controller
@RestController
// map web requests  path to this class
@RequestMapping(path="/LogSystem")
public class Statement {

    // link between the Services and controller to allow the implementation of the services base on the web request
    @Autowired
    LogService logService;


    //map the HTTP GET requests with the certain path to the associate method
    @GetMapping(path="balance/{id}")

    //indicate that the result would be written straight in the response body
    @ResponseBody

    /*@PathVariable: extract the value from the URI and bind it to parameter.
     * getUser: return user balance
     */
    public String getUserBalance(@PathVariable("id") Long id) {
        String balance = "Your Current Balance is: "+logService.getUserBalance(id);
        return balance;
    }


    @GetMapping(path="history/{id}")
    @ResponseBody

    // return  all the user logs from user_log table
    public List<String> getUserStatement(@PathVariable("id") Long id) {

        String transType;
        double balance;
        Date date;
        int size = logService.getLog(id).size()-1;
        List<String> list = new ArrayList<>();
        // get all users details from the user_log table
        System.out.println(logService.getLog(id).get(0).getUserBalance());
        for(int i=0; i<=size;i++ ){
        balance = logService.getLog(id).get(i).getUserBalance();
        transType = logService.getLog(id).get(i).getTransactionType();
        date = logService.getLog(id).get(i).getCurrentDate();
        String lastTrans = "Your Process is "+transType+" at "+date+". Your Current Balance is: "+balance;
        list.add(lastTrans);
        }
        return list;
    }
}
