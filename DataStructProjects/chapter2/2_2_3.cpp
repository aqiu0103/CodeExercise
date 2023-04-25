#include<bits/stdc++.h>
using namespace std;
typedef struct lnode{
    int data;
    struct lnode *next;
}lnode;
int n;
void buildlist(lnode *&L){
    int x;
    L=NULL;
    L=(lnode*)malloc(sizeof(lnode));
    lnode *r=L;
    cout<<"输入n=";
    cin>>n;
    cout<<endl;
    cout<<"输入n个元素,构成一组数列"<<endl;
    for(int i=1;i<=n;i++){
        lnode *s=(lnode*)malloc(sizeof(lnode));
        cin>>x;
        s->data=x;
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
void reverselist(lnode *L,lnode *&l){
    l=(lnode*)malloc(sizeof(lnode));
    lnode *p=L->next;
    lnode *s=(lnode*)malloc(sizeof(lnode));
    s->data=p->data;
    l->next=s;   
    //先让第一个元素连上l
    p=p->next;
    for(int i=2;i<=n;i++){
        lnode *s=(lnode*)malloc(sizeof(lnode));
        s->data=p->data;
        s->next=l->next;
        l->next=s;
        p=p->next;
    }
}
int main(){
    lnode *L,*l;
    buildlist(L);
    cout<<"现数列为"<<endl;
    display(L);
    reverselist(L,l);
    cout<<"置换数列后为"<<endl;
    display(l);
    return 0;
}