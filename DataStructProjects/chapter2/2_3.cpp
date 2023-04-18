#include<bits/stdc++.h>
using namespace std;
#define Max 50
struct SqList{
    int a[Max]={1,2,3,4,5,6,3,2,7};
    int length=9;
};
bool valuedelete(SqList &s,int x){
    if(s.length==0)
        return false;
    int temp=0;
    for(int i=0;i<s.length;i++){
        if(s.a[i]==x)
            temp++;
        else
            s.a[i-temp]=s.a[i];
    }
    s.length=s.length-temp;
    return true;
}
int main(){
    SqList s;
    cout<<"原数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    valuedelete(s,3);
    cout<<"删除3后的数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    return 0;
}
