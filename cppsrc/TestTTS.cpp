// TestVoice.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "sapi.h"
#include "sphelper.h"
#include "Vlpp.h"
#include <iostream>
using namespace std;

TEST_CASE(TestTTS) {
	::CoInitialize(NULL);             // COM初始化
	CLSID CLSID_SpVoice;
	CLSIDFromProgID(_T("SAPI.SpVoice"), &CLSID_SpVoice);
	ISpVoice *pSpVoice = NULL;
	IEnumSpObjectTokens *pSpEnumTokens = NULL;
	CoCreateInstance(CLSID_SpVoice, NULL, CLSCTX_INPROC_SERVER, IID_ISpVoice, (void**)&pSpVoice);
	SpEnumTokens(SPCAT_VOICES, NULL, NULL, &pSpEnumTokens);
	ULONG ulTokensNumber = 0;
	pSpEnumTokens->GetCount(&ulTokensNumber);
	ISpObjectToken *pSpToken = NULL;
	pSpEnumTokens->Item(2, &pSpToken);//上面代码可以知道语音包的序号多少
	pSpVoice->SetVoice(pSpToken);
	pSpVoice->Speak(L"hello,this is a test,您好，现在是晚上时间19:33，今天天气多云，本节目是由\
		掏出来搞事情的小米手机独家冠名播出", SPF_DEFAULT, NULL);     // 朗读中文和英文的混合字符串
	pSpVoice->Release();
	pSpEnumTokens->Release();
	::CoUninitialize();
}
