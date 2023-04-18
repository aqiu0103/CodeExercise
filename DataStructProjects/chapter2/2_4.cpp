#include<bits/stdC++.h>
using namespace std;
#define Max 50
struct SqList{
    int a[Max]={1,2,3,4,5,6,7,8,9};
    int length=9;
};
bool listdelete(SqList &s,int x,int y){
    int flag=y-x-1;
    if(s.length==0||x>=y)
        return false;
    for(int i=y-1;i<s.length;i++){
        s.a[i-flag]=s.a[i];
    }
    s.length=s.length-flag;
    return true;
}
int main(){
    SqList s;
    cout<<"原数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    listdelete(s,2,8);
    cout<<"删除2和8之间的元素后的数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.a[i]<<" ";
    }
    cout<<endl;
    return 0;
}