package com.y.handler_library

open class Handler {
    private var mLooper: Looper? = Looper.myLooper()
    private var mMessageQueue: MessageQueue

    init {
        if(mLooper == null){
            throw IllegalStateException("not called Looper.prepare() and mLooper is null")
        }
        mMessageQueue = mLooper!!.mMessageQueue
    }

    /**
     * 发送消息，将消息放入队列
     */
    fun sendMessage(msg: Message){
        enqueueMessage(msg)
    }

    private fun enqueueMessage(msg: Message){
        msg.target = this
        mMessageQueue.enqueue(msg)
    }

    /**
     * 分发消息，回调handlerMessage()
     */
    fun dispatchMessage(msg: Message){
        handleMessage(msg)
    }

    open fun handleMessage(msg: Message){

    }
}