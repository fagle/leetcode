#pragma once
class MessageHandler
{
public:
    MessageHandler();
    ~MessageHandler();
    virtual void Process()=0;
};

