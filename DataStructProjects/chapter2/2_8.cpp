#include<bits/stdc++.h>
using namespace std;
#define Max 50
struct SqList{
    int data[Max]={1,2,3,4,5,6,7,8,9};
    int length=9;
};
void relist(SqList &s,int left,int right){
    int temp;
    for(int i=left-1;i<(right+left+2)/2;i++){
        temp=s.data[i];
        s.data[i]=s.data[right-1];
        s.data[right-1]=temp;
        right--;
    }
}
int main(){
    int m,n;
    SqList s;
    cout<<"原数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.data[i]<<" ";
    }
    cout<<endl;
    cout<<"输入m、n的值=";
    cin>>m;
    cin>>n;
    relist(s,1,9);

    relist(s,1,n);
    relist(s,n+1,m+n);
            cout<<"现数列为:"<<endl;
    for(int i=0;i<s.length;i++){
        cout<<s.data[i]<<" ";
    }
    return 0;
}
