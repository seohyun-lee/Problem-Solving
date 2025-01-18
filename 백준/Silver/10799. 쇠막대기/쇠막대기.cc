#include <iostream>
#include <stack>
using namespace std;

int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  string s;
  long long ans = 0;
  stack<char> st;
  cin >> s;
  int sz = s.length();
  for (int i = 0; i < sz; i++) {
    if (s[i]=='(')
      st.push(s[i]);
    else {
      if (s[i-1] == '(') { 
        st.pop(); 
        ans+=st.size();
      }
      else { 
        st.pop();  
        ans++; 
      }
    }
  }
  cout << ans << "\n";
  return 0;
}