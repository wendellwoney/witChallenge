package com.wendellwoney.queue.Service;

public interface IQueueService {
     void sender(String queue, Object message, String uuid);
}
