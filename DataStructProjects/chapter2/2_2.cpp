#include<bits/stdc++.h>
using namespace std;
#define Max 50
struct SqList{
    int a[Max]={1,2,3,4,5,6,7,8};
    int length=8;
};
void swap(int &x,int &y){
    int temp;
    temp=x;
    x=y;
    y=temp;
}
bool exchangelist(SqList &s){
    if(s.length==0)
        return 0;
    for(int i=0;i<s.length/2;i++){
        swap(s.a[i],s.a[s.length-i-1]);
    }
    return true;
}
int main(){
    SqList s;
    cout<<"原顺序表为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    exchangelist(s);
    cout<<"现顺序表为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    return 0;
}