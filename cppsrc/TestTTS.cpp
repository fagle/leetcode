// 文本转语音冒烟测试。

#include "stdafx.h"
#include "sapi.h"
#include "sphelper.h"
#include "test.h"
#include <iostream>
using namespace std;

TEST_CASE(TestTTS) {
	::CoInitialize(NULL);
	CLSID CLSID_SpVoice;
	CLSIDFromProgID(_T("SAPI.SpVoice"), &CLSID_SpVoice);
	ISpVoice *pSpVoice = NULL;
	IEnumSpObjectTokens *pSpEnumTokens = NULL;
	CoCreateInstance(CLSID_SpVoice, NULL, CLSCTX_INPROC_SERVER, IID_ISpVoice, (void**)&pSpVoice);
	SpEnumTokens(SPCAT_VOICES, NULL, NULL, &pSpEnumTokens);
	ULONG ulTokensNumber = 0;
	pSpEnumTokens->GetCount(&ulTokensNumber);
	ISpObjectToken *pSpToken = NULL;
	pSpEnumTokens->Item(2, &pSpToken);
	pSpVoice->SetVoice(pSpToken);
	pSpVoice->Speak(L"hello，这是一个文本转语音测试。", SPF_DEFAULT, NULL);
	pSpVoice->Release();
	pSpEnumTokens->Release();
	::CoUninitialize();
}
