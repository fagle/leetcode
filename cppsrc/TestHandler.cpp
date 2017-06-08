#include <iostream>
#include "HandlerMap.h"
#include "AHandler.h"
#include "BHandler.h"
#include "MessageHandler.h"
#include "Vlpp.h"
using namespace vl;
using namespace std;

TEST_CASE(TestHandlerMap)
{
	char sz[] = "Hello, World!";	//Hover mouse over "sz" while debugging to see its contents
	cout << sz << endl;	//<================= Put a breakpoint here
    REGISTRER_HANDLER(1, AHandler);
    REG_HANDLER_FUNC(2, BHandler);
    MessageHandler* handler = HandlerMap::GetHandler(1);
    handler->Process();
    HandlerFunc func = HandlerMap::GetHandlerFunc(2);
    func();
    func = HandlerMap::GetHandlerFunc(2);
    func();
    delete handler; 
}
