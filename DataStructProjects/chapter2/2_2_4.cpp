#include<bits/stdc++.h>
using namespace std;
#define Max 50
typedef struct lnode{
    int data;
    struct lnode *next;
}lnode;
int a[Max]={2,4,5,3,1,8,5};
int n=7;
int flag;
void buildlist(lnode *&L){
    L=(lnode*)malloc(sizeof(lnode));
    lnode *r=L;
    for(int i=1;i<=n;i++){
        lnode *s=(lnode*)malloc(sizeof(lnode));
        s->data=a[i-1];
        r->next=s;
        r=r->next;
    }
    r->next=NULL;
}
void display(lnode *L){
    lnode *p;
    p=L->next;
    for(int i=1;i<=n;i++){
        cout<<p->data<<" ";
        p=p->next;
    }
    cout<<endl;
}
void findmin(lnode *L,int &flag){
    if(L==NULL) return;
    if(L->data<flag){
        flag=L->data;
        L=L->next;
    }
    else
        findmin(L->next,flag);
}
void deletemin(lnode *&L,int flag){
    if(L==NULL) return;
    if(L->data==flag){
        lnode *p=L;
        L=L->next;
        free(p);
        n--;
    }
    else deletemin(L->next,flag);
}
int main(){
    lnode *L;
    buildlist(L);
    cout<<"现数列为"<<endl;
    display(L);
    flag=L->next->data;
    findmin(L,flag);
    deletemin(L,flag);
    cout<<"现数列为"<<endl;
    display(L);
    return 0;
}