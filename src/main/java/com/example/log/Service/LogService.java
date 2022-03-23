package com.example.log.Service;
import com.example.log.Entity.Log;
import com.example.log.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

//configure this class as services
@Service
public class LogService {

    // link between the Services and Repositories to allow the implementation of the services in the database
    @Autowired
    LogRepository logRepository;

    @Autowired
    LogService logService;

    // add new log to the log  table
    public Log addNewLog(List<Log> logList){
        List<Log> re = new ArrayList<>();
        for(int i=0; i<logList.size();i++) {
            Log log = new Log();
            System.out.println("//////////");
            System.out.println(logList.get(i).getUserId());
            log.setUserName(logList.get(i).getUserName());
            log.setUserEmail(logList.get(i).getUserEmail());
            log.setUserBalance(logList.get(i).getUserBalance());
            log.setCurrentDate(logList.get(i).getCurrentDate());
            log.setUserId(logList.get(i).getUserId());
            log.setTransactionType(logList.get(i).getTransactionType());
            log.setTransactionAmount(logList.get(i).getTransactionAmount());
            re.add(log);
           logRepository.save(log);
        }
        return null;
    }

    public Log addLog(Log log){
            log.setUserName(log.getUserName());
            log.setUserEmail(log.getUserEmail());
            log.setUserBalance(log.getUserBalance());
            log.setCurrentDate(log.getCurrentDate());
            log.setUserId(log.getUserId());
            log.setTransactionType(log.getTransactionType());
            log.setTransactionAmount(log.getTransactionAmount());
            System.out.println("success in adding new log");
        return logRepository.save(log);
    }

    // return all the users in the user table
    public Iterable<Log> getAllLogs(){
        return logRepository.findAll();
    }

    /* @Param: extract value from the URI and bind it to parameter
     * getLog: return all user logs from the user_log table
     */
    public List<Log>  getLog(@Param("id") Long id) {

        //check the exist of such user in the user table
        List<Log>  log = logRepository.findAllByUserId(id);

        return log;
    }

    /*@PathVariable: extract the value from the URI and bind it to parameter.
     * getUser: return user balance
     */
    public double getUserBalance(@PathVariable("id") Long id) {
        double balance;
        int size = getLog(id).size();
        balance = getLog(id).get(size).getUserBalance();

        return balance;
    }

}
