package com.mapp;


import java.util.List;

import com.models.ListTasks;
import com.models.Tasks;

public class RespList {
        
    public static ListTasks create(List<Tasks> tasks) { 
        return new ListTasks(tasks); 
    } 
}
