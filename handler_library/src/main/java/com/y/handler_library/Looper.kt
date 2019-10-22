package com.y.handler_library

class Looper {

    lateinit var mMessageQueue: MessageQueue

    companion object{
        private val mThreadLocal = ThreadLocal<Looper>()

        fun prepare(){
            if(mThreadLocal.get() != null){
                throw RuntimeException("Looper has prepared,thread has only one Looper")
            }
            mThreadLocal.set(Looper())
            mThreadLocal.get()!!.mMessageQueue = MessageQueue()
        }

        /**
         * 主线程的Looper创建是在ActivityThread中的程序入口main()中
         */
        fun myLooper(): Looper?{
            if(mThreadLocal.get() == null){
                prepare()
                loop()
            }
            return mThreadLocal.get()
        }

        fun loop(){
            val queue = myLooper()!!.mMessageQueue
            while (true){
                val msg = queue.next()
                if(msg != null){
                    msg.target!!.dispatchMessage(msg)
                }
            }
        }
    }


}