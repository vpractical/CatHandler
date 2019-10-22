package com.y.handler_library

import java.util.concurrent.LinkedBlockingQueue

class MessageQueue {
    private val blockingQueue = LinkedBlockingQueue<Message>()

    fun enqueue(msg: Message){
        blockingQueue.add(msg)
    }

    fun next(): Message?{
        return blockingQueue.take()
    }
}