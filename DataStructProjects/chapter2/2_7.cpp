#include<bits/stdc++.h>
using namespace std;
#define Max 50
struct SqList{
    int a[Max]={2,4,6,8};
    int b[Max]={1,3,5,7,9};
    int c[Max]={};
    int a_length=4;
    int b_length=5;
    int c_length=0;
};
bool mergelist(SqList s1,SqList s2,SqList &s3){
    if(s1.a_length==0||s2.b_length==0)
        return 0;
    int i=0,j=0,k=0;
    while(i<s1.a_length&&j<s2.b_length){
        if(s1.a[i]<=s2.b[j]){
            s3.c[k++]=s1.a[i];
            i++;
            j++;
        }
        else{
            s3.c[k++]=s2.b[j];
            i++;
            j++;
        }
    }
    if(s1.a_length<s2.b_length){
        while(j<s2.b_length)
            s3.c[k++]=s2.b[j];
        s3.c_length=k-1;
        return true;
    }
    if(s1.a_length>s2.b_length){
        while(i<s1.a_length)
            s3.c[k++]=s1.a[j];
        s3.c_length=k-1;
        return true;
    }
    if(s1.a_length==s2.b_length)
    s3.c_length=k-1;
    return true;
}
int main(){
     SqList s1;
     SqList s2;
     SqList s3;
    cout<<"原数列为:"<<endl;
    for(int i=0;i<s1.a_length;i++){
        cout<<s1.a[i]<<" ";
    }
    cout<<endl;
    for(int i=0;i<s2.b_length;i++){
        cout<<s2.b[i]<<" ";
    }
    cout<<endl;
    mergelist(s1,s2,s3);
    cout<<"合并s1、s2后的数列为:"<<endl;
    for(int i=0;i<s3.c_length;i++){
        cout<<s3.c[i]<<" ";
    }
    cout<<endl;
    return 0;
}