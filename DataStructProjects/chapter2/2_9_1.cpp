#include<bits/stdc++.h>
using namespace std;
#define Max 50
struct SqList{
    int data[Max];
    int length;
};
void relist(SqList &s,int x){
    int i=0,j=s.length,k;
    while(i<=j){
        k=(i+j)/2;
        if(x<s.data[k]) j=k-1;
        if(x>s.data[k]) i=k+1;
        if(x=s.data[k]) break;
    }
    if(i<=j){   //不是被迫退出循环，与后面的元素交换
        if(k=s.length-1){
            s.data[s.length]=x;
        s.length++;
        }       //若x为最后一个元素，则在数列最后加上x
        else{
            int temp;
            temp=s.data[k];
            s.data[k]=s.data[k+1];
            s.data[k+1]=temp;
        }
    }
    if(i>j){    //是被迫退出循环的，将x插入原数列
        for(int m=s.length-1;m>=k;m--){
            s.data[m+1]=s.data[m];
        }
        s.data[k]=x;
        s.length++;
    }
}
int main(){
    SqList s={{1,2,4,5,6,7,8,9},8};
    cout<<"原数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.data[i]<<" ";
    }
    cout<<endl;
    relist(s,2);
    cout<<"现数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.data[i]<<" ";
    }
    return 0;
}