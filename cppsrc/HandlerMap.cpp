#include "HandlerMap.h"
#include "MessageHandler.h"
#include "AHandler.h"
#include <assert.h>
#include <iostream>
using std::unordered_map;
using namespace std;
HandlerMap::HandlerMap()
{
}


HandlerMap::~HandlerMap()
{
}

std::unordered_map<int, ConstructFunc> HandlerMap::handler_map;
std::unordered_map<int, HandlerFunc> HandlerMap::handler_func_map;

void HandlerMap::Register(int id, ConstructFunc handler_construct) {
    handler_map[id] = handler_construct;
}

void HandlerMap::Register(int id, HandlerFunc func) {
    handler_func_map[id] = func;
}

MessageHandler* HandlerMap::GetHandler(int id) {
    MessageHandler* handler = nullptr;
    /*switch(id) {
    case 1:
        handler = new AHandler;
        break;
    case 2:
        break;
    default:
        break;
    }*/
    ConstructFunc func = handler_map[id];
    handler = func();
    return handler;
}


HandlerFunc HandlerMap::GetHandlerFunc(int id) {
    HandlerFunc func = handler_func_map[id];
    if (func == nullptr)
        cout << "func not exist, id=" << id << endl;
    return func;
}
