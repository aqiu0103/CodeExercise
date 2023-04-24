#include<bits/stdc++.h>
using namespace std;
#define Max 50
typedef struct lnode{
    int data;
    struct lnode *next;
}lnode;
int n;
void initlist(lnode *&L){    //初始化链表（可能不需要）

}
void buildlist(lnode *&L){    //创建一个单链表（尾插法）
    int x;
    int a[Max];  //可能不需要了
    L=(lnode*)malloc(sizeof(lnode));
    L->next=NULL;
    lnode *r=L;
    cout<<"输入n="<<endl;
    cin>>n;
    cout<<"输入n个元素,构成一组数列"<<endl;
    for(int i=1;i<=n;i++){
        cin>>x;
        lnode *s=(lnode*)malloc(sizeof(lnode));
        s->data=x;
        r->next=s;
        r=r->next;
    }
    r->next=NULL;
}
void display(lnode *L){
    lnode *p=L->next;
    for(int i=1;i<=n;i++){
        cout<<p->data<<" ";
        p=p->next;
    }
    cout<<endl;
}
void delete_x(lnode *&L,int x){
    if(L==NULL) return;
    if(L->data==x){
        lnode *p=L;
        L=L->next;
        free(p);
        delete_x(L,x);
        n--;
    }
    else
        delete_x(L->next,x);
}
int main(){
    lnode *L;
    int x;   //定义要查找的数
    buildlist(L);
    display(L);
    cout<<"输入要查找的数x="<<endl;
    cin>>x;
    delete_x(L,x);
    display(L);
    return 0;
}