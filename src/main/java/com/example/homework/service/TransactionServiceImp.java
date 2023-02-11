package com.example.homework.service;
import com.example.homework.domain.Page;
import com.example.homework.domain.Transaction;
import com.example.homework.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@Service
public class TransactionServiceImp implements TransactionService{
    @Value("${url}")
    String url;
    private  final RestTemplate restTemplate;
    @Autowired
    TransactionServiceImp(RestTemplate restTemplate){this.restTemplate =restTemplate;}

    @Override
    public Map<String, int[]> findAllPoint() {

        Date dNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dNow);
        calendar.add(Calendar.MONTH, -1);
        Date oneMonth= calendar.getTime();
        calendar.add(Calendar.MONTH, -2);
        Date twoMonth= calendar.getTime();

        Page page = restTemplate.getForObject(url,Page.class);
        List<Transaction> transactionList = page.getList();
        Map<String, int[]> TranList  = new HashMap<>();

        for(Transaction ele: transactionList){
            if(ele.getAmount() <0){
                throw new MyException("the data is not valid!");
            }

            if(!TranList.containsKey(ele.getCustomerId())) {
                TranList.put(ele.getCustomerId(),new int[4]);
            }
            TranList.get(ele.getCustomerId())[3]+=computerPoint(ele.getAmount());
            if(ele.getDate().after(oneMonth)){
                TranList.get(ele.getCustomerId())[0]+=computerPoint(ele.getAmount());

            }
            else if(ele.getDate().before(twoMonth)){
                TranList.get(ele.getCustomerId())[2]+=computerPoint(ele.getAmount());
            }
            else{ TranList.get(ele.getCustomerId())[1]+=computerPoint(ele.getAmount());}
        }

        return TranList;
    }

    private int computerPoint(int purchase ){
        if(purchase >100) return (purchase-100) * 2 + 50;
        if(purchase>50) return (purchase - 50) *1;
        return 0;
    }








}
