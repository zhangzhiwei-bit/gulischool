package com.it.msmservice.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface MsmService {
    boolean send(Map<String, Object> parma, String phone) throws ExecutionException, InterruptedException;
}
