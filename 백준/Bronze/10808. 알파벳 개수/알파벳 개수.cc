#include<iostream>
using namespace std;

int alpha[26];
int main()
{
    string s;
    cin >> s;
    for(int i=0; i<s.size(); i++){
        int idx = s[i]-'a';
        if (idx >= 0 && idx < 26)
            alpha[idx]++;
    }
    for(int i=0; i<26; i++){
        cout << alpha[i] << " ";
    }
}