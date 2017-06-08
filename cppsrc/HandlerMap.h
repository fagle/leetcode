#pragma once

#include <unordered_map>
#include "MessageHandler.h"

class MessageHandler;

typedef MessageHandler* (*ConstructFunc)(void);
typedef void (*HandlerFunc)(void);

class HandlerMap
{
public:
    HandlerMap();
    ~HandlerMap();
    template<class T>
    static MessageHandler* HandlerCreator() {
        return new T;
    }
    static void Register(int id, ConstructFunc handler);
    static void Register(int id, HandlerFunc func);
    static MessageHandler* GetHandler(int id);
    static HandlerFunc GetHandlerFunc(int id);
private:
    static std::unordered_map<int, ConstructFunc> handler_map;
    static std::unordered_map<int, HandlerFunc> handler_func_map;
};

#define REGISTRER_HANDLER(id, handler) HandlerMap::Register(id, HandlerMap::HandlerCreator<handler>)
#define REG_HANDLER_FUNC(id, func) HandlerMap::Register(id, func::Process)
