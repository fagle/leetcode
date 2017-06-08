// TestVoice.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include "sapi.h"
#include "sphelper.h"
#include "Vlpp.h"
#include <iostream>
using namespace std;

TEST_CASE(TestTTS) {
	::CoInitialize(NULL);             // COM��ʼ��
	CLSID CLSID_SpVoice;
	CLSIDFromProgID(_T("SAPI.SpVoice"), &CLSID_SpVoice);
	ISpVoice *pSpVoice = NULL;
	IEnumSpObjectTokens *pSpEnumTokens = NULL;
	CoCreateInstance(CLSID_SpVoice, NULL, CLSCTX_INPROC_SERVER, IID_ISpVoice, (void**)&pSpVoice);
	SpEnumTokens(SPCAT_VOICES, NULL, NULL, &pSpEnumTokens);
	ULONG ulTokensNumber = 0;
	pSpEnumTokens->GetCount(&ulTokensNumber);
	ISpObjectToken *pSpToken = NULL;
	pSpEnumTokens->Item(2, &pSpToken);//����������֪������������Ŷ���
	pSpVoice->SetVoice(pSpToken);
	pSpVoice->Speak(L"hello,this is a test,���ã�����������ʱ��19:33�������������ƣ�����Ŀ����\
		�ͳ����������С���ֻ����ҹ�������", SPF_DEFAULT, NULL);     // �ʶ����ĺ�Ӣ�ĵĻ���ַ���
	pSpVoice->Release();
	pSpEnumTokens->Release();
	::CoUninitialize();
}
