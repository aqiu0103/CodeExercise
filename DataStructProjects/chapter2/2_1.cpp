#include <bits/stdc++.h>
using namespace std;
#define Max 50
struct sqlist
{
    int a[Max] = {2, 3, 4, 6, 7, 1, 8, 9};
    int length=8;
};
bool listdelete(sqlist &s, int &x)
{
    if (s.length == 0)
        return false;
    int min=s.a[0];
    int flag=0;
    for(int i=1;i<s.length;i++){
        if(s.a[i]<min){
            min=s.a[i];
            flag=i;
        }
    }
    x=s.a[flag];
    s.a[flag]=s.a[s.length--];
    return true;
}
int main(){
    sqlist s;
    cout<<"原顺序表为"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" "; 
    }
    cout<<endl;
    int k;
    listdelete(s,k);
    cout<<"最小元素为:"<<k<<endl;
    cout<<"线性表变为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    return 0;
}