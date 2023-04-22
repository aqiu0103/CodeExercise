#include<bits/stdc++.h>
using namespace std;
typedef struct lnode{
    int data;
    struct lnode *next;
}LNode;
int a[5]={1,2,3,4,5};
int n=5;
void buildlist(LNode *L){
    LNode *s=(LNode*)malloc(sizeof(LNode));
    LNode *r=L;
    if(n==0) L=NULL;
    else{
        s->data=a[0];
        L=s;
        for(int i=1;i<n;i++){
            s=(LNode*)malloc(sizeof(LNode));
            s->data=a[i];
            r->next=s;
            r=r->next;
        }
        r->next=NULL;
    }
}
void display(LNode *L){
    LNode *r=L;
    while(r!=NULL){
        cout<<(r->data)<<" ";
        r=r->next;
    }
    cout<<endl;
}
void delete_x(LNode *&L,int x){
    LNode *p;
    if(L==NULL) return;
    if(L->data==x){
        p=L;
        L=L->next;
        free(p);
        delete_x(L,x);
    }
    else delete_x(L->next,x);
}
int main(){
    LNode list;
    LNode *L=&list;
    buildlist(L);
    display(L);
    delete_x(L,2);
    display(L);
    return 0;
}